import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int nodes;
		nodes = scan.nextInt();
		ArrayList<Integer>[] graph = new ArrayList[nodes];
		
		for (int i = 0; i < nodes; i ++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		System.out.println("Enter the two nodes you want to connect.");
		System.out.println("Type -1 to stop.");
		int x = 0, y = 0;
		while (x != -1 && y != -1) {
			x = scan.nextInt();
			y = scan.nextInt();
			if (x != -1 && y != -1) {
				graph[x].add(y);
				graph[y].add(x); //remove for one way graphs
				System.out.println("Edge added");
			}
		}
		
		for (int a = 0; a < nodes; a ++) {
			System.out.printf("Node %d connections: ", a);
			for (int i: graph[a]) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
