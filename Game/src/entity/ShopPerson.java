package entity;

import inGameGui.IGShopGui;
import main.Main;

public class ShopPerson extends BasePerson {
	public ShopPerson(int x1, int y1, int w1, int h1) {
		super(x1, y1, w1, h1);
	}
	@Override
	public void interact() {
		Main.getInstance().level.inGameMenu = !Main.getInstance().level.inGameMenu;
		Main.getInstance().level.setiGMenu(new IGShopGui());
	}
}
