package menu;

import java.awt.event.KeyEvent;

import graphics.Screen;
import graphics.Texture;

public class CharacterCreation extends Menu {
	// create ints, textures, and stuff here
	
	Texture creationBackground;
	
	int currentcharacter;
	
	// render
	public void render(Screen screen) {
		screen.drawRect(0, 0, 1000, 1000, 0x0000FF);
	}
	public void update() {
		
	}
	
	public void CharacterCreator() {
		currentcharacter = 0;	
		
		//creationBackground = ;
	}
	
	// Selection
	public void rightPressed() {				// active when you press right key
		if (currentcharacter < 5) {
			currentcharacter ++;
		}
		else {
			currentcharacter  = 0;
		}
	}
	public void leftPressed() {					// active when you press left key
		if (currentcharacter  > 0) {
			currentcharacter --;
		}
		else {
			currentcharacter  = 4;
		}
	}
	
	//When you press enter on selected thing
	public void enter() {
		switch(currentcharacter) {
			// character 1
			case 0:
				break;
			// character 2
			case 1:
				break;
			// character 3
			case 2:
				break;
			// character 4
			case 3:
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
