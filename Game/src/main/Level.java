package main;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import entity.GangBoi;
import graphics.Screen;

public class Level {
	
	List<GangBoi> entities = new ArrayList<GangBoi>();
	final int LENGTH_OF_DAY = 43200;
	int day;
	int dayCounter;
	Font tr = new Font("TimesRoman", Font.PLAIN, 18);
	
	public Level() {
		day = 1;
	}
	
	public void update() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		if(dayCounter == LENGTH_OF_DAY) {
			dayCounter = 0;
			day++;
		}
		dayCounter++;
	}
	
	public void render(Screen screen) {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		screen.drawString("Day " + day, 160, 80, tr, Color.black);
	}
	
}
