package entity;

import java.awt.event.KeyEvent;
import java.util.List;

import graphics.Screen;
import graphics.SpriteSheet;
import graphics.Texture;
import inGameGui.IGRaidGui;
import items.Item;
import main.Animation;
import main.Main;

public class Player {
	final int left = -1;
	final int right = 1;
	final int up = -1;
	final int down = 1;
	Texture sprite;
	int x, y, xvel, yvel, speed, xdir, ydir, w, h;
	Hitbox hitbox;
	SpriteSheet player = new SpriteSheet(new Texture("/sprites/player.png", 320, 192), 64, 64);
	Texture walkingDown[] = { player.getTexture(1, 0), player.getTexture(2, 0), player.getTexture(3, 0),
			player.getTexture(4, 0) };
	Texture walkingUp[] = { player.getTexture(1, 1), player.getTexture(2, 1), player.getTexture(3, 1),
			player.getTexture(4, 1) };
	Texture walkingRight[] = { player.getTexture(1, 2), player.getTexture(2, 2), player.getTexture(3, 2),
			player.getTexture(4, 2) };
	Texture walkingLeft[] = { player.getTexture(1, 2), player.getTexture(2, 2), player.getTexture(3, 2),
			player.getTexture(4, 2) };
	Texture standing[] = { player.getTexture(0, 0) };

	private Animation animation;
	private Animation walkDown = new Animation(walkingDown, 10);
	private Animation walkUp = new Animation(walkingUp, 10);
	private Animation walkRight = new Animation(walkingRight, 10);
	private Animation walkLeft = new Animation(walkingLeft, 10);
	private Animation stand = new Animation(standing, 10);

	public Player(int x1, int y1, int w1, int h1) {
		x = x1;
		y = y1;
		w = w1;
		h = h1;
		xvel = 0;
		yvel = 0;
		speed = 1;
		sprite = new Texture("/sprites/kappa.png", w, h);
		hitbox = new Hitbox(x, y, w, h);
		animation = stand;
	}

	public void update() {
		x += xvel;
		y += yvel;
		hitbox.set(x, y, w, h);
		sprite = animation.getSprite();
		animation.update();
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
			animation = walkRight;
			animation.start();
			break;
		case KeyEvent.VK_DOWN:
			yvel = speed;
			ydir = down;
			animation = walkDown;
			animation.start();
			break;
		case KeyEvent.VK_UP:
			yvel = -speed;
			ydir = up;
			animation = walkUp;
			animation.start();
			break;
		case KeyEvent.VK_Z:
			List<GangBoi> list = Main.getInstance().level.members;
			for (int i = 0; i < list.size(); i++) {
				Hitbox l = list.get(i).hitbox;
				if (hitbox.intersects(l)) {
					Main.getInstance().level.openMember(list.get(i));
				}
			}
			break;
		case KeyEvent.VK_R:
			Main.getInstance().level.inGameMenu = !Main.getInstance().level.inGameMenu;
			Main.getInstance().level.setiGMenu(new IGRaidGui(1000, 1000));
			break;
		case KeyEvent.VK_T:
			Main.getInstance().level.inventory.add(new Item("knife"));
			Main.getInstance().level.members.add(new GangBoi());
			break;
		case KeyEvent.VK_Y:
			GangBoi g = new GangBoi();
			g.giveWeapon(new Item("Knife"));
			Main.getInstance().level.members.add(g);
			Main.getInstance().level.openMember(g);
		}
	}

	public void keyReleased(int code) {
		switch (code) {
		case KeyEvent.VK_LEFT:
			if (xdir == left) {
				xvel = 0;

				if (yvel == 0) {
					animation.stop();
					animation.reset();
					animation = stand;
				} else if(yvel == speed) {
					animation.stop();
					animation.reset();
					animation = walkDown;
				} else if(yvel == -speed) {
					animation.stop();
					animation.reset();
					animation = walkUp;
				}
				
				
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (xdir == right) {
				xvel = 0;
				
				if (yvel == 0) {
					animation.stop();
					animation.reset();
					animation = stand;
				} else if(yvel == speed) {
					animation.stop();
					animation.reset();
					animation = walkDown;
				} else if(yvel == -speed) {
					animation.stop();
					animation.reset();
					animation = walkUp;
				}
			}
			break;
		case KeyEvent.VK_DOWN:
			if (ydir == down) {
				yvel = 0;
				animation.stop();
				animation.reset();
				animation = stand;
			}
			break;
		case KeyEvent.VK_UP:
			if (ydir == up) {
				yvel = 0;
				animation.stop();
				animation.reset();
				animation = stand;
			}
			break;
		}
	}
}
