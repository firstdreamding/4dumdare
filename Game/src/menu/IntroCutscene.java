package menu;

import java.awt.Color;
import java.awt.Font;

import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import main.Animation;
import main.Main;

public class IntroCutscene extends Menu {
	Font f = new Font("Rockwell", Font.PLAIN, 30);
	
	final int left = -1;
	final int right = 1;
	final int up = -1;
	final int down = 1;
	
	int x, y;
	
	int movement;
	int time;
	int texttime;
	
	boolean cuetext;
	boolean done;
	
	Texture background;
	Texture presents;
	
	Texture playerTexture;

	SpriteSheet player = new SpriteSheet(new Texture("/sprites/player1.png", 320, 192), 64, 64);
	Texture walkingDown[] = { player.getTexture(1, 0), player.getTexture(2, 0), player.getTexture(3, 0),
			player.getTexture(4, 0) };
	Texture walkingUp[] = { player.getTexture(1, 1), player.getTexture(2, 1), player.getTexture(3, 1),
			player.getTexture(4, 1) };
	Texture walkingRight[] = { player.getTexture(1, 2), player.getTexture(2, 2), player.getTexture(3, 2),
			player.getTexture(4, 2) };
	Texture walkingLeft[] = { player.getTexture(1, 2), player.getTexture(2, 2), player.getTexture(3, 2),
			player.getTexture(4, 2) };
	Texture standing[] = { player.getTexture(0, 0) };

	private Animation animation;
	private Animation walkDown = new Animation(walkingDown, 10);
	private Animation walkUp = new Animation(walkingUp, 10);
	private Animation walkRight = new Animation(walkingRight, 10);
	private Animation walkLeft = new Animation(walkingLeft, 10);
	private Animation stand = new Animation(standing, 10);
	
	public IntroCutscene() {
		x = 0;
		y = 160;
		
		movement = 0;
		time = 0;
		texttime = 0;
		
		cuetext = false;
		done = false;
		
		background = new Texture("/sprites/CharacterBG.png", 960, 540);
		presents = new Texture("/sprites/Presents.png", 960, 540);
		playerTexture = player.getTexture(0, 0);
		
		animation = walkRight;
		System.out.println("cutscene started...");
	}
	
	public void render(Screen screen) {
		screen.drawTexture(0, 0, background);
		
		screen.drawTexture(x, y, animation.getSprite());
		if (cuetext == true) {
			screen.fillRectBlend(0, 0, 960, 540, 0x0000FF);
			if (texttime <= 100) {
				screen.drawString("In this world...", 300, 160, f, Color.white);
				texttime++;
			} else if (texttime > 100 && texttime <= 200) {
				screen.drawString("In this world...", 300, 160, f, Color.white);
				screen.drawString("It's kill or be killed.", 300, 238, f, Color.white);
				texttime++;
			} else if (texttime > 200 && texttime <= 350) {
				screen.drawTexture(0, 0, presents);
				texttime++;
			} else {
				done = true;
			}
		}
	}
	
	public void update() {
		animation.update();
		if (done == true) {
			Main.getInstance().menu = new MainMenu();
		} else {
			if (animation == walkRight && movement < 500) {
				animation.start();
				movement++;
				x = x + 2;
			} else {
				cuetext = true;
				time = 0;
				
				if (time < 500) {
					time++;
				} else {
					done = true;
				}
			}
		}
	}
}
