package inGameGui;

import java.util.ArrayList;
import java.util.List;

import entity.Hitbox;
import graphics.Screen;
import main.Main;

public class IGRaidChooseGui extends IGGui{
	//Raid stuff
	
	List<Hitbox> raidHitbox; 
	Hitbox done;
	
	public IGRaidChooseGui() {
		raidHitbox = new ArrayList<Hitbox>();
		//set background
		for(int i = 0; i < Main.getInstance().level.entities.size(); i++) {
			//draw out name of gang members in a certain box size, not sure yet
			//add hitbox
		}
		
		//temp values of 10
		done = new Hitbox(10, 10, 10, 10);
	}
	
	public void update() {
		//check if hitbox was hit
		for(int i = 0; i < raidHitbox.size(); i++) {
			//if mouse pointer point in in hibox
			
		}
	}
	
	public void render(Screen screen) {
		//render background
	}
}
