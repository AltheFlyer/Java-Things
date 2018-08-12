import java.util.Scanner;

public class CircleSurround {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input = "q";
		double[] rectangle = new double[4];
		double[] circle = new double[4];
		double centerX, centerY;
		double radius;
		
		//First input
		input = scan.nextLine();
		
		while (!input.equals("")) {
			//Extract numbers
			centerX = Double.valueOf(input.substring(0, input.indexOf(",")));
			input = input.substring(input.indexOf(",") + 1);
			centerY = Double.valueOf(input.substring(0, input.indexOf(",")));
			input = input.substring(input.indexOf(",") + 1);
			radius = Double.valueOf(input);
			
			//set circle values
			circle[0] = centerX - radius;
			circle[1] = centerY - radius;
			circle[2] = centerX + radius;
			circle[3] = centerY + radius;
			
			//Check if circle values would increase rectangle size
			for (int i = 0; i < 4; i ++) {
				//Lower bounds
				if (i < 2) {
					if (circle[i] < rectangle[i]) {
						rectangle[i] = circle[i];
					}
				//Higher bounds
				} else {
					if (circle[i] > rectangle[i]) {
						rectangle[i] = circle[i];
					}
				}
			}
			input = scan.nextLine();
		}
		
		//Output
		System.out.printf("(%.3f, %.3f), (%.3f, %.3f), (%.3f, %.3f), (%.3f, %.3f)", 
				rectangle[0], rectangle[1],
				rectangle[0], rectangle[3],
				rectangle[2], rectangle[3],
				rectangle[2], rectangle[1]
				);
	}

}
