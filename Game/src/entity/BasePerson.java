package entity;

import graphics.Screen;
import graphics.Texture;

public class BasePerson {
	Hitbox hitbox;
	int x, y, w, h;
	Texture sprite;
	public BasePerson(int x1, int y1, int w1, int h1) {
		x = x1;
		y = y1;
		w = w1;
		h = h1;
		hitbox = new Hitbox(x, y, w, h);
	}

	public void render(Screen screen) {
		//screen.drawRect(x, y, hitbox.width, hitbox.height, 0xff0000);
	}

	public void interact() {
	}
}
