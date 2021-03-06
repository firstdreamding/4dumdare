package inGameGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import entity.GangBoi;
import entity.Hitbox;
import graphics.Screen;
import main.Main;

public class IGRaidChooseGui extends IGGui {
	// Raid stuff

	List<Hitbox> raidHitbox;
	List<GangBoi> members;
	List<GangBoi> selectedMembers;
	Hitbox done;
	int score;
	Font tr = new Font("TimesRoman", Font.PLAIN, 18);

	public IGRaidChooseGui() {
		raidHitbox = new ArrayList<Hitbox>();
		members = new ArrayList<GangBoi>();
		selectedMembers = new ArrayList<GangBoi>();
		members = Main.getInstance().level.members;

		// set background
		for (int i = 0; i < members.size(); i++) {
			// draw out name of gang members in a certain box size, not sure yet
			// add hitbox
		}

		// temp values of 10 for the button to hit ok
		done = new Hitbox(10, 10, 10, 10);
	}

	public void update() {

	}

	public void render(Screen screen) {
		// render background

		// draw gang member names
		for (int i = 0; i < members.size(); i++) {
			screen.drawString(members.get(i).getName(), (int) (raidHitbox.get(i).getX()),
					(int) (raidHitbox.get(i).getY()), tr, Color.BLACK);
		}

		// render selection
	}

	public void point(Point point) {
		// check if hitbox was hit
		for (int i = 0; i < raidHitbox.size(); i++) {
			// if mouse pointer point in in hibox
			selectedMembers.add(members.get(i));
		}

		if (done.contains(point)) {
			Main.getInstance().level.setiGMenu(new IGRaidGui(score, Main.getInstance().level.money));
		}
	}
}
