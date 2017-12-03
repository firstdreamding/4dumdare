package entity;

import java.util.Random;

import graphics.Screen;
import graphics.Texture;

public class GangBoi {
	final int W = 64;
	final int H = 64;
	final int MAX = 2;
	int att, def, luc, loy, acc;
	int x, y = 0;
	String name;
	private int totalScore = 0;
	private Texture sprite;
	int destx, desty = -1;
	long waittick = 0;

	public GangBoi(int att1, int def1, int luc1, int loy1, int acc1, Texture sprite) {
		att = att1;
		def = def1;
		luc = luc1;
		loy = loy1;
		acc = acc1;
		this.sprite = sprite;
		totalScore = att + def + luc + loy + acc;
	}

	public GangBoi() {
		sprite = new Texture("/sprites/GB" + String.valueOf(random(1, MAX)) + ".png", W, H);
	}

	public int random(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
	}

	public void update() {
		if (destx > 0 && desty > 0) {
			
		} else {
			waittick++;
			if(waittick>60) {
				waittick=0;
				System.out.println(Math.sin(30));
			}
		}
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}
}
