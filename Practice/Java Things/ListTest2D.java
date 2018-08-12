import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListTest2D {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
		Scanner scan = new Scanner(System.in);
		String input;
		String test;
		
		for (int y = 0; y < 5; y ++) {
			//Temp variable here prevents main list from accessing a direct variable
			ArrayList<Character> inputs = new ArrayList<Character>();
			inputs.clear();
			input = scan.nextLine();
			for (int x = 0; x < 5; x ++) {
				inputs.add(input.charAt(x));
			}
			System.out.println(inputs.size());
			list.add(inputs);
			System.out.println(list.get(y).size());
			
		}
		
		//Print check
		for (int y = 0; y < 5; y ++) {
			for (int x = 0; x < 5; x ++) {
				System.out.println(list.get(y).get(x));
			}
		}
		
	}

}
