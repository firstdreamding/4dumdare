package menu;

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
				
			// character 2
			case 1:
			
			// character 3
			case 2:
				
			// character 4
			case 3:
				
			// character 5
			case 4:
				
		}
	}
}
