import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String word;
		String guess;
		String answer = "";
		String original;
		String wrong = "";
		int misses = 0;
		
		word = scan.nextLine();
		original = word;
		
		for (int i = 0; i < word.length(); i ++) {
			answer += "_";
		}
		
		while (!(misses == 4) && !answer.equals(original)) {
			guess = scan.nextLine();
			if (word.indexOf(guess) != -1) {
				while (word.indexOf(guess) != -1) {
					answer = answer.substring(0, word.indexOf(guess)) + guess + answer.substring(word.indexOf(guess) + 1);
					word = word.substring(0, word.indexOf(guess)) + "_" +  word.substring(word.indexOf(guess) + 1);
				}
			} else {
				misses += 1;
				wrong += guess + " ";
			}
			
			System.out.println(answer);
			System.out.println("You have " + (4 - misses) + " lives left.");
			System.out.println("Wrong letters: " + wrong);
		}
		
		if (misses == 4) {
			System.out.println("You didn't guess the word");
		} else {
			System.out.println("You got the word!");
		}
		
	}

}
