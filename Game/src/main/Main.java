package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphics.Screen;
import graphics.Window;
import menu.CharacterCreation;
import menu.IntroCutscene;
import menu.MainMenu;
import menu.Menu;

public class Main {
	public final int W = 960;
	public final int H = 540;
	Window window;
	Screen screen;
	final int MENU = 0;
	final int GAME = 1;
	public int state = MENU; // Change to MENU for testing, but change it back when done
	private boolean running;
	private boolean isPause;
	private int fps = 60;
	private int overUpdateCounter;
	private int ups;
	private int frameCount = 0;
	Font tr = new Font("TimesRoman", Font.PLAIN, 18);
	MainMenu mainmenu = new MainMenu();
	CharacterCreation charactermenu = new CharacterCreation();
	IntroCutscene introcutscene = new IntroCutscene();
	public Menu menu = introcutscene;
	public Level level;
	static Main instance;
	
	public static Main getInstance() {
		return instance;
	}

	public Main() {
		instance = this;
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
		main.gameLoop();
	}

	private void init() {
		running = true;
		isPause = false;
		window = new Window("Connect Subjects", W, H);
		screen = window.getScreen();
		window.show();
		level = new Level();		
		SoundEffect.init();
	    SoundEffect.volume = SoundEffect.Volume.LOW;
	    new SoundEffect("Sound.wav", true);

		// KEYLISTEN
		window.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseClicked(e);
				if (level.inGameMenu) {
					level.getiGMenu().click(e.getPoint());
				}
				System.out.println(e.getX() + "," + e.getY());

			}
		});
		window.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (state == GAME)
					level.player.keyPressed(e.getKeyCode());
				else
					menu.keyPressed(e.getKeyCode());

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (state == GAME) {
					level.player.keyReleased(e.getKeyCode());
				}
			}

		});
	}

	private void gameLoop() {
		final double HERTZ = 60.0;
		final double TIME_BETWEEN_UPDATES = 1000000000 / HERTZ;
		final int MAX_UPDATES_BEFORE_RENDER = 2;
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();

		// If we are able to get as high as this FPS, don't render again.
		final double TARGET_FPS = 60;
		// 1000000000 = amount of nanoseconds in 1 second.
		final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;

		// Simple way of finding FPS.
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);

		while (running) {
			double now = System.nanoTime();
			int updateCount = 0;

			if (!isPause) {
				// Do as many game updates as we need to. Might need to stop
				// updates
				// to allow render to catchup is cpu is slowing down.
				while (now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER) {
					// put update clause here ex: level.update(); game update
					update();
					lastUpdateTime += TIME_BETWEEN_UPDATES;
					overUpdateCounter++;
					updateCount++;
				}
				// Catchup
				if (now - lastUpdateTime > TIME_BETWEEN_UPDATES) {
					lastUpdateTime = now - TIME_BETWEEN_UPDATES;
				}

				// TODO: Figure out interpolation
				float interpolation = Math.min(1.0f, (float) ((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));

				// Render
				render(screen);

				lastRenderTime = now;

				// Update the frames we got.
				int thisSecond = (int) (lastUpdateTime / 1000000000);
				if (thisSecond > lastSecondTime) {
					fps = frameCount;
					ups = overUpdateCounter;
					overUpdateCounter = 0;
					frameCount = 0;

					lastSecondTime = thisSecond;
				}

				// Yield until it has been at least the target time between
				// renders. This saves the CPU from hogging.
				while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS
						&& now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
					Thread.yield();
					try {
						Thread.sleep(1);
					} catch (Exception e) {
					}
					now = System.nanoTime();
				}
			}
		}
	}

	public void stop() {
		running = false;
	}

	private void render(Screen screen) {
		window.update();
		screen.clear(0xffffff);
		if (state == MENU) {
			menu.render(screen);
		} else if (state == GAME) {
			screen.drawString("Fps " + fps, 40, 40, tr, Color.black);
			screen.drawString("Ups " + ups, 40, 80, tr, Color.black);
			level.render(screen);
			frameCount++;
		}
	}

	private void update() {
		if (state == MENU) {
			menu.update();
		} else if (state == GAME) {
			level.update();
		}
	}

}
