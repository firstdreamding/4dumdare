package entity;

import java.util.Random;


import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import items.Item;
import main.Animation;
import main.Main;
import main.SoundEffect;

public class GangBoi {
	final int W = 64;
	final int H = 64;
	final int AIM_W = 192;
	final int AIM_H = 192;
	SoundEffect sound;

	final int MAX = 4;
	int att = 10;
	public int def = 100;
	int luc = 10;
	int loy = 10;
	int acc = 60;
	int x = 200, y = 200;
	String name;
	private int totalScore = 0;
	public Texture sprite;
	int destx, desty = -1;
	boolean team = true;
	long waittick = 0;
	long waittarget = 0;
	boolean moving = false;
	boolean stopMoving;
	public Hitbox hitbox, aimBox;
	public Item weapon = new Item(false, Item.WEAPON);
	Random random = new Random();
	public Item cosmetic = new Item(false, Item.COSMETIC);
	GangBoi otherGuy;
	int combatTick;
	public SpriteSheet sprites = new SpriteSheet(
			new Texture("/sprites/player" + String.valueOf(random(1, MAX)) + ".png", 320, 192), 64, 64);

	Texture walkingDown[] = { sprites.getTexture(1, 0), sprites.getTexture(2, 0), sprites.getTexture(3, 0),
			sprites.getTexture(4, 0) };
	Texture walkingUp[] = { sprites.getTexture(1, 1), sprites.getTexture(2, 1), sprites.getTexture(3, 1),
			sprites.getTexture(4, 1) };
	Texture walkingRight[] = { sprites.getTexture(1, 2), sprites.getTexture(2, 2), sprites.getTexture(3, 2),
			sprites.getTexture(4, 2) };
	Texture walkingLeft[] = { sprites.getTexture(1, 2), sprites.getTexture(2, 2), sprites.getTexture(3, 2),
			sprites.getTexture(4, 2) };
	Texture standing[] = { sprites.getTexture(0, 0) };

	public Animation animation;
	private Animation walkDown = new Animation(walkingDown, 10);
	private Animation walkUp = new Animation(walkingUp, 10);
	private Animation walkRight = new Animation(walkingRight, 10);
	private Animation walkLeft = new Animation(walkingLeft, 10);
	private Animation stand = new Animation(standing, 10);

	public GangBoi(int att1, int def1, int luc1, int loy1, int acc1, Texture sprite) {
		att = att1;
		def = def1;
		luc = luc1;
		loy = loy1;
		acc = acc1;
		this.sprite = sprite;
		totalScore = att + def + luc + loy + acc;
		animation.start();
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
		// sprite = new Texture("/sprites/GB" + String.valueOf(random(1, MAX)) + ".png",
		// W, H);
		hitbox = new Hitbox(x, y, W, H);
		x = random(100, 890);
		y = random(100,470);
		aimBox = new Hitbox(x - W, y - H, AIM_W, AIM_H);
		animation = stand;
		animation.start();
	}
	public GangBoi(boolean bool) {
		// sprite = new Texture("/sprites/GB" + String.valueOf(random(1, MAX)) + ".png",
		// W, H);
		x = random(100, 890);
		y = random(420,470);
		hitbox = new Hitbox(x, y, W, H);
		aimBox = new Hitbox(x - W, y - H, AIM_W, AIM_H);
		animation = stand;
		animation.start();
		team = bool;
		if (bool == false) {
			desty = 205;
			destx = 565;
		}
	}

	static public int random(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public void render(Screen screen) {
		screen.drawTexture(x, y, animation.getSprite(), animation == walkLeft);
		//screen.drawRect(x, y, W, H, 0x00ff00);
		//screen.drawRect(aimBox.x, aimBox.y, aimBox.width, aimBox.height, 0xff00ff);
		
		screen.fillRect(x - 18, y - 20, def, 5, 0xFF0000);
		if(!team) {
			screen.drawString("Bad", x, y);
		}

	}

	public void update() {

		if (stopMoving) {
			combatTick++;
			if (combatTick % 60 == 0) {
				new SoundEffect("Gunshot.wav");
				if(random.nextInt() > (1-otherGuy.luc) * acc) {
					otherGuy.def -= att;
					if(otherGuy.def >= 0) {
						Main.getInstance().level.dead(otherGuy);
						stopMoving = false;
					}
				}
			}
			System.out.println(def);
		} else if (moving || !team) {
			boolean a1 = false, a2 = false;
			if (x < destx) {
				x++;
				if (y == desty) {
					animation.stop();
					animation.reset();
					animation = walkRight;
					animation.start();
				}
			} else if (x > destx) {
				x--;
				if (y == desty) {
					animation.stop();
					animation.reset();
					animation = walkLeft;
					animation.start();
				}
			} else {
				a1 = true;
			}
			if (y < desty) {
				y++;
				if (animation == stand) {
					animation.stop();
					animation.reset();
					animation = walkDown;
					animation.start();
				}
			} else if (y > desty) {
				y--;
				if (animation == stand) {
					animation.stop();
					animation.reset();
					animation = walkUp;
					animation.start();
				}
			} else {
				a2 = true;
			}
			if (a1 && a2) {
				moving = false;
				waittarget = 60 * random(3, 8);
				animation.stop();
				animation.reset();
				animation = stand;
				animation.start();
			}
			hitbox.set(x, y, W, H);
			aimBox.set(x - W, y - H, AIM_W, AIM_H);
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
		if(!stopMoving)
			combat();

		animation.update();
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public void combat() {
		for(int i = 0; i < Main.getInstance().level.members.size(); i++) {
			if (Main.getInstance().level.members.get(i).hitbox.intersects(aimBox) && team != Main.getInstance().level.members.get(i).team) {
				otherGuy = Main.getInstance().level.members.get(i);
				stopMoving = true;
				break;
			}
		}
	}

	public String getName() {
		return name;
	}
}
