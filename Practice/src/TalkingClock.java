import java.util.Scanner;
public class TalkingClock {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int hour;
		int minute;
		int ones;
		String minuteStr;
		String input;
		String output = "";
		String[] hours = {
				"twelve", "one", "two", 
				"three", "four", "five", 
				"six", "seven", "eight", 
				"nine", "ten", "eleven",
		};
		String[] tens = {
			"twenty", "thirty", "fourty", "fifty"	
		};
		String[] minutes = {
			"zero", "one", "two", 
			"three", "four", "five", 
			"six", "seven", "eight", 
			"nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", 
			"fifteen", "sixteen", "seventeen", 
			"eighteen", "nineteen"
		};
		
		while (true) {
			output = "It's ";
			input = scan.next();
			hour = Integer.valueOf(input.substring(0, 2));
			minute = Integer.valueOf(input.substring(3));
			ones = Integer.valueOf(input.substring(4));
			
			//Convert number to word
			if (hour >= 12) {
				hour -= 12;
			}
			output += hours[hour] + " ";
			hour += 12;
			
			//Convert minutes
			if (minute > 19) {
				output += tens[Integer.valueOf(minute / 10) - 2] + " " + minutes[ones] + " ";
			} else if (minute > 9) {
				output += minutes[minute] + " ";
			} else if (minute > 0) {
				output += "oh " + minutes[ones] + " ";
			}
			
			//am or pm
			if (hour > 11) {
				output += "pm";
			} else {
				output += "am";
			}
			
			//Output
			System.out.println(output);
		}

	}

}
