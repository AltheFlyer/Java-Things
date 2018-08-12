
public class Coordinate {
	
	float x;
	float y;
	
	public Coordinate(float x1, float y1) {
		x = x1;
		y = y1;
	}
	
	public String getCoordinates() {
		return "[" + x + ", " + y + "]";
	}
}
