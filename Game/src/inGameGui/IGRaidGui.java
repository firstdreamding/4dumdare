package inGameGui;

import graphics.Screen;
import main.Main;
import main.Raid;

public class IGRaidGui extends IGGui{
	//Raid stuff
	
	int score;
	Raid[] raids;
	
	String[] word1 = {
			"","The","Weird","Blue","Silent","Jade","Fun"
	};
	String[] word2 = {
			"","Punk","Disco","Floss","Pine Tree","Blood","Undead","Rainbow","Shadows"
	};
	String[] word3 = {
			"","Gang","Squad","Mafia","Kings"
	};

	public IGRaidGui(int score) {
		this.score = score;
		raids = new Raid[3];
		for(int i = 0; i < 3; i++) {
			raids[i] = new Raid(score, Main.getInstance().level.money, i);
		}
		
		
		
		
	}
	
	public void render(Screen screen) {
		for(int i = 0; i < 3; i++) {
			//screen.drawString();
		}
	}
	
	public void update() {
		
	}
	
	public void click() {
		
	}
	
}
