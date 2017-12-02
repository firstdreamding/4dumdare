package inGameGui;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import graphics.Screen;
import main.Main;
import main.Raid;

public class IGRaidGui extends IGGui{
	//Raid stuff
	
	Font tr = new Font("TimesRoman", Font.PLAIN, 18);
	int score;
	Raid[] raids;
	
	String[] word1 = {
			"","The","Weird","Blue","Silent","Jade","Fun"
	};
	String[] word2 = {
			"","Punk","Disco","Floss","Pine Tree","Blood","Undead","Rainbow","Shadows", "Gun", "Unicorns"
	};
	String[] word3 = {
			"","Gang","Squad","Mafia","Kings", "Boys", "Guys", "Turtles"
	};
	Random random = new Random();
	
	
	public IGRaidGui(int score, int money) {
		this.score = score;
		raids = new Raid[3];
		for(int i = 0; i < 3; i++) {
			raids[i] = new Raid(score, money, i);
		}
		
		
		
		
	}
	
	public void render(Screen screen) {
		for(int i = 0; i < 3; i++) {
			screen.drawString(word1[random.nextInt(word1.length)] + word2[random.nextInt(word1.length)] + word3[random.nextInt(word1.length)], 50 + 5*i, 50, tr, Color.BLACK); //change 50 and 50 to something
			screen.drawString("Earnable Money: " + raids[i].getMoney(), 50 +5*i, 70, tr, Color.black);
			screen.drawString("Prob. of Successful Raid: " + raids[i].getProbMin() + "% to " + raids[i].getProbMax() + "%", 50 + 5*i, 80, tr, Color.black);
			
		}
	}
	
	public void update() {
		
	}
	
	public void click() {
		
	}
	
}
