package inGameGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Random;

import org.w3c.dom.css.Rect;

import graphics.Screen;
import graphics.Texture;
import main.Raid;

public class IGRaidGui extends IGGui {
	// Raid stuff

	Texture raidGUI;

	Font tr = new Font("Rockwell", Font.PLAIN, 16);
	Font tr2 = new Font("Rockwell", Font.BOLD, 16);
	int score;
	Raid[] raids;

	String[] word1 = { "", "The", "Weird", "Blue", "Silent", "Jade", "Fun", "Dumb", "Flashy" };
	String[] word2 = { "", "Punk", "Disco", "Floss", "Pine Tree", "Blood", "Undead", "Rainbow", "Shadows", "Gun",
			"Unicorns", "Banana", "Emoji" };
	String[] word3 = { "", "Gang", "Squad", "Mafia", "Kings", "Boys", "Guys", "Turtles", "Dragons", "Eagles",
			"Potatoes" };
	Random random = new Random();

	String[] name;
	String[] money;
	String[] prob;
	String[] prob2;
	String tWord1, tWord2, tWord3;
	Rectangle[] t;

	public IGRaidGui(int score, int money) {
		raidGUI = new Texture("/sprites/RaidGUI.png", 830, 425);

		this.score = score;
		raids = new Raid[3];
		for (int i = 0; i < 3; i++) {
			raids[i] = new Raid(score, money, i);
		}
		name = new String[3];
		this.money = new String[3];
		prob = new String[3];
		prob2 = new String[3];

		for (int j = 0; j < 3; j++) {
			this.money[j] = "Earnable Money: " + raids[j].getMoney();
			tWord1 = word1[random.nextInt(word1.length)];
			name[j] = "";
			if (!tWord1.equals("")) {
				name[j] += tWord1 + " ";
			}
			tWord2 = word2[random.nextInt(word2.length)];
			if (!tWord2.equals("")) {
				name[j] += tWord2 + " ";
			}
			tWord3 = word3[random.nextInt(word3.length)];
			if (!tWord3.equals("")) {
				name[j] += tWord3 + " ";
			}

			prob[j] = "Prob. of Successful Raid: ";
			prob2[j] = raids[j].getProbMin() + "% to " + raids[j].getProbMax() + "%";
		}
		
		t = new Rectangle[3];
		t[0] = new Rectangle(87 ,185, 237, 18);
		t[1] = new Rectangle(360 ,185, 237, 18);
		t[2] = new Rectangle(630 ,185, 237, 18);
		

	}

	public void render(Screen screen) {
		screen.drawTexture(65, 30, raidGUI);
		for (int i = 0; i < 3; i++) {
			screen.drawString(name[i], tr2, Color.BLACK, t[i]); // change 50 and 50 to something
			screen.drawString(money[i], 140 + 275 * i, 255, tr, Color.black);
			screen.drawString(prob[i], 142 + 275 * i, 325, tr, Color.black);
			screen.drawString(prob2[i], 142 + 275 * i, 340, tr, Color.black);
		}
	}

	public void update() {

	}

	public void click() {

	}
	
	public void keyPressed(int code) {

	}

}
