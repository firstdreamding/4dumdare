package menu;

import graphics.SpriteSheet;
import graphics.Texture;
import main.Animation;

public class IntroCutscene extends Menu {
	final int left = -1;
	final int right = 1;
	final int up = -1;
	final int down = 1;
	
	int stepsRight = 0;
	
	Texture sprite;

	SpriteSheet player = new SpriteSheet(new Texture("/sprites/player4.png", 320, 192), 64, 64);
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
		stepsRight = 0;
		
		sprite = new Texture("/sprites/player4.png", 64, 64);
		animation = stand;
		System.out.println("cutscene running...");
	}
	
	public void cutsene() {
		sprite = animation.getSprite();
		animation = walkRight;
		if (stepsRight < 10) {
			stepsRight++;
		} else {
			
		}
	}
}
