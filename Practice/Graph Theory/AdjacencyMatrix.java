import java.util.*;
import java.io.*;

public class AdjacencyMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// A matrix of 0s or 1s (or 2s), showing if there are connections between the nodes
		// For two way connections
		int nodes = 5;
		nodes = scan.nextInt();
		int matrix[][] = new int[nodes][nodes];
		
		for (int x = 0; x < nodes; x ++) {
			for (int y = 0; y < nodes; y ++) {
				matrix[x][y] = 0;
			}
		}
		
		System.out.println("Enter the two nodes you want to connect.");
		System.out.println("Type -1 to stop.");
		int x = 0, y = 0;
		while (x != -1 && y != -1) {
			x = scan.nextInt();
			y = scan.nextInt();
			if (x != -1 && y != -1) {
				matrix[x][y] = 1;
				matrix[y][x] = 1; //remove this for one way graphs
				System.out.println("Edge added");
			}
		}
		
		for (int a = 0; a < nodes; a ++) {
			System.out.printf("Node %d connections: ", a);
			for (int b = 0; b < nodes; b ++) {
				if (matrix[a][b] == 1) {
					System.out.print(b + " ");
				}
			}
			System.out.println();
		}
		System.out.println("Matrix:");
		for (int a = 0; a < nodes; a ++) {
			for (int b = 0; b < nodes; b ++) {
				System.out.print(matrix[a][b] + " ");
			}
			System.out.println();
		}
	}

}
