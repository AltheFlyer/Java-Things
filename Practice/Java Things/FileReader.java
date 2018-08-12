import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class FileReader {

	public static void main(String[] args) throws IOException {
		Path file = Paths.get("Java Things\\Test.txt");
		Path lines = Paths.get("Java Things\\Lines.txt");
		Path toWrite = Paths.get("Java Things\\WriteHere.txt");
		
		//Reading bytes
		byte[] fileArray;
		fileArray = Files.readAllBytes(file);
		
		for (byte b: fileArray) {
			//Convert the bytes to characters
			System.out.print((char) b);
		}
		System.out.println();
		
		//Reading by line
		List<String> lineArray;
		lineArray = Files.readAllLines(lines);
		
		for (String s: lineArray) {
			//Doesn't include \n
			System.out.println(s);
		}
		
		//Writing
		//Bytes
		//This line writes to the file
		Files.write(toWrite, fileArray);
		//This line clears the file then writes
		Files.write(toWrite, fileArray);
		//this line appends to the file
		Files.write(toWrite, fileArray, StandardOpenOption.APPEND);
		
		//Write a bunch of ASCII
		byte[] val = new byte[255];
		for (int i = 0; i < 255; ++i) {
			val[i] = (byte) i;
		}
		
		Files.write(toWrite, val, StandardOpenOption.APPEND);
		
	}

}
