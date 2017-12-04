package menu;

import java.awt.event.KeyEvent;

import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import main.Main;

public class CharacterCreation extends Menu {
	// create ints, textures, and stuff here
	
	Texture creationBackground;
	
	// sprites
	SpriteSheet character1 = new SpriteSheet(new Texture("/sprites/player.png", 320, 192), 64, 64);
	SpriteSheet character2 = new SpriteSheet(new Texture("/sprites/player2.png", 320, 192), 64, 64);
	SpriteSheet character3 = new SpriteSheet(new Texture("/sprites/player3.png", 320, 192), 64, 64);
	SpriteSheet character4 = new SpriteSheet(new Texture("/sprites/player4.png", 320, 192), 64, 64);
	
	Texture character1Texture;
	Texture character2Texture;
	Texture character3Texture;
	Texture character4Texture;
	
	Texture selector;
	
	int currentcharacter;
	
	int x;
	int y;
	
	int x0;
	int y0;
	int x1;
	int y1;
	int x2;
	int y2;
	int x3;
	int y3;
	int x4;
	int y4;
	
	public CharacterCreation() {
		currentcharacter = 0;	
		
		// starting position for selector
		x0 = 96;					// x of selector
		y0 = 238;					// y of selector
		
		// more positions
		x1 = 288;
		y1 = 238;
		
		x2 = 480;
		y2 = 238;
		
		x3 = 672;
		y3 = 238;
		
		// setting start position of selector
		x = x0;
		y = y0;
		
		// textures
		//creationBackground = new Texture ("/sprites/", 960, 540) ;
		
		character1Texture = character1.getTexture(0, 0);
		character2Texture = character2.getTexture(0, 0);
		character3Texture = character3.getTexture(0, 0);
		character4Texture = character4.getTexture(0, 0);
		
		selector = new Texture("/sprites/Selector.png", 64, 64);
	}
	
	// render
	public void render(Screen screen) {
		screen.drawRect(0, 0, 1000, 1000, 0x0000FF);
		//screen.drawTexture(0, 0, creationBackground);
		
		screen.drawTexture(160, 238, character1Texture);
		screen.drawTexture(352, 238, character2Texture);
		screen.drawTexture(544, 238, character3Texture);
		screen.drawTexture(736, 238, character4Texture);
		
		screen.drawTexture(x, y, selector);
	}
	public void update() {
		
	}
	
	// pointer display logic
	public void Selector() {
		switch(currentcharacter) {
			case 0:
				// new position of selector
				x = x0;
				y = y0;
				break;
			case 1:
				x = x1;
				y = y1;
				break;
			case 2:
				x = x2;
				y = y2;
				break;
			case 3:
				x = x3;
				y = y3;
				break;
		}
	}
	
	// Selection
	public void rightPressed() {				// active when you press right key
		if (currentcharacter < 5) {
			currentcharacter ++;
			Selector();
		}
		else {
			currentcharacter  = 0;
			Selector();
		}
	}
	public void leftPressed() {					// active when you press left key
		if (currentcharacter  > 0) {
			currentcharacter --;
			Selector();
		}
		else {
			currentcharacter  = 4;
			Selector();
		}
	}
	
	//When you press enter on selected thing
	public void enter() {
		switch(currentcharacter) {
			// character 1
			case 0:
				Main.getInstance().level.player.playerChange( new SpriteSheet(new Texture("/sprites/player.png", 320, 192), 64, 64));
				Main.getInstance().state = 1;
				break;
			// character 2
			case 1:
				Main.getInstance().level.player.playerChange( new SpriteSheet(new Texture("/sprites/player2.png", 320, 192), 64, 64));
				Main.getInstance().state = 1;
				break;
			// character 3
			case 2:
				Main.getInstance().level.player.playerChange( new SpriteSheet(new Texture("/sprites/player3.png", 320, 192), 64, 64));
				Main.getInstance().state = 1;
				break;
			// character 4
			case 3:
				Main.getInstance().level.player.playerChange( new SpriteSheet(new Texture("/sprites/player4.png", 320, 192), 64, 64));
				Main.getInstance().state = 1;
				break;
			// character 5
			case 4:
				break;
		}
	}
	
	public void nameGang() {
		
	}
	
	// key listener
	public void keyPressed(int code) {
		switch(code) {
			case KeyEvent.VK_RIGHT:
				rightPressed();
				break;
			case KeyEvent.VK_LEFT:
				leftPressed();
				break;
				
			case KeyEvent.VK_ENTER:
				enter();
				break;
		}
	}
	
}
