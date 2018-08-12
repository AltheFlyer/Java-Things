import java.util.Scanner;

public class SleepCycleEstimator {
	
	public static String minuteConvert(int minutes) {
		if (minutes > 1440) minutes -= 1440;if (minutes > 1440) minutes -= 1440;
		if (minutes > 720) minutes -= 720;
		if (minutes > 719) {
			if (minutes % 60 == 0) {
				return String.valueOf((int) minutes / 60 - 12) + ":" + String.valueOf(minutes % 60) + "0PM";
			} else {
				return String.valueOf((int) minutes / 60) + ":" + String.valueOf(minutes % 60) + "PM";
			}
		} else {
			if (minutes / 60 == 0) minutes += 720;
			if (minutes % 60 == 0) {
				return String.valueOf((int) minutes / 60) + ":" + String.valueOf(minutes % 60) + "0AM";
			} else {
				return String.valueOf((int) minutes / 60) + ":" + String.valueOf(minutes % 60) + "AM";
			}
		}
	}
	
	public static int toMinutes(String time) {
		int t = 0;
		t += 60 * Integer.valueOf(time.substring(0, time.indexOf(":")));
		t += Integer.valueOf(time.substring(time.indexOf(":") + 1, time.indexOf(":") + 3));
		if (time.substring(time.length() - 2).equals("AM")) {
			return t + 1440;
		} else {
			return t + 720;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int minutes = toMinutes(scan.nextLine());
		minutes -= 270;
		for (int i = 0; i < 4; i ++) {
			System.out.println(minuteConvert(minutes));
			minutes -= 90;
		}
	}

}
