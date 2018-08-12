import java.io.*;
import java.util.*;

public class BoxProbability {
	
	//If you were given 100 boxes, where 99 do something good and one does something very bad,
	//What is the risk of opening n boxes?
	
	//Warning this is somewhat slow
	//It took 7 mins to calculate for 0-100 (1 million cases each)
	//As in 101,000,000 cases in 7 mins
	//14428571.4 cases a minute
	//240476.19 cases a second = 'a'
	
	//But since you do more processing the more boxes you check,
	//Sum of ints from 1 to 100 = 5050
	//So: 5,050,000,000 Array Check Cycles in 7 mins
	//721428571.429 per minute
	//12023809.5238 per second = 'b'
	
	//Given a and b, a/b should be equal to the average number of cycles per case (50)
	//Which it is.
	
	static Random rand = new Random();
	
	public static boolean isSafe(ArrayList<Integer> b, int o) {
		int risk = rand.nextInt(99);
		ArrayList<Integer> taken = new ArrayList<Integer>(); 

		for (int j = 0; j < o; ++j) {
			//System.out.println(b.size());
			//This only works if number of boxes to check < number of boxes in total
			int k = rand.nextInt(b.size());
			
			//System.out.println(box.get(k));
			int r = b.remove(k);
			taken.add(r);
			
			if (r == risk) {
				for (int i: taken) {
					b.add(i);
				}
				return false;
			}
		}	
		for (int i: taken) {
			b.add(i);
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of boxes to open:");
		//int opened = Integer.parseInt(in.readLine());
		int opened = 0;
		/*
		if (opened == 100) {
			System.out.println("There is literally no chance of safety whatsoever."); 
			return;
		}
		*/
		
		//Lets start with a constant for test cases;
		int tests = 1000000;
		int safe = 0;
		ArrayList<Integer> boxes;
		
		//There are 100 boxes
		boxes = new ArrayList<Integer>();
		for (int j = 0; j < 100; ++j) {
			boxes.add(j);
		}
		
		//The testing 0 boxes to 100.
		for (int x = 0; x < 101; ++x) {
			safe = 0;
			for (int i = 0; i < tests; ++i) {
				if (isSafe(boxes, x)) ++safe;
				//System.out.println(i);
			}
			//Raw numbers
			System.out.printf("%.5f\n", Double.valueOf(safe) / Double.valueOf(tests) * 100);
		}
		
		//Fancy printing
		//System.out.printf("Safe: %d\tTotal: %d\n", safe, tests);
		//Apparently you escape the percent sign with... a percent sign
		//System.out.printf("%.5f%% safety.", Double.valueOf(safe) / Double.valueOf(tests) * 100);
		

	}

}
