import java.util.Scanner;

public class PlayfairCipher {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input;
		String cipher = "";
		int firstX = 0, firstY = 0, lastX = 0, lastY = 0;
		
		//Default key
		char square[][] = //new char[5][5];
			{{'a', 'b', 'c', 'd', 'e'}, 
			{'f', 'g', 'h', 'i', 'k'}, 
			{'l', 'm', 'n', 'o', 'p'},
			{'q', 'r', 's', 't', 'u'},
			{'v', 'w', 'x', 'y', 'z'}};
		
		//Make a new grid for the cipher
		System.out.println("Do you want the default key? ('yes' for default key)");
		input = scan.nextLine();
		if (input.equals("yes")) {
			System.out.println("Default key (a-z) will now be used.");
		} else {
			//Get key
			System.out.println("Type out 5 lines for your key, no letters may be repeated.");
			System.out.println("i and j will be counted the same");
			for (int i = 0; i <5; i ++) {
				//Get 5 character input, removing spaces
				input = scan.next().replace(" ", "");
				for (int j = 0; j < 5; j ++) {
					square[i][j] = input.charAt(j);
				}
			}
			//Scanner doesn't work well with for loops
			scan.nextLine();
		}
		
		//Print out square
		for (int i = 0; i <5; i ++) {
			for (int j = 0; j < 5; j ++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		//Get ciphertext
		System.out.println("Enter your text to be encoded");
		input = scan.nextLine().toLowerCase();
		//Check for consecutive letters
		for (int i = 1; i < input.length(); i ++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				//If there are consecutive letters, add a letter in between
				if (input.charAt(i) == 'q') {
					input = input.substring(0, i) + "i" + input.substring(i);
				} else {
					input = input.substring(0, i) + "q" + input.substring(i);
				}
			}
		}
		//Check for even string length
		if (input.length() % 2 != 0) input += "z";
		//convert j to i
		input.replace('j', 'i');
		System.out.println(input);
		//Encoding:
		for (int i = 0; i < input.length(); i += 2) {
			//Check for letter locations
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x ++) {
					if (square[x][y] == input.charAt(i)) {
						firstX = x;
						firstY = y;
					}
					if (square[x][y] == input.charAt(i + 1)) {
						lastX = x;
						lastY = y;
					}
				}
			}
			//Check if they are in a column:
			if (firstX == lastX) {
				firstY += 1;
				if (firstY > 4) firstY = 0;
				lastY += 1;
				if (lastY > 4) lastY = 0;
			//Check if they are in a row:
			} else if (firstY == lastY) {
				firstX += 1;
				if (firstX > 4) firstX = 0;
				lastX += 1;
				if (lastX > 4) lastX = 0;
			//They are in a rectangle
			} else {
				int temp = firstY;
				firstY = lastY;
				lastY = temp;
			}
			cipher += String.valueOf(square[firstX][firstY]) + String.valueOf(square[lastX][lastY]);
		}
		//Print out cyphertext
		System.out.println(cipher);
	}

}
