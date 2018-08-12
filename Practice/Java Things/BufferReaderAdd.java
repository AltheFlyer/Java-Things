import java.io.*;
import java.util.*;

public class BufferReaderAdd {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
		n = Integer.valueOf(input.readLine());
        for (int i = 0; i < n; i ++) {
        	String[] tokens = input.readLine().split(" ");
        	int a = Integer.parseInt(tokens[0]);
        	int b = Integer.parseInt(tokens[1]);
        	System.out.println(a + b);
        }
    }
}