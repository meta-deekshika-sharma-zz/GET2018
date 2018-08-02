package graphics;

import java.util.Date;

/**
 * @author Deekshika Sharma This class implements the Shape interface and used
 *         for performing operations on Triangle
 */
public class Triangle implements Shape {

	private Point point;
	private int side3;
	private int side1;
	private int side2;
	private int height;
	private double originDistance;
	private Date localDateTime;

	/**
	 * The constructor is initializes when triangle shape is created
	 * 
	 * @param point
	 * @param values
	 */
	public Triangle(Point point, int side1, int side2, int side3, int height) {
		this.point = point;
		this.side3 = side3;
		this.side1 = side1;
		this.side2 = side2;
		this.height = height;
		this.originDistance = Utility.calculateDistance(point, new Point(0, 0));
		this.localDateTime = new Date();
	}

	@Override
	public double getArea() {
		return calculateArea(side1, side2, side3);
	}

	@Override
	public double getPerimeter() {

		return (side1 + side2 + side3);
	}

	@Override
	public Point getOrigin() {

		return new Point(point.getX(), point.getY());
	}

	/**
	 * This method will find that given point is enclosed in the triangle or not
	 */
	@Override
	public boolean isPointEnclosed(Point isEnclosedPoint) {
		Point point1 = new Point(point.getX() + side1, point.getY());

		Point point2 = new Point((int) (Math.sqrt((this.side2 * this.side2)
				- (this.height * this.height))), this.height);

		double area = calculateAreaOfTriangleByCornerPoints(point1, point2,
				isEnclosedPoint)
				+ calculateAreaOfTriangleByCornerPoints(this.point, point2,
						isEnclosedPoint)
				+ calculateAreaOfTriangleByCornerPoints(point1, this.point,
						isEnclosedPoint);

		if (area == this.getArea())
			return true;
		else
			return false;
	}

	@Override
	public ShapeTypes getShapeType() {

		return ShapeTypes.TRIANGLE;
	}

	/**
	 * This method will calculate the area of triangle by their corner points
	 * 
	 * @param point1
	 * @param point2
	 * @param point3
	 * @return area of triangle
	 */
	private double calculateAreaOfTriangleByCornerPoints(Point point1,
			Point point2, Point point3) {
		double sideOneLength = Utility.calculateDistance(point1, point2);
		double sideTwoLength = Utility.calculateDistance(point2, point3);
		double sideThreeLength = Utility.calculateDistance(point3, point1);
		return calculateArea(sideOneLength, sideTwoLength, sideThreeLength);
	}

	/**
	 * This method will return the calculate area
	 * 
	 * @param sideOne
	 * @param sideTwo
	 * @param sideThree
	 * @return
	 */
	private double calculateArea(double sideOne, double sideTwo,
			double sideThree) {
		double halfOfPerimeter = (side1 + side2 + side3) / 2.0;
		return Math.sqrt(halfOfPerimeter * (halfOfPerimeter - side1)
				* (halfOfPerimeter - side2) * (halfOfPerimeter - side3));
	}

	/**
	 * This method will return the distance from the origin of the screen to the
	 * origin of triangle
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
