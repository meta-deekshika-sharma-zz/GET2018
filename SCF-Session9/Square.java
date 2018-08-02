package graphics;

import java.util.Date;

/**
 * @author Deekshika Sharma This class implements the Shape interface and used
 *         for performing operations on Square
 */
public class Square implements Shape {

	private int width;
	private Point point;
	private double originDistance;
	private Date localDateTime;

	/**
	 * The constructor is initializes when square shape is created
	 * 
	 * @param point
	 * @param values
	 */
	public Square(Point point, int values) {
		this.width = values;
		this.point = point;
		this.originDistance = Utility.calculateDistance(point, new Point(0, 0));
		this.localDateTime = new Date();
	}

	/**
	 * This method will return the area of the square
	 */
	@Override
	public double getArea() {

		return width * width;
	}

	/**
	 * This method will return the parameter of the square
	 */
	@Override
	public double getPerimeter() {

		return 4 * width;
	}

	/**
	 * This method will return the origin of square
	 */
	@Override
	public Point getOrigin() {
		return new Point(point.getX(), point.getY());
	}

	/**
	 * This method will find that given point is enclosed in the square or not
	 */
	@Override
	public boolean isPointEnclosed(Point isEnclosedPoint) {

		if (isEnclosedPoint.getX() >= point.getX()
				&& isEnclosedPoint.getX() <= (point.getX() + width)
				&& isEnclosedPoint.getY() >= point.getY()
				&& isEnclosedPoint.getY() <= (point.getY() + width))
			return true;
		else
			return false;
	}

	/**
	 * This method will return shape type of square
	 */
	@Override
	public ShapeTypes getShapeType() {

		return ShapeTypes.SQUARE;
	}

	/**
	 * This method will return the distance from the origin of the screen to the
	 * origin of square
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
