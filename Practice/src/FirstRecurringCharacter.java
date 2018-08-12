import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstRecurringCharacter {
	
	static int x = -1;
	
	public static String firstChar(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String s = "";
		for (int i = 0; i < str.length(); i ++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), i);
			} else {
				x = map.get(str.charAt(i));
				return String.valueOf(str.charAt(i));
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(firstChar(scan.nextLine()));
		System.out.println(x);
	}

}
