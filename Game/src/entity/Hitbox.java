package entity;

import java.awt.Rectangle;

public class Hitbox extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Hitbox(int x1, int y1, int w1, int h1) {
		x = x1;
		y = y1;
		width = w1;
		height = h1;
	}

	public void set(int x1, int y1, int w1, int h1) {
		x = x1;
		y = y1;
		width = w1;
		height = h1;
	}
}
