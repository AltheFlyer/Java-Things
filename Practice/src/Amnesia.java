import java.util.Scanner;
import java.util.Random;

public class Amnesia {

	public static void main(String[] args) {
		
		String input = "";
		String output = "";
		String last = "";
		int sections = 0;
		int chapter = 1;
		int random = 0;
		Scanner scanner = new Scanner(System.in);
		Random dice = new Random();

		System.out.print("Input how many divisions you want:\n>>>");
		sections = scanner.nextInt();
		sections = 15;
		
		//String chapters[] = new String[sections];
		String chapters[] = {
		"DO IT, just DO IT! ",		
		"Don’t let your dreams be dreams. ",	
		"Yesterday, you said tomorrow. ",
		"So just. DO IT! ",
		"Make. your dreams. COME TRUE! ",
		"Just… do it! ",
		"Some people dream of success, ",
		"while you’re gonna wake up and work HARD at it! ",
		"NOTHING IS IMPOSSIBLE!",
		"You should get to the point where anyone else would quit, ",
		"and you’re not gonna stop there. NO! ",
		"What are you waiting for? ",
		"… DO IT! Just… DO IT! ",
		"Yes you can! Just do it! ",
		"If you’re tired of starting over, stop. giving. up."
		};
		
		input = scanner.nextLine();
		/*
		for (int i = 0; i < sections; i ++) {
			System.out.printf("Enter the text for section %d", i + 1);
			input = scanner.nextLine();
			chapters[i] = input;
			System.out.println(i);
		}
		*/
		
		System.out.println(chapters[0]);
		
		while (chapter < sections) {
			random = dice.nextInt(100);
			if (random < (int) 100 / chapter) {
				output = chapters[chapter];
			} else {
				output = chapters[dice.nextInt(chapter)];
			}
			if (!output.equals(last)) {
				System.out.println(output);
				last = output;
				if (output.equals(chapters[chapter])) {
					chapter ++;
				}
			}
		}
		


	}

}
