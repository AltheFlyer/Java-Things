import java.util.ArrayList;
import java.util.Scanner;

public class LambdaStuff {

	public static void main(String[] args) {
		
		//Multiply set
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int multiplier;
		int count;
		
		multiplier = scan.nextInt();
		count = scan.nextInt();
		
		for (int i = 0; i < count; i ++) {
			list.add(scan.nextInt());
		}
		scan.nextLine();
		
		//Multiplies every input number by the multiplier
		list.replaceAll(n -> n * multiplier);
		
		for (int i = 0; i < count; i ++) {
			System.out.println(list.get(i));
		}
	}

}
