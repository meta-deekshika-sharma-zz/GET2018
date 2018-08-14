package graphics;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Deekshika Sharma This class implements the Shape interface and used
 *         for performing operations on Circle
 */
public class Circle implements Shape {

	private static final double PI = 3.14;
	private int radius;
	private Point centerPoint;
	private double originDistance;
	private Date localDateTime;

	/**
	 * The constructor is initializes when circle shape is created
	 * 
	 * @param point
	 * @param values
	 */
	public Circle(Point centerPoint, int values) {
		this.centerPoint = centerPoint;
		this.radius = values;
		this.originDistance = Utility.calculateDistance(getOrigin(), new Point(
				0, 0));
		this.localDateTime = new Date();
	}

	/**
	 * This method will return the area of circle
	 */
	@Override
	public double getArea() {

		return PI * radius * radius;
	}

	/**
	 * This method will return the perimeter of circle
	 */
	@Override
	public double getPerimeter() {

		return 2 * PI * radius;
	}

	/**
	 * This method will return the origin of the circle
	 */
	@Override
	public Point getOrigin() {
		double slope = (double) centerPoint.getY() / centerPoint.getX();

		int distance = (int) Math.sqrt(centerPoint.getY() * centerPoint.getY()
				+ centerPoint.getX() * centerPoint.getX());

		int remainingDistance = distance - radius;

		int x_origin = (int) Math.sqrt((remainingDistance * remainingDistance)
				/ (1 + slope * slope));

		int y_origin = (int) slope * x_origin;
		return new Point(x_origin, y_origin);
	}

	/**
	 * This method will find that the given point is enclosed in circle or not
	 */
	@Override
	public boolean isPointEnclosed(Point isEnclosedPoint) {

		double distance = Utility.calculateDistance(isEnclosedPoint,
				centerPoint);

		if (distance <= radius)
			return true;
		else
			return false;
	}

	/**
	 * This method will return the shape type of circle
	 */
	@Override
	public ShapeTypes getShapeType() {
		return ShapeTypes.CIRCLE;
	}

	/**
	 * This method will return the distance from the origin of the screen to the
	 * origin of circle
	 */
	@Override
	public double getOriginDistance() {
		return originDistance;
	}

	@Override
	public Date getCurrentDate() {
		return localDateTime;
	}
}
