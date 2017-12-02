package menu;

import graphics.Screen;
import graphics.Texture;
import main.Main;

public class MainMenu extends Menu {
	// create ints, textures, and stuff here
	
	Texture menuBackground;
	Texture selector;
	
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
	
	int currentselection;
	
	// constructor
		public MainMenu() {
			currentselection = 0;		// the selected thing
			
			// starting position for selector
			x0 = 690;					// x of selector
			y0 = 275;					// y of selector
			
			// more positions
			x1 = 700;
			y1 = 320;
			
			x2 = 720;
			y2 = 370;
			
			x3 = 720;
			y3 = 415;
			
			x4 = 780;
			y4 = 460;
			
			// setting start position of selector
			x = x0;
			y = y0;
			
			menuBackground = new Texture("/sprites/MainMenu.png", 960, 540);
			selector = new Texture("/sprites/Selector.png", 64, 64);
		}
	
	// render
	public void render(Screen screen) {
		screen.fillRect(0, 0, 960, 540, 0x000000);
		screen.drawTexture(0, 0, menuBackground);
		
		screen.drawTexture(x, y, selector);
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
			case 1:
				x = x1;
				y = y1;
			case 2:
				x = x2;
				y = y2;
			case 3:
				x = x3;
				y = y3;
			case 4:
				x = x4;
				y = y4;
		}
	}
	
	// Selection
	public void downPressed() {				// active when you press down key
		if (currentselection < 5) {
			currentselection++;
			Selector();
		}
		else {
			currentselection = 0;
		}
	}
	public void upPressed() {				// active when you press up key
		if (currentselection > 0) {
			currentselection--;
			Selector();
		}
		else {
			currentselection = 4;
		}
	}
	
	// When you press enter on selected thing
	public void enter() {
		switch(currentselection) {
			// new game
			case 0:
				Main.getInstance().menu = new CharacterCreation();
			// continue game
			case 1:
				Main.getInstance().menu = new Saves();
			// options/help
			case 2:
				
			// credits
			case 3:
				
			// exit game
			case 4:
				Main.getInstance().stop();
		}
	}
	
	public void keyPressed(int code) {
		
	}
	
}
