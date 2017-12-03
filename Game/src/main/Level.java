package main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import entity.BasePerson;
import entity.GangBoi;
import entity.Player;
import entity.ShopPerson;
import graphics.Screen;
import inGameGui.IGGui;
import inGameGui.IGRaidGui;

public class Level {

	public List<GangBoi> entities = new ArrayList<GangBoi>();
	public List<BasePerson> basepeople = new ArrayList<BasePerson>();
	final int LENGTH_OF_DAY = 43200;
	int day;
	int dayCounter;
	public int money;
	Player player;
	public boolean inGameMenu;
	private IGGui iGMenu;
	
	Font tr = new Font("TimesRoman", Font.PLAIN, 18);

	public Level() {
		day = 1;
		basepeople.add(new ShopPerson(400, 100, 70, 70));
		// Variable Initiation
		player = new Player(50, 50, 50, 50);
		money = 2058;
		iGMenu = new IGRaidGui(100, 2058);
	}

	public void update() {
		if (!inGameMenu) {
			player.update();
			for (int i = 0; i < entities.size(); i++) {
				entities.get(i).update();
			}
			if (dayCounter == LENGTH_OF_DAY) {
				dayCounter = 0;
				day++;
			}
			dayCounter++;
		} else {
			iGMenu.update();
		}
	}

	public void render(Screen screen) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < basepeople.size(); i++) {
			basepeople.get(i).render(screen);
		}
		screen.drawString("Day " + day, 160, 80, tr, Color.black);
		player.render(screen);
		
		//ingame menu shit
		if(inGameMenu) {
			iGMenu.render(screen);
		}
	}

	public IGGui getiGMenu() {
		return iGMenu;
	}

	public void setiGMenu(IGGui iGMenu) {
		this.iGMenu = iGMenu;
	}

}
