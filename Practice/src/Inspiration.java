import java.util.Random;

public class Inspiration {

	public static void main(String[] args) {
		
		String output = "";
		String last = "";
		int sections = 15;
		int chapter = 1;
		int random = 0;
		Random dice = new Random();

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
		
		System.out.println(chapters[0]);
		
		//The output
		while (chapter < sections) {
			//Generate a random value
			random = dice.nextInt(100);
			//Chance of saying the correct line
			//Chance goes down the more correct lines have be said
			if (random < (int) 100 / chapter) {
				output = chapters[chapter];
			//Say a random line that has already been said
			} else {
				output = chapters[dice.nextInt(chapter)];
			}
			//Only output if the generated line isn't a repeat of the last one
			if (!output.equals(last)) {
				System.out.println(output);
				last = output;
				//Set the next 'correct' line to be read/checked for
				if (output.equals(chapters[chapter])) {
					chapter ++;
				}
			}
		}
		
	}

}
