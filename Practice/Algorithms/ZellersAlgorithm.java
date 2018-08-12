
public class ZellersAlgorithm {
	
	String week[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	
	/**
	 * @param q 
	 * Number day of the month
	 * @param m 
	 * Month, from 1-14 (1 and 2 are changed to 13 and 14)
	 * @param 
	 * y Raw Year (AD / CE)
	 * @return Day of the week as a string
	 */
	public String getDayOfWeek(int q, int m, int y) {
		if (m == 1 || m == 2) {
			m += 12;
			y --;
		}
		int h;
		h = (q + ((13 * (m + 1)) / 5) + 
				y + 
				(int) (y / 4) +
				6 * (int)(y / 100) +
				(int)(y / 400))
				% 7;
		return week[h];
	}
}
