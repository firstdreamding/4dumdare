package menu;

import java.awt.event.KeyEvent;

import graphics.Screen;
import graphics.Texture;

public class Saves extends Menu {
	// create ints, textures, and stuff here
	
	Texture savesBackground;
	
	int currentsave;
	
	// render
	public void render(Screen screen) {
		screen.drawRect(0, 0, 1000, 1000, 0x0000FF);
	}
	public void update() {
		
	}
	
	public Saves() {
		currentsave = 0;	
		
		//savesBackground = ;
	}
	
	// Selection
	public void rightPressed() {				// active when you press right key
		if (currentsave < 3) {
			currentsave ++;
		}
		else {
			currentsave  = 0;
		}
	}
	public void leftPressed() {					// active when you press left key
		if (currentsave  > 0) {
			currentsave --;
		}
		else {
			currentsave  = 2;
		}
	}
	
	//When you press enter on selected thing
	public void enter() {
		switch(currentsave) {
			// save slot 1
			case 0:
				break;
			// save slot 2
			case 1:
				break;
			// save slot 3
			case 2:
				break;
		}
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
