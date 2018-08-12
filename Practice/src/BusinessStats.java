import java.util.Arrays;

public class BusinessStats {

	public static void main(String[] args) {
		
		int adverts = 7;
		int weeks = 20;
		double[][] aware = new double[adverts + 1][weeks + 1];
		for (int i = 0; i < weeks + 1; ++i) {
			for (int j = 0; j < adverts + 1; ++j) {
				aware[j][i] = -1;
			}
		}
		
		aware[0][0] = 20;
		
		for (int i = 0; i < weeks + 1; ++i) {
			for (int j = 0; j < adverts + 1; ++j) {
				if (aware[j][i] > -1) {
					if (i < weeks && i != weeks - (7 - j) && aware[j][i] * 0.8 > aware[j][i + 1]) {
						aware[j][i + 1] = aware[j][i] * 0.8;
					}
					if (i <= weeks - (7 - j) && j < adverts && i < weeks && aware[j][i] * 1.2 > aware[j][i + 1]) {
						aware[j + 1][i + 1] = aware[j][i] * 1.2;
					}
				}
			}
		}
		
		for (int i = 0; i < weeks + 1; ++i) {
			for (int j = 0; j < adverts + 1; ++j) {
				System.out.printf("%3.2f ", aware[j][i]);
			}
			System.out.println();
		}
	}

}
