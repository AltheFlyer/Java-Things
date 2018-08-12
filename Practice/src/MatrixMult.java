
public class MatrixMult {

	public static long[][] multiply(long[][] a, long[][] b) {
		long[][] ret = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				long sum = 0;
				for (int z = 0; z < 2; z++) {
					sum += a[i][z] * b[z][j];
				}
				ret[i][j] = sum;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		long time;
		time = System.nanoTime();
		int[] fib = new int[32];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 1; i < 31; i++) {
			System.out.println(fib[i] + " ");
			fib[i + 1] = fib[i] + fib[i - 1];
		}
		System.out.println("Runtime: " + (System.nanoTime() - time));
		
		time = System.nanoTime();
		long[][] matrix = { { 1, 0 }, { 0, 0 } };
		long[][] multiplier = { { 1, 1 }, { 1, 0 } };
		long[][] a = multiply(matrix, multiplier);
		for (int i = 0; i < 30; i++) {
			System.out.println(matrix[0][0] + " ");
			matrix = multiply(matrix, multiplier);
		}
		System.out.println("Runtime: " + (System.nanoTime() - time));
		
	}

}
