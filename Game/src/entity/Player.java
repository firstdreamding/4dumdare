package entity;

import java.awt.event.KeyEvent;
import java.util.List;

import graphics.Screen;
import graphics.Texture;
import main.Main;

public class Player {
	final int left = -1;
	final int right = 1;
	final int up = -1;
	final int down = 1;
	Texture sprite;
	int x, y, xvel, yvel, speed, xdir, ydir, w, h;
	Hitbox hitbox;

	public Player(int x1, int y1, int w1, int h1) {
		x = x1;
		y = y1;
		w = w1;
		h = h1;
		xvel = 0;
		yvel = 0;
		speed = 5;
		sprite = new Texture("/sprites/kappa.png", w, h);
		hitbox = new Hitbox(x, y, w, h);
	}

	public void update() {
		x += xvel;
		y += yvel;
		hitbox.set(x, y, w, h);
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
		screen.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height, 0xff0000);
	}

	public void keyPressed(int code) {
		switch (code) {
		case KeyEvent.VK_LEFT:
			xvel = -speed;
			xdir = left;
			break;
		case KeyEvent.VK_RIGHT:
			xvel = speed;
			xdir = right;
			break;
		case KeyEvent.VK_DOWN:
			yvel = speed;
			ydir = down;
			break;
		case KeyEvent.VK_UP:
			yvel = -speed;
			ydir = up;
			break;
		case KeyEvent.VK_Z:
			List<BasePerson> list = Main.getInstance().level.basepeople;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).hitbox.intersects(hitbox)) {
					list.get(i).interact();
				}
			}
			break;
		case KeyEvent.VK_R:
			Main.getInstance().level.inGameMenu = !Main.getInstance().level.inGameMenu;
		}
	}

	public void keyReleased(int code) {
		switch (code) {
		case KeyEvent.VK_LEFT:
			if (xdir == left) {
				xvel = 0;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (xdir == right) {
				xvel = 0;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (ydir == down) {
				yvel = 0;
			}
			break;
		case KeyEvent.VK_UP:
			if (ydir == up) {
				yvel = 0;
			}
			break;
		}
	}
}
