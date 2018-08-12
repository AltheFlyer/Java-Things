import java.util.*;
import java.io.*;

public class MontyHallProbability {
	
	//In Monty Hall's game, there are 3 doors, one with a prize, and 2 without
	//The contestant picks a door, and then Monty reveals a door without a prize
	//The contestant then gets a chance to switch
	//Switching supposedly has twice the chance of winning (66%) as staying (33%)
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		System.out.println("How many cases:");
		int tests = Integer.parseInt(in.readLine());
		System.out.println("Enter value of n, where stats reports are printed every n cases:");
		int checkEvery = Integer.parseInt(in.readLine());
		int switchWins = 0;
		int stayWins = 0;
		ArrayList<Integer> doors = new ArrayList<Integer>();
		
		//The fun part
		for (int i = 0; i < tests; ++i) {
			doors.clear();
			for (int x = 0; x < 3; ++x) {
				doors.add(x);
			}
			int prize = rand.nextInt(3);
			//System.out.println("What door do you pick? (0-2)");
			int choice = 0; //Integer.parseInt(in.readLine());
			//System.out.println("Revealing a door now:");
			int open;
			doors.remove(doors.indexOf(choice));
			if (prize != choice) {
				doors.remove(doors.indexOf(prize));
				open = doors.get(0);
				doors.add(prize);
			} else {
				open = doors.get(rand.nextInt(2));
			}
			//System.out.println(prize + " " + choice + " " + open);
			//System.out.printf("Door %d didn't have the prize!\n", open);
			doors.remove(doors.indexOf(open));
			
			
			
			//Making sure strings are valid
			choice = doors.get(0);
			//Because we always switch
			if (choice == prize) ++switchWins;
			else ++ stayWins;

			
			//Only for human use
			/*
			System.out.println("Do you switch? (y/n)");
			boolean valid = false;
			String resp = "";
			while (!valid) {
				resp = in.readLine();
				if (resp.equals("y")) {
					valid = true;
					choice = doors.get(0);
					System.out.println("New Choice: " + choice);
				} else if (resp.equals("n")) {
					valid = true;
					//Choice stays the same
				}
				else System.out.println("Enter a valid response.");
			}
			if (choice == prize) {
				System.out.println("You win!");
				if (resp.equals("y")) ++switchWins;
				else ++ stayWins;
			} else {
				System.out.println("You lose!");
				if (resp.equals("n")) ++switchWins;
				else ++ stayWins;
			}
			*/
			
			//Stats:
			if (i % checkEvery == 0) {
				System.out.printf("%.5f\t%5f\n",  Double.valueOf(switchWins) / Double.valueOf(i) * 100, Double.valueOf(stayWins) / Double.valueOf(i) * 100);
			}
		}
		
		//Human output
		System.out.printf("Switch wins vs Stay wins: %d:%d\n", switchWins, stayWins);
		System.out.printf("Switch winrate: %f%%\tStay winrate:%f%%", Double.valueOf(switchWins) / Double.valueOf(tests) * 100, Double.valueOf(stayWins) / Double.valueOf(tests) * 100);
	

		
	}

}
