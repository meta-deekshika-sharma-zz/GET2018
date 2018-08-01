package graphics;

/**
 * @author Deekshika Sharma
 * This is a helper class which have method to calculate distance between two points
 */
public class Utility {

	/**
	 * This method will calculate the distance between two points
	 * @param isEnclosedPoint
	 * @param origin
	 * @return the calculates distance
	 */
	public static double calculateDistance(Point isEnclosedPoint, Point origin)
	{
		int xDistance = origin.getX() - isEnclosedPoint.getX();
		int yDistance = origin.getY() - isEnclosedPoint.getY();
		
		return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
	}
}
