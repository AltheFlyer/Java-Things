import java.util.*;
import java.io.*;

public class DijkstraAttempt {
	
	//This appears functional without having to use objects
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of nodes:");
		int n = Integer.parseInt(in.readLine());
		//Each node has stored data: nodes, distance
		HashMap<Integer, Integer>[] nodes = new HashMap[n];
		//Closest distance to home for each node
		int[] distance = new int[n];
		
		for (int i = 0; i < n; ++i) {
			nodes[i] = new HashMap<Integer, Integer>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		//Toggle two way
		System.out.println("Are connections undirected? Type 'y' if so, otherwise, connections will be directed");
		boolean undirected = in.readLine().equals("y");
		System.out.println(undirected);
		//Get inputs
		System.out.println("Enter connections: Start node, end node, distance (all space separated)");
		System.out.println("Enter nothing to stop.");
		String[] tokens = in.readLine().split(" ");
		while (tokens.length > 1) {
			int a = Integer.parseInt(tokens[0]); 
			int b = Integer.parseInt(tokens[1]); 
			int c = Integer.parseInt(tokens[2]); 
			//System.out.printf("%d, %d, %d\n", a, b, c);
			//Make connection
			nodes[a].put(b, c);
			//For two way only:
			if (undirected) {
				nodes[b].put(a, c);
			}
			tokens = in.readLine().split(" ");
		}
		
		//Print Graph
		for (int i = 0; i < n; ++i) {
			//System.out.println(nodes[i].toString());
		}
		
		//Prepare the search
		ArrayList<Integer> q = new ArrayList<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		System.out.println("Choose starting node:");
		int home = Integer.parseInt(in.readLine());
		System.out.println("Choose the destination node:");
		int destination = Integer.parseInt(in.readLine());
		
		distance[home] = 0;
		q.add(home);
		
		while (!q.isEmpty()) {
			int s = q.remove(0);
			System.out.printf("Checking node connections for %d:\n", s);
			for (int c: nodes[s].keySet()) {
				System.out.printf("%d has connection to %d.\n",s ,c);
				if (!visited.contains(c)) {
					q.add(c);
					System.out.printf("Added %d to queue.\n", c);
				}
				if (distance[s] + nodes[s].get(c) < distance[c]) {
					distance[c] = distance[s] + nodes[s].get(c);
					System.out.printf("New distance for node %d is %d.\n", c, distance[c]);
				}
			}
			visited.add(s);
		}
		
		if (distance[destination] < Integer.MAX_VALUE) {
			System.out.printf("The shortest path to %d is %d.\n", destination, distance[destination]);
		} else {
			System.out.printf("Node %d could not be reached.\n", destination);
		}
		
		System.out.println("These are some other values found during the search. They may be inaccurate.");
		for (int i = 0; i < n; ++i) {
			if (distance[i] < Integer.MAX_VALUE) {
				System.out.printf("Distance from node %d: %d\n", i, distance[i]);
			} else {
				System.out.printf("Node %d unreached.\n", i);
			}
		}
	}

}
