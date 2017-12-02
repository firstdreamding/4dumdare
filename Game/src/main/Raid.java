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
			randomVal = (int)((random.nextInt(score) + 1 * random.nextInt(money/5) + 1) *(0.5 + (0.5 * random.nextDouble())));
			probMin = random.nextInt(10)+45;
			probMax = random.nextInt(10)+80;
			break;
		case 1:
			randomVal = random.nextInt(score-5) + 10 * random.nextInt(money/5) + 1;
			probMin = random.nextInt(10)+30;
			probMax = random.nextInt(10)+70;
			break;
		case 2:
			//more
			randomVal = (int)((random.nextInt(score) + 1 * random.nextInt(money/5) + 1) *(1 + (0.5 * random.nextDouble())));
			probMin = random.nextInt(10)+5;
			probMax = random.nextInt(10)+25;
			break;
		}
	}

	public boolean raid() {
		return random.nextInt(100) > (random.nextInt(probMax-probMin));
	}
}
