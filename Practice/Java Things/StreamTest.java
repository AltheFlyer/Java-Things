import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamTest {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
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
		list = list.stream()
			.map(n -> n * multiplier)
			.collect(Collectors.toList());
		
		for (int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
		
		//Remove all numbers divisible by 10
		list = list.stream()
			.filter(n -> n % 10 > 0)
			.collect(Collectors.toList());
	
		for (int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
			
	}

}
