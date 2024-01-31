package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the amount of money that you start with: ");
		int startAmount = scanner.nextInt();
		System.out.print("Enter the win probability: ");
		double winChance = scanner.nextDouble();
		System.out.print("Enter the win limit: ");
		int winLimit = scanner.nextInt();
		System.out.print("Enter the number of days: ");
		int totalSimulations = scanner.nextInt();
		int ruins = 0;
		for (int days = 0; days <= totalSimulations; days++) {
			
		int game = 0;
		int money = startAmount;
		while (money > 0 && money < winLimit) {
			double luck = Math.random();
			if (luck < winChance) {
				game++;
				money++;
			}
			else {
				game++;
				money--;
			}
		}
		System.out.print("Simulation "+days+" : ");
		System.out.print(game);
		if (money == 0) {
			ruins++;
			System.out.println(" LOSE ");
		}
		else {
			System.out.println(" WIN ");
		}
		}
		System.out.println("Losses: "+ruins+" Simulations: "+totalSimulations);
		if (winChance == 0.5) {
			double expectedRuin = 1 - startAmount/winLimit*1.0;
			double realRuin = ruins/totalSimulations*1.0;
			System.out.println("Ruin Rate from Simulation: "+realRuin);
			System.out.println("Expected Ruin Rate: "+expectedRuin);
		}
		else {
			double a = (1 - winChance)/winChance;			
			double expectedRuin = (Math.pow(a,startAmount) - Math.pow(a,winLimit))/(1-Math.pow(a, winLimit));
			double realRuin = (ruins*1.0)/(totalSimulations*1.0);
			System.out.println("Ruin Rate from Simulation: "+realRuin);
			System.out.println("Expected Ruin Rate: "+expectedRuin);
		}					

	}

}
