package gacha;

import java.util.ArrayList;
import java.util.Random;

public class Rolling {
	
	Random random = new Random();
	
	private static int timeSequence;
	private static ArrayList<String> scoreboard = new ArrayList<String>();
	private int num_of_pulls = 3;
	private int score = 0;
	
	public Rolling(int initialValue) {
		Rolling.timeSequence = initialValue;
	}
	
	protected synchronized int diceRoll(String playerName) {
		int rolled_dice = random.nextInt(6)+1;
		int luckiness_value = random.nextInt(10);
		
		System.out.printf("Player %-10s rolled the dice and got",playerName);
		System.out.printf("%10d %10d %10d %12d%n", timeSequence+1, 3-num_of_pulls,rolled_dice, luckiness_value);
		//this if seems useless but i dont have any more time to remove it, it's useless since it supposed to only count the scores when it's the last pull
		if((timeSequence%2 == 0)&&(num_of_pulls>1)) {
			score += rolled_dice + luckiness_value;
		}
		//if it's the last pulls, start adding the scores
		else if((num_of_pulls==1)&&((timeSequence+1)%2 == 0)) {
			scoreboard.add(String.format("%s:%d", playerName, timeSequence+1+rolled_dice+luckiness_value));
		}
		timeSequence += 1;
		return score;
	}
	
	public static void displayResult() {
		System.out.println("\nGame Over\n");
		System.out.println("The player with the highest score will receive the reward:");
		String winner = null;
		int highest_score = 0;
		for(String scores: scoreboard) {
			System.out.println(scores);
			String[] spliced_scores = scores.split(":");
			int current_score = Integer.parseInt(spliced_scores[1]);
			if(current_score>highest_score) {
				winner = spliced_scores[0];
				highest_score = current_score;
			}
		}
		
		System.out.println("Congratulations, you are the winner!");
		System.out.println(winner);
		
	}
	
	//setters-getters for num of pulls
	public void setNumOfPulls(int num_of_pulls) {
		this.num_of_pulls = num_of_pulls;
	}
	
	public int getNumOfPulls() {
		return num_of_pulls;
	}
	
	public int getTimeSequence() {
		return timeSequence;
	}
}
