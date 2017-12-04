package entity;

import java.util.Random;

import graphics.Screen;
import graphics.Texture;
import items.Item;
import main.Main;

public class GangBoi {
	final int W = 64;
	final int H = 64;
	final int AIM_W = 192;
	final int AIM_H = 192;
	
	final int MAX = 2;
	int att = 0, def = 0, luc = 0, loy = 0, acc = 0;
	int x = 200, y = 200;
	String name;
	private int totalScore = 0;
	public Texture sprite;
	int destx, desty = -1;
	boolean team;
	long waittick = 0;
	long waittarget = 0;
	boolean moving = false;
	Hitbox hitbox, aimBox;
	public Item weapon = new Item(false, Item.WEAPON);
	public Item cosmetic = new Item(false, Item.COSMETIC);

	public GangBoi(int att1, int def1, int luc1, int loy1, int acc1, Texture sprite) {
		att = att1;
		def = def1;
		luc = luc1;
		loy = loy1;
		acc = acc1;
		this.sprite = sprite;
		totalScore = att + def + luc + loy + acc;
	}

	public Item giveItem(Item i) {
		Item temp;
		if (i.type != Item.COSMETIC) {
			temp = weapon;
			weapon = i;
		} else {
			temp = cosmetic;
			cosmetic = i;
		}
		return temp;
	}

	public GangBoi() {
		sprite = new Texture("/sprites/GB" + String.valueOf(random(1, MAX)) + ".png", W, H);
		hitbox = new Hitbox(x, y, W, H);
		aimBox = new Hitbox(x-W, y-H, AIM_W, AIM_H);
	}

	public int random(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, sprite);
		screen.drawRect(x, y, W, H, 0x00ff00);
		screen.drawRect(aimBox.x, aimBox.y, aimBox.width, aimBox.height, 0xff00ff);
	}

	public void update() {
		if (moving) {
			boolean a1 = false, a2 = false;
			if (x < destx) {
				x++;
			} else if (x > destx) {
				x--;
			} else {
				a1 = true;
			}
			if (y < desty) {
				y++;
			} else if (y > desty) {
				y--;
			} else {
				a2 = true;
			}
			if (a1 && a2) {
				moving = false;
				waittarget = 60 * random(3, 8);
			}
			hitbox.set(x, y, W, H);
			aimBox.set(x-W, y-H, AIM_W, AIM_H);
		} else {
			waittick++;
			if (waittick > waittarget) {
				int angle = random(0, 359);
				int radius = random(100, 200);
				int destx = x + (int) (radius * Math.cos(Math.toRadians(angle)));
				int desty = y + (int) (radius * Math.sin(Math.toRadians(angle)));
				int scrW = Main.getInstance().W;
				int scrH = Main.getInstance().H;
				if (destx + W > scrW || destx < 0 || desty + H > scrH || desty < 0) {
				} else {
					this.destx = destx;
					this.desty = desty;
					moving = true;
					waittick = 0;
				}
			}
		}
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public void combat(GangBoi otherGuy) {
		
	}

	public String getName() {
		return name;
	}
}
