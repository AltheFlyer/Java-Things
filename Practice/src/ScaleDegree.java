import java.util.Scanner;

public class ScaleDegree {
	
	String notes[] = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	String degrees[] = {"do", "", "re", "", "mi", "fa", "", "so", "", "la", "", "ti"};
	
	public String note(String key, String degree) {
		int offset = 0;
		int deg = 0;
		for (int i = 0; i < notes.length; i++) {
			if (notes[i].equals(key)) {
				offset = i;
			}
		}
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i].equals(degree)) {
				deg = i;
			}
		}
		return notes[(offset + deg) % 12];
	}
	
	public static void main(String[] args) {
		
		ScaleDegree s = new ScaleDegree();
		Scanner scan = new Scanner(System.in);
		
		//while (true) {
			System.out.println(s.note(scan.nextLine(), scan.nextLine()));
		//}
	}

}
