package inGameGui;

import entity.GangBoi;
import graphics.Screen;

public class IGGangMembersGui extends IGGui {
	GangBoi g;

	public IGGangMembersGui(GangBoi g) {
		this.g = g;
	}
	public void update() {
		
	}
	public void render(Screen screen) {
		
		screen.drawRect(0, 0, 100, 100, 0x0000ff);
	}
}
