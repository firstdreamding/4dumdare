package inGameGui;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import graphics.Screen;
import main.Main;
import main.Raid;

public class IGRaidGui extends IGGui{
	//Raid stuff
	
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
	
	
	public IGRaidGui(int score, int money) {
		this.score = score;
		raids = new Raid[3];
		for(int i = 0; i < 3; i++) {
			raids[i] = new Raid(score, money, i);
		}
		name = new String[3];
		this.money = new String[3];
		prob = new String[3];
		
		for(int j = 0; j < 3; j++) {
		name[j] = word1[random.nextInt(word1.length)]+ " "+word2[random.nextInt(word2.length)]+ " " + word3[random.nextInt(word3.length)];
		this.money[j] = "Earnable Money: " + raids[j].getMoney();
		prob[j] = "Prob. of Successful Raid: " + raids[j].getProbMin() + "% to " + raids[j].getProbMax() + "%";
		}
		
		
	}
	
	public void render(Screen screen) {
		for(int i = 0; i < 3; i++) {
			screen.drawString(name[i], 50 + 300*i, 50, tr2, Color.BLACK); //change 50 and 50 to something
			screen.drawString(money[i], 50 + 300*i, 80, tr, Color.black);
			screen.drawString(prob[i], 50 + 300*i, 100, tr, Color.black);
			
		}
	}
	
	public void update() {
		
	}
	
	public void click() {
		
	}
	
}
