import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {

	public static void main(String[] args) {
		
		//This list is locked to accepting coordinate objects
		ArrayList<Coordinate> list = new ArrayList<Coordinate>();
		
		list.add(new Coordinate(1, 1));
		list.add(new Coordinate(2, 2));
		list.add(new Coordinate(3, 3));
		
		//Iterator lets you use underlying list objects
		//Also lets you directly modify indices
		Iterator<Coordinate> iter = list.iterator();
		
		//Show number of objects in list
		System.out.println(list.size());
		while(iter.hasNext()) {
			//Calling iter.next moves to the next index
			//this can crash the program
			//iter.next();
			System.out.println(iter.next().getCoordinates());
		}
		//Gets rid of the last index
		iter.remove();
		
		//Will only show 2 items
		System.out.println(list.size());
		iter = list.iterator();
		while(iter.hasNext()) {
			//Calling iter.next moves to the next index
			//this can crash the program
			//iter.next();
			System.out.println(iter.next().getCoordinates());
		}

	}

}
