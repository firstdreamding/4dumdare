package main;

import java.util.List;

import entity.GangBoi;

public class Raid {
	int raidScore;
	public Raid(List<GangBoi> people) {
		raidScore = 0;
		for(int i = 0; i < people.size(); i++) {
			raidScore += people.get(i).getTotalScore();
		}
	}

	public void raidList() {
		
	}
}
