import java.util.Scanner;

public class DayOfTheWeek {
	
	//Test Cases:
	/*
	 * 2017 10 30 - MONDAY
	 * 2016 2 29 - MONDAY
	 * 2015 2 28 - SATURDAY
	 * 29 4 12 - THURSDAY
	 * 570 11 30 - FRIDAY
	 * 1066 9 25 - TUESDAY
	 * 1776 7 4 - THURSDAY
	 * 1933 1 30 - MONDAY
	 * 1953 3 6 - FRIDAY
	 * 2100 1 9 - SATURDAY
	 * 2202 12 15 - WEDNESDAY
	 * 7032 3 26  - MONDAY
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ZellersAlgorithm zell = new ZellersAlgorithm();
		String input;
		int year, month, day;
		int days = 0;
		String daylist[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		while (true) {
			days = 0;
			input = scan.nextLine();
			year = Integer.valueOf(input.substring(0, input.indexOf(" ")));
			input = input.substring(input.indexOf(" ") + 1);
			month = Integer.valueOf(input.substring(0, input.indexOf(" ")));
			input = input.substring(input.indexOf(" ") + 1);
			day = Integer.valueOf(input);
		
			//System.out.println(year + " " + month + " " + day);
			
			/* First Code Attempt
			for (int i = 1; i < year; i ++) {
				if (i % 400 == 0) {
					days += 366;
				} else if (i % 100 == 0) {
					days += 365;
				} else if (i % 4 == 0) {
					days += 366;
				} else {
					days += 365;
				}
			}
		
			for (int i = 1; i < month; i ++) {
				if (i == 2) {
					if (i % 400 == 0) {
						days += 29;
					} else if (i % 100 == 0) {
						days += 28;
					} else if (i % 4 == 0) {
						days += 29;
					} else {
						days += 28;
					}
				} else if (i == 4 || i == 6 || i == 9 || i == 11) {
					days += 30;
				} else {
					days += 31;
				}
			}
		
			days += day;
			System.out.println(daylist[days % 7]);
			*/
			
			//With Algorithm
			System.out.println(zell.getDayOfWeek(day, month, year));
		}
		
	}
}
