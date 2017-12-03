package inGameGui;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import entity.Hitbox;
import graphics.Screen;
import items.Item;

public class IGShopGui extends IGGui{
	
	int counter;
	public List<Hitbox> hitbox = new ArrayList<Hitbox>();
	
	public IGShopGui() {
		
	}
	
	public IGShopGui(int counter) {
		this();
		for(int i = 0; i < Item.List.values().length; i++){
			counter++;
			
		}
	}
	
	public void render(Screen screen) {
		
	}
	
	public void update() {
		
	}

	public void click(Point point) {
		
	}
	
	public void addItem() {
		
	}

}
