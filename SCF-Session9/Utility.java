package graphics;

/**
 * @author Deekshika Sharma This is a helper class which have method to
 *         calculate distance between two points
 */
public class Utility {

	/**
	 * This method will calculate the distance between two points
	 * 
	 * @param isEnclosedPoint
	 * @param origin
	 * @return the calculates distance
	 */
	public static double calculateDistance(Point point1, Point point2) {
		int xDistance = point2.getX() - point1.getX();
		int yDistance = point2.getY() - point1.getY();

		return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
	}
}
