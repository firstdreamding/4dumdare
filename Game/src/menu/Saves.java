package menu;

import java.awt.event.KeyEvent;

import graphics.Screen;
import graphics.Texture;
import main.Main;

public class Saves extends Menu {
	// create ints, textures, and stuff here
	
	Texture savesBackground;
	
	int currentsave;
	
	public Saves() {
		currentsave = 0;	
		
		savesBackground = new Texture("/sprites/SavesBG.png", 960, 540);
	}
	
	// render
	public void render(Screen screen) {
		//screen.drawRect(0, 0, 1000, 1000, 0x0000FF);
		
		screen.drawTexture(0, 0, savesBackground);
	}
	public void update() {
		
	}
	
	// Selection
	public void rightPressed() {				// active when you press right key
		if (currentsave < 2) {
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
	public void escape() {
		Main.getInstance().menu = new MainMenu();
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
			case KeyEvent.VK_ESCAPE:
				escape();
				break;
		}
	}
}
