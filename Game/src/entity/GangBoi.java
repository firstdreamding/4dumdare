package entity;

import graphics.Screen;

public class GangBoi {
	int att, def, luc, loy, acc;
	private int totalScore = 0;

	public GangBoi(int att1, int def1, int luc1, int loy1, int acc1) {
		att = att1;
		def = def1;
		luc = luc1;
		loy = loy1;
		acc = acc1;
		totalScore = att+def+luc+loy+acc;
	}

	public void render(Screen screen) {
	}

	public void update() {
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
