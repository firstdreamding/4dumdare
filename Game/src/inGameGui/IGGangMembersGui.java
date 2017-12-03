package inGameGui;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import entity.GangBoi;
import graphics.Screen;
import graphics.Texture;
import items.Item;
import main.Main;

class ItemBox extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;

	ItemBox(int x, int y, int w, int h, int id) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		this.id = id;

	}
}

public class IGGangMembersGui extends IGGui {
	int baseInvBoxX = 380;
	int baseInvBoxY = 150;
	int invBoxW = 60;
	int invBoxH = 60;
	GangBoi g;
	Texture layover;
	Rectangle weaponbox = new Rectangle(97, 315, 100, 100);
	Rectangle cosmeticbox = new Rectangle(225, 315, 100, 100);
	List<ItemBox> inventoryClickBoxes = new ArrayList<ItemBox>();
	final int W = Main.getInstance().W;
	final int H = Main.getInstance().H;

	public IGGangMembersGui(GangBoi g) {
		this.g = g;
		layover = new Texture("/sprites/MemberLayover.png", W, H);
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				inventoryClickBoxes
						.add(new ItemBox(baseInvBoxX + 100 * x, baseInvBoxY + 100 * y, invBoxW, invBoxH, 5 * y + x));
			}
		}
	}

	public void update() {

	}

	public int nextOpenSpace() {
		List<Item> inv = Main.getInstance().level.inventory;
		for (int i = 0; i < 15; i++) {
			if (!inv.get(i).real) {
				return i;
			}
		}
		return -1;
	}

	public void click(Point p) {
		List<Item> inv = Main.getInstance().level.inventory;
		for (ItemBox i : inventoryClickBoxes) {
			if (i.contains(p)) {
				int index = i.id;
				if (inv.get(index).real) {
					inv.set(index, g.giveItem(inv.get(index)));
				}

			}
		}
		if (weaponbox.contains(p) && g.weapon.real) {
			inv.set(nextOpenSpace(), g.giveItem(new Item(false,Item.WEAPON)));
		}
		if (cosmeticbox.contains(p) && g.cosmetic.real) {
			inv.set(nextOpenSpace(), g.giveItem(new Item(false,Item.COSMETIC)));
		}
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, layover);
		screen.drawTexture(90, 90, g.sprite);
		/*
		 * screen.drawRect(weaponbox.x, weaponbox.y, weaponbox.width, weaponbox.height,
		 * 0x0000ff); screen.drawRect(cosmeticbox.x, cosmeticbox.y, cosmeticbox.width,
		 * cosmeticbox.height, 0x0000ff); for (ItemBox i : inventoryClickBoxes) {
		 * screen.drawRect(i.x, i.y, i.width, i.height, 0x0000ff); }
		 */
		List<Item> l = Main.getInstance().level.inventory;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 5; x++) {
				int index = 5 * y + x;
				if (l.get(index).real) {
					screen.drawTexture(baseInvBoxX + x * 100, baseInvBoxY, l.get(index).smallsprite);
				}
			}
		}
		if (g.weapon.real) {
			screen.drawTexture(100, 315, g.weapon.bigsprite);
		}
		if (g.cosmetic.real) {
			screen.drawTexture(225, 315, g.cosmetic.bigsprite);
		}
	}
}
