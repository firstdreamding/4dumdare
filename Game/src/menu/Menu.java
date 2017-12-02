package menu;

import graphics.Screen;
import graphics.Texture;

public class Menu {
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
	public Menu() {
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
	
}
