package entity;

import graphics.Screen;

public class BasePerson {
	Hitbox hitbox;
	int x, y, w, h;

	public BasePerson(int x1, int y1, int w1, int h1) {
		x = x1;
		y = y1;
		w = w1;
		h = h1;
		hitbox = new Hitbox(x1, y1, w1, h1);
	}

	public void render(Screen screen) {
		screen.drawRect(x, y, hitbox.width, hitbox.height, 0xff0000);
	}

	public void interact() {
		System.out.println("ez");
	}
}
