package inGameGui;

import java.awt.Point;
import java.awt.Rectangle;

import entity.GangBoi;
import graphics.Screen;
import graphics.Texture;
import items.Item;
import main.Main;

public class IGGangMembersGui extends IGGui {
	GangBoi g;
	Texture layover;
	Rectangle weaponbox = new Rectangle(97, 315, 100, 100);
	Rectangle cosmeticbox = new Rectangle(225, 315, 100, 100);
	final int W = Main.getInstance().W;
	final int H = Main.getInstance().H;

	public IGGangMembersGui(GangBoi g) {
		type = GANGMEMBERGUI;
		this.g = g;
		layover = new Texture("/sprites/MemberLayover.png", W, H);
	}

	public void update() {

	}

	public void click(Point p) {
		if (weaponbox.contains(p) && g.weapon.real) {
			Main.getInstance().level.inventory.add(g.giveWeapon(new Item(false)));
		}
		if (cosmeticbox.contains(p) && g.cosmetic.real) {
			Main.getInstance().level.inventory.add(g.giveCosmetic(new Item(false)));
		}
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, layover);
		screen.drawTexture(90, 90, g.sprite);
		screen.drawRect(weaponbox.x, weaponbox.y, weaponbox.width, weaponbox.height, 0x0000ff);
		screen.drawRect(cosmeticbox.x, cosmeticbox.y, cosmeticbox.width, cosmeticbox.height, 0x0000ff);
		if (g.weapon.real) {
			screen.drawTexture(100, 315, g.weapon.bigsprite);
		}
		if (g.cosmetic.real) {
			screen.drawTexture(225, 315, g.cosmetic.bigsprite);
		}
	}
}
