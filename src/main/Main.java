/***********************************************************
* //Exercise 06: Gacha Simulation
*
* @author CADUYAC, JOHN RAVEN F.
* @created_date 2024-10-05 12:00:AM
*
*
***********************************************************/

package main;

import gacha.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int initialValue = 0;
		Rolling dice = new Rolling(initialValue);
		
		Game one = new Game("Mikey", dice);
		Game two = new Game("Cullen", dice);
		Game three = new Game("Ivy", dice);
		Game four = new Game("Samson", dice);
		Game five = new Game("Rody", dice);
		
		System.out.printf("%-40s %10s %10s %10s %12s%n", "Player's move", "SEQUENCE", "PULL", "DICE", "LUCKINESS");
		
		one.start();
		two.start();
        three.start();
        four.start();
        five.start();
        
        
        try {
        	one.join();
            two.join();
            three.join();
            four.join();
            five.join();
            dice.setNumOfPulls(dice.getNumOfPulls()-1);
            
            two.run();
            three.run();
            five.run();
            one.run();
            four.run();
            dice.setNumOfPulls(dice.getNumOfPulls()-1);
            
            two.run();
            four.run();
            one.run();
            three.run();
            five.run();
            dice.setNumOfPulls(dice.getNumOfPulls()-1);
        }
        catch(InterruptedException e) {
        	
        }
        
        Rolling.displayResult();
	}

}
