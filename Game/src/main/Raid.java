package main;

import java.util.Random;

public class Raid {
	int raidScore;
	int money;
	int probMin;
	int probMax;
	int randomVal;

	
	Random random = new Random();

	public Raid(int score, int money, int amountOfMoneyGrowth) {
		
		raidScore = score;
		switch (amountOfMoneyGrowth) {
		case 0:
			//less
			randomVal = random.nextInt(score) + 1 * random.nextInt(money/5) + 1;
			break;
		case 1:
			//same
			
			break;
		case 2:
			//more
			randomVal = random.nextInt(score) + 1 * random.nextInt(money/5) + 1;
			probMin = random.nextInt(10)+5;
			probMax = random.nextInt(10)+25;
			break;
		}
	}

	public void raid() {

	}
}
