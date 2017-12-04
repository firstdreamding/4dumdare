package inGameGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import entity.Hitbox;
import graphics.Screen;
import graphics.Texture;
import items.Item;
import main.Main;

public class IGShopGui extends IGGui {
	Texture texture = new Texture("/sprites/Shop.png", 960, 540);
	public List<Hitbox> hitbox = new ArrayList<Hitbox>();
	public items.Item.List[] l = Item.List.values();
	final int D = 90;

	public IGShopGui() {

	}

	public IGShopGui(int counter) {
		this();

	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, texture);
		screen.drawString("Money: " + Main.getInstance().level.money, 325, 110, new Font("Verdana", 1, 25),
				Color.black);
		for (int i = 0; i < l.length; i++) {
			screen.drawTexture(i * D + 58, 148, l[i].t);
			screen.drawString("Cost: \n" + l[i].price, i * D + 58, 250, new Font("Verdana", 1, 15), Color.RED);

		}
	}

	public void update() {

	}

	public void click(Point point) {
		for (int i = 0; i < l.length; i++) {
			if (new Rectangle(i * D + 58, 148, 60, 70).contains(point)) {
				Main.getInstance().level.buy(l[i]);
			}
		}
	}

	public void addItem() {

	}

}
