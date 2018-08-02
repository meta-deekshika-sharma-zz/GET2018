package graphics;

/**
 * @author Deekshika Sharma This class is used to set the x and y coordinate
 *         value to a point
 */
public class Point {

	private final int x;
	private final int y;

	/**
	 * This constructor will initializes the x and y coordinate value in
	 * constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Return the value of x coordinate
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Return the value of y coordinate
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

}
