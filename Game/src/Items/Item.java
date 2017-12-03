package Items;

import graphics.Texture;

public class Item {
	final int W = 50;
	final int H = 50;

	enum List {
		KNIFE(1, 1, 0, 1, 3, "Knife");
		int att, def, loy, luc, acc;
		String path;

		List(int att, int def, int loy, int luc, int acc, String name) {
			att = this.att;
			def = this.def;
			loy = this.loy;
			luc = this.luc;
			acc = this.acc;
			path = "/sprites/Item" + this.name()+".png";
		}

	}

	public Texture sprite;
	int att, def, loy, luc, acc = 0;

	public Item(String s) {
		List l = List.valueOf(s.toUpperCase());
		att = l.att;
		def = l.def;
		loy = l.loy;
		luc = l.luc;
		acc = l.acc;
		sprite = new Texture(l.path, W, H);
	}

	public void setSprite(Texture t) {
		sprite = t;
	}
}
