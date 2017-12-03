package inGameGui;

import entity.GangBoi;
import graphics.Screen;
import graphics.Texture;
import main.Main;

public class IGGangMembersGui extends IGGui {
	GangBoi g;
	Texture layover;

	final int W = Main.getInstance().W;
	final int H = Main.getInstance().H;

	public IGGangMembersGui(GangBoi g) {
		type = GANGMEMBERGUI;
		this.g = g;
		layover = new Texture("/sprites/MemberLayover.png", W, H);
	}

	public void update() {

	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, layover);
		screen.drawTexture(90, 90, g.sprite);
		if (g.weapon.real) {
			screen.drawTexture(100, 315, g.weapon.bigsprite);
		}
		if (g.cosmetic.real) {
			screen.drawTexture(225, 315, g.cosmetic.bigsprite);
		}
	}
}
