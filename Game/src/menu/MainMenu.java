package menu;

import graphics.Screen;
import graphics.Texture;
import main.Main;

public class MainMenu extends Menu{
	// create ints, textures, and stuff here
	
	Texture menuBackground;
	Texture selector;
	
	int x;
	int y;
	int currentselection;
	
	// render
	public void render(Screen screen) {
		screen.drawRect(0, 0, 1000, 1000, 0x00ff00);
		
		screen.drawTexture(x, y, selector);
	}
	public void update() {
		
	}
	
	// Main menu method
	public MainMenu() {
		currentselection = 0;		// the selected thing
		
		x = 0;						// x of selector
		y = 0;						// y of selector
		
		//selector = ;
		//menuBackground = ;
	}
	
	// Selection
	public void downPressed() {				// active when you press down key
		if (currentselection < 5) {
			currentselection++;
		}
		else {
			currentselection = 0;
		}
	}
	public void upPressed() {				// active when you press up key
		if (currentselection > 0) {
			currentselection--;
		}
		else {
			currentselection = 4;
		}
	}
	
	//When you press enter on selected thing
	public void enter() {
		switch(currentselection) {
			// new game
			case 0:
				Main.getInstance().menu = new CharacterCreation();
			// continue game
			case 1:
			
			// options/help
			case 2:
				
			// credits
			case 3:
				
			// exit game
			case 4:
				
		}
	}
	
}
