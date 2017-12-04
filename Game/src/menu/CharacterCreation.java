package menu;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import main.Main;

public class CharacterCreation extends Menu {
	// create ints, textures, and stuff here
	
	Texture creationBackground;
	ArrayList<Texture> characterHighlight = new ArrayList<Texture>();
	
	// sprites
	SpriteSheet character1 = new SpriteSheet(new Texture("/sprites/player.png", 320, 192), 64, 64);
	SpriteSheet character2 = new SpriteSheet(new Texture("/sprites/player2.png", 320, 192), 64, 64);
	SpriteSheet character3 = new SpriteSheet(new Texture("/sprites/player3.png", 320, 192), 64, 64);
	SpriteSheet character4 = new SpriteSheet(new Texture("/sprites/player4.png", 320, 192), 64, 64);
	
	Texture character1Texture;
	Texture character2Texture;
	Texture character3Texture;
	Texture character4Texture;
	
	int currentcharacter;

	public CharacterCreation() {
		currentcharacter = 0;	
				
		// menu textures
		creationBackground = new Texture("/sprites/CharacterSelect1.png", 960, 540);
		
		characterHighlight.add(new Texture("1", "/sprites/CharacterSelect1.png", 960, 540));
		characterHighlight.add(new Texture("2", "/sprites/CharacterSelect2.png", 960, 540));
		characterHighlight.add(new Texture("3", "/sprites/CharacterSelect3.png", 960, 540));
		characterHighlight.add(new Texture("4", "/sprites/CharacterSelect4.png", 960, 540));
		
		// character textures
		character1Texture = character1.getTexture(0, 0);
		character2Texture = character2.getTexture(0, 0);
		character3Texture = character3.getTexture(0, 0);
		character4Texture = character4.getTexture(0, 0);
		
		//selector = new Texture("/sprites/Selector.png", 64, 64);
	}
	
	// render
	public void render(Screen screen) {
		screen.drawRect(0, 0, 1000, 1000, 0x0000FF);
		screen.drawTexture(0, 0, creationBackground);
		
		// y coords: 238 (exact center), 160 (under light)
		screen.drawTexture(160, 160, character1Texture);
		screen.drawTexture(352, 160, character2Texture);
		screen.drawTexture(544, 160, character3Texture);
		screen.drawTexture(736, 160, character4Texture);
		
		//screen.drawTexture(x, y, selector);
	}
	public void update() {
		
	}
	
	// pointer display logic
	public void Selector() {
		switch(currentcharacter) {
			case 0:
				// new position of selector
				creationBackground = characterHighlight.get(currentcharacter);
				break;
			case 1:
				creationBackground = characterHighlight.get(currentcharacter);
				break;
			case 2:
				creationBackground = characterHighlight.get(currentcharacter);
				break;
			case 3:
				creationBackground = characterHighlight.get(currentcharacter);
				break;
		}
	}
	
	// Selection
	public void rightPressed() {				// active when you press right key
		if (currentcharacter < 3) {
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
			currentcharacter  = 3;
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
