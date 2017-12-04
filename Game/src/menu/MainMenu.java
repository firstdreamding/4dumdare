package menu;

import java.awt.event.KeyEvent;

import graphics.Screen;
import graphics.Texture;
import main.Main;

public class MainMenu extends Menu {
	// create ints, textures, and stuff here
	
	Texture menuBackground;
	Texture menuOptions;
	Texture gameTitle;
	Texture selector;
	
	Texture controls;
	Texture credits;
	
	int x, y;
	
	int x0, y0;
	int x1, y1;
	int x2, y2;
	int x3, y3;
	int x4, y4;
	
	int currentselection;
	
	boolean displayControls;
	boolean displayCredits;
	
	// constructor
	public MainMenu() {
		currentselection = 0;		// the selected thing
		
		displayControls = false;
		displayCredits = false;
		
		// starting position for selector
		x0 = 690;					// x of selector
		y0 = 275;					// y of selector
		
		// more positions
		x1 = 700;
		y1 = 320;
		
		x2 = 690;
		y2 = 370;
		
		x3 = 720;
		y3 = 415;
		
		x4 = 780;
		y4 = 460;
		
		// setting start position of selector
		x = x0;
		y = y0;
		
		// textures
		//menuBackground = new Texture("/sprites/.png", 960, 540);
		menuOptions = new Texture("/sprites/MainMenu.png", 960, 540);
		gameTitle = new Texture("/sprites/Name.png", 960, 540);
		selector = new Texture("/sprites/Selector.png", 64, 64);
		
		controls = new Texture("/sprites/Controls.png", 960, 540);
		credits = new Texture("/sprites/Credits.png", 960, 540);
	}
	
	// render
	public void render(Screen screen) {
		screen.fillRect(0, 0, 960, 540, 0x000000);
		//screen.drawTexture(0, 0, menuBackground);
		screen.drawTexture(0, 0, menuOptions);
		screen.drawTexture(0, 0, gameTitle);
		
		screen.drawTexture(x, y, selector);
		
		if (displayControls == true) {
			screen.drawTexture(0, 0, controls);
		}
		if (displayCredits == true) {
			screen.drawTexture(0, 0, credits);
		}
	}
	public void update() {
		
	}
	
	// pointer display logic
	public void Selector() {
		switch(currentselection) {
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
			case 4:
				x = x4;
				y = y4;
				break;
		}
	}
	
	// Selection
	public void downPressed() {				// active when you press down key
		if (currentselection < 4) {
			currentselection++;
			Selector();
		} else {
			currentselection = 0;
			Selector();
		}
	}
	public void upPressed() {				// active when you press up key
		if (currentselection > 0) {
			currentselection--;
			Selector();
		} else {
			currentselection = 4;
			Selector();
		}
	}
	// When you press enter on selected thing
	public void enter() {
		switch(currentselection) {
			// new game
			case 0:
				Main.getInstance().menu = new CharacterCreation();
				break;
			// continue game
			case 1:
				Main.getInstance().menu = new Saves();
				break;
			// options/help
			case 2:
				displayControls = true;
				break;
			// credits
			case 3:
				displayCredits = true;
				break;
			// exit game
			case 4:
				Main.getInstance().stop();
				break;
		}
	}
	public void escape() {
		if (displayControls == true) {
			displayControls = false;
		} else if (displayCredits == true) {
			displayCredits = false;
		} else if (currentselection == 4) {
			Main.getInstance().stop();
		} else {
			currentselection = 4;
			Selector();
		}
	}
	
	// key listener
	public void keyPressed(int code) {
		switch(code) {
			case KeyEvent.VK_UP:
				upPressed();
				break;
			case KeyEvent.VK_DOWN:
				downPressed();
				break;
				
			case KeyEvent.VK_ENTER:
				enter();
				break;
			case KeyEvent.VK_ESCAPE:
				escape();
		}
	}
	
}
