package items;

import graphics.Texture;

public class Item {
	public final static int WEAPON = 0;
	public final static int COSMETIC = 1;

	static public enum List {
		KNIFE("Knife", 1, 1, 0, 1, 3, 200, WEAPON),
		FEDORA("Fedora", 0, 1, 2, 2, 2, 200, COSMETIC),
		AWP("AWP", 2, 0, 0, 0, 3, 700, WEAPON);
		public int att, def, loy, luc, acc, price, type;
		public String path;
		public Texture t;

		List(String name, int att, int def, int loy, int luc, int acc, int price, int type) {
			this.att = att;
			this.def = def;
			this.loy = loy;
			this.luc = luc;
			this.acc = acc;
			this.price = price;
			this.type = type;

			path = "/sprites/Item" + this.name() + ".png";
			t = new Texture(path, 50, 50);
		}

	}

	public Texture bigsprite;
	public Texture smallsprite;
	public int att, def, loy, luc, acc, price, type = 0;
	public boolean real = true;

	public Item(String s) {
		List l = List.valueOf(s.toUpperCase());
		att = l.att;
		def = l.def;
		loy = l.loy;
		luc = l.luc;
		acc = l.acc;
		price = l.price;
		type = l.type;
		smallsprite = new Texture(l.path, 60, 60);
		bigsprite = new Texture(l.path, 100, 100);
	}

	public Item(boolean r, int type) {
		this.type = type;
		if (!r) {
			real = false;
		}
	}

}
