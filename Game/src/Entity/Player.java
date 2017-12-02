package Entity;

import graphics.Screen;
import graphics.Texture;

public class Player {
	Texture sprite;
	int x, y;

	public Player(int x1, int y1) {
		x = x1;
		y = y1;
		sprite = new Texture("/sprites/kappa.png", 40, 40);
	}

	public void update() {

	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
	}
}
