package items;

import graphics.Texture;

public class Item {
	final static int WEAPON = 0;
	final static int COSMETIC = 1;

	static public enum List {
		KNIFE(1, 1, 0, 1, 3, "Knife", 200, WEAPON), FEDORA(0, 1, 2, 2, 2, "Fedora", 200, COSMETIC);
		int att, def, loy, luc, acc, price, type;
		String path;

		List(int att, int def, int loy, int luc, int acc, String name, int price, int type) {
			att = this.att;
			def = this.def;
			loy = this.loy;
			luc = this.luc;
			acc = this.acc;
			price = this.price;
			path = "/sprites/Item" + this.name() + ".png";
		}

	}

	public Texture bigsprite;
	public Texture smallsprite;
	int att, def, loy, luc, acc, price = 0;
	public boolean real = true;

	public Item(String s) {
		List l = List.valueOf(s.toUpperCase());
		att = l.att;
		def = l.def;
		loy = l.loy;
		luc = l.luc;
		acc = l.acc;
		price = l.price;
		smallsprite = new Texture(l.path, 50, 50);
		bigsprite = new Texture(l.path, 100, 100);
	}

	public Item(boolean r) {
		if (!r) {
			real = false;
		}
	}

}
