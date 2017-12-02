package entity;

import java.awt.event.KeyEvent;

import graphics.Screen;
import graphics.Texture;

public class Player {
	final int left = -1;
	final int right = 1;
	final int up = -1;
	final int down = 1;
	Texture sprite;
	int x, y, xvel, yvel, speed, xdir, ydir;

	public Player(int x1, int y1) {
		x = x1;
		y = y1;
		xvel = 0;
		yvel = 0;
		speed = 5;
		sprite = new Texture("/sprites/kappa.png", 40, 40);
	}

	public void update() {
		x += xvel;
		y += yvel;
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
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
