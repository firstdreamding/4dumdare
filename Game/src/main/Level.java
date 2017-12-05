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
import graphics.Texture;
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
	public Player player;
	public boolean inGameMenu;
	private IGGui iGMenu;
	Texture bg;
	boolean test;
	boolean raid;

	Font tr = new Font("TimesRoman", Font.PLAIN, 18);

	public Level() {
		bg = new Texture("/sprites/Warehouse.png",960, 540);
		System.out.println("This ran");
		day = 1;
		basepeople.add(new ShopPerson(400, 100, 70, 70));
		// Variable Initiation
		player = new Player(50, 50, 50, 50);
		money = 2058;
		iGMenu = new IGRaidGui(100, 2058);
		inventory.add(new Item("Fedora"));
		inventory.add(new Item("AWP"));
		inventory.add(new Item("Knife"));
		for (int i = 0; i < 12; i++) {
			inventory.add(new Item(false, Item.WEAPON));
		}
		
		test = true;
	}

	public int nextOpenSpace() {
		List<Item> inv = inventory;
		for (int i = 0; i < 15; i++) {
			if (!inv.get(i).real) {
				return i;
			}
		}
		return 14;
	}

	public void buy(Item.List l) {
		if (money > l.price) {
			money -= l.price;
			inventory.set(nextOpenSpace(), new Item(l.name()));
		}
	}

	public void raidStart() {
		double prob = 1 - Math.pow(1.05, -(money / 1000));
		prob = prob/2;
		System.out.println("Raid probability: " + prob);
		Random r = new Random();
		raid = true;
		if (r.nextDouble() < prob) {
			for(int i = 0; i < 5; i++) {
				members.add(new GangBoi(false));
			}
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
			if (dayCounter % 60 == 0) {
				raidStart();
				test = false;
			}
			dayCounter++;
		} else {
			iGMenu.update();
		}
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i).def < 0) {
				members.remove(i);
			}
		}
		
	}

	public void render(Screen screen) {
		screen.drawTexture(0, 0, bg);
		
		for (int i = 0; i < members.size(); i++) {
			members.get(i).render(screen);
		}
		for (int i = 0; i < basepeople.size(); i++) {
			basepeople.get(i).render(screen);
		}
		screen.drawString("Day " + day, 160, 80, tr, Color.black);
		screen.drawString("Money " + money, 160, 100, tr, Color.black);
		player.render(screen);

		// ingame menu shit
		if (inGameMenu) {
			iGMenu.render(screen);
		}
		

	}
	
	public void dead(GangBoi i) {
		members.remove(i);
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
