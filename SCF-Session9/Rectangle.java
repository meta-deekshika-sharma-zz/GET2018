package graphics;

import java.util.Date;

/**
 * @author Deekshika Sharma This class implements the Shape interface and used
 *         for performing operations on Rectangle
 */
public class Rectangle implements Shape {

	private int breadth;
	private int length;
	private Point point;
	private double originDistance;
	private Date localDateTime;

	/**
	 * The constructor is initializes when rectangle shape is created
	 * 
	 * @param point
	 * @param length
	 * @param breadth
	 */
	public Rectangle(Point point, int length, int breadth) {
		this.point = point;
		this.length = length;
		this.breadth = breadth;
		this.originDistance = Utility.calculateDistance(point, new Point(0, 0));
		this.localDateTime = new Date();
	}

	/**
	 * Return the area of the rectangle
	 */
	@Override
	public double getArea() {

		return length * breadth;
	}

	/**
	 * Return the perimeter of the rectangle
	 */
	@Override
	public double getPerimeter() {

		return 2 * (length + breadth);
	}

	/**
	 * This method will return the origin of the Rectangle
	 */
	@Override
	public Point getOrigin() {

		return new Point(point.getX(), point.getY());
	}

	/**
	 * This method will find that given point is enclosed in the shape
	 */
	@Override
	public boolean isPointEnclosed(Point isEnclosedPoint) {

		if (isEnclosedPoint.getX() >= point.getX()
				&& isEnclosedPoint.getX() <= (point.getX() + breadth)
				&& isEnclosedPoint.getY() >= point.getY()
				&& isEnclosedPoint.getY() <= (point.getY() + length))
			return true;
		else
			return false;
	}

	/**
	 * This method will return the type of shape
	 */
	@Override
	public ShapeTypes getShapeType() {

		return ShapeTypes.RECTANGLE;
	}

	/**
	 * This method will return the distance from the origin of the screen to the
	 * origin of rectangle
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
