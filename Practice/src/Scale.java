import java.util.Scanner;

public class Scale {
	
	public static String scale(String str, int scalar, int mult) {
		String output = "";
		for (int j = 0; j < mult; j ++) {
			for (int i = 0; i < str.length(); i++) {
				output += mult(str.substring(i, i + 1), scalar);
			}
			output += "\n";
		}
		output.trim();
		return output;
	}
	
	public static String mult(String character, int scalar) {
		if (scalar <= 1) {
			return character;
		} else {
			return character + mult(character, scalar - 1); 
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int lines;
		int scale;
		String output = "";
		
		lines = scan.nextInt();
		scale = scan.nextInt();
		String input[] = new String[lines];
		
		scan.nextLine();
		
		for (int i = 0; i < lines; i ++) {
			input[i] = scan.nextLine();
			output += scale(input[i], scale, scale);
		}
		
		System.out.print(output);
		
	}

}
