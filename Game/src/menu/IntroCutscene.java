package menu;

import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import main.Animation;
import main.Main;

public class IntroCutscene extends Menu {
	final int left = -1;
	final int right = 1;
	final int up = -1;
	final int down = 1;
	
	int x, y;
	
	int movement;
	
	boolean done;
	
	Texture background;
	
	Texture playerTexture;

	SpriteSheet player = new SpriteSheet(new Texture("/sprites/player.png", 320, 192), 64, 64);
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
		
		done = false;
		
		background = new Texture("/sprites/CharacterBG.png", 960, 540);
		playerTexture = player.getTexture(0, 0);
		
		animation = walkRight;
		System.out.println("cutscene started...");
	}
	
	public void render(Screen screen) {
		screen.drawTexture(0, 0, background);
		
		screen.drawTexture(x, y, animation.getSprite());
	}
	
	public void update() {
		animation.update();
		if (done == true) {
			Main.getInstance().menu = new MainMenu();
		} else {
			if (animation == walkRight && movement < 1000) {
				animation.start();
				movement++;
			} else {
				done = true;
			}
		}
	}
}
