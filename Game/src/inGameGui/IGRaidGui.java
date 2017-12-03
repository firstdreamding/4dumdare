package inGameGui;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import graphics.Screen;
import graphics.Texture;
import main.Raid;

public class IGRaidGui extends IGGui{
	//Raid stuff
	
	Texture raidGUI;
	
	Font tr = new Font("Rockwell", Font.PLAIN, 16);
	Font tr2 = new Font("Rockwell", Font.BOLD, 16);
	int score;
	Raid[] raids;
	
	String[] word1 = {
			"","The","Weird","Blue","Silent","Jade","Fun","Dumb","Flashy"
	};
	String[] word2 = {
			"","Punk","Disco","Floss","Pine Tree","Blood","Undead","Rainbow","Shadows", "Gun", "Unicorns","Banana","Emoji"
	};
	String[] word3 = {
			"","Gang","Squad","Mafia","Kings","Boys","Guys","Turtles","Dragons","Eagles","Potatoes"
	};
	Random random = new Random();
	
	String[] name;
	String[] money;
	String[] prob; 
	String[] prob2;
	
	
	public IGRaidGui(int score, int money) {
		raidGUI = new Texture("/sprites/RaidGUI.png", 830, 425);
		
		this.score = score;
		raids = new Raid[3];
		for(int i = 0; i < 3; i++) {
			raids[i] = new Raid(score, money, i);
		}
		name = new String[3];
		this.money = new String[3];
		prob = new String[3];
		prob2 = new String[3];
		
		for(int j = 0; j < 3; j++) {
		name[j] = word1[random.nextInt(word1.length)]+ " "+word2[random.nextInt(word2.length)]+ " " + word3[random.nextInt(word3.length)];
		this.money[j] = "Earnable Money: " + raids[j].getMoney();
		prob[j] = "Prob. of Successful Raid: ";
		prob2[j] = raids[j].getProbMin() + "% to " + raids[j].getProbMax() + "%";
		}
		
		
	}
	
	public void render(Screen screen) {
		screen.drawTexture(65, 30, raidGUI);
		for(int i = 0; i < 4; i++) {			
			screen.drawString(name[i], 150 + 250*i, 200, tr2, Color.BLACK); //change 50 and 50 to something
			screen.drawString(money[i], 140 + 275*i, 255, tr, Color.black);
			screen.drawString(prob[i], 142 + 275*i, 325, tr, Color.black);
			screen.drawString(prob2[i], 142 + 275*i, 340, tr, Color.black);
		}
	}
	
	public void update() {
		
	}
	
	public void click() {
		
	}
	
}
