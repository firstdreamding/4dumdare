package main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.BasePerson;
import entity.GangBoi;
import entity.Player;
import entity.ShopPerson;
import graphics.Screen;
import inGameGui.IGGangMembersGui;
import inGameGui.IGGui;
import inGameGui.IGRaidGui;
import items.Item;

public class Level {

	public List<GangBoi> members = new ArrayList<GangBoi>();
	public List<BasePerson> basepeople = new ArrayList<BasePerson>();
	public List<Item> inventory = new ArrayList<Item>();
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
		Item item = new Item("Knife");
	}

	public void raidStart() {
		double prob = 1 - Math.pow(1.05, -(money / 1000));
		System.out.println("Raid probability: " + prob);
		Random r = new Random();
		if (r.nextDouble() < prob) {
			System.out.println("Ur getting raided");
		}
	}

	public void update() {
		if (!inGameMenu) {
			player.update();
			for (int i = 0; i < members.size(); i++) {
				members.get(i).update();
			}
			if (dayCounter == LENGTH_OF_DAY) {
				dayCounter = 0;
				day++;
			}
			if (dayCounter % 1800 == 0)
				raidStart();
			dayCounter++;
		} else {
			iGMenu.update();
		}
	}

	public void render(Screen screen) {
		for (int i = 0; i < members.size(); i++) {
			members.get(i).render(screen);
		}
		for (int i = 0; i < basepeople.size(); i++) {
			basepeople.get(i).render(screen);
		}
		screen.drawString("Day " + day, 160, 80, tr, Color.black);
		player.render(screen);

		// ingame menu shit
		if (inGameMenu) {
			iGMenu.render(screen);
		}
	}

	public void openMember(GangBoi g) {
		setiGMenu(new IGGangMembersGui(g));
		inGameMenu = !inGameMenu;

	}

	public IGGui getiGMenu() {
		return iGMenu;
	}

	public void setiGMenu(IGGui iGMenu) {
		this.iGMenu = iGMenu;
	}

}
