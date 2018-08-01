package graphics;

import java.util.Date;

public class Polygon implements Shape{

	private int side;
	private int angle;
	private Point point;
	private int noOfSide;
	private double originDistance;
	private Date localDateTime;
	
	public Polygon(Point point, int angle, int side, int noOfSide) {
		this.point = point;
		this.side = side;
		this.angle = angle;
		this.noOfSide = noOfSide;
		this.originDistance = Utility.calculateDistance(point, new Point(0,0));
		this.localDateTime = new Date();
	}
	
	@Override
	public double getArea() {
		return (getPerimeter() * getApothem())/2.0;
	}

	@Override
	public double getPerimeter() {
		return side * noOfSide;
	}

	@Override
	public Point getOrigin() {
		return new Point(point.getX(), point.getY());
	}

	@Override
	public boolean isPointEnclosed(Point isEnclosedPoint) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ShapeTypes getShapeType() {
		
		return ShapeTypes.POLIGON;
	}
	
	private double getApothem()
	{
		return (side /(2 * Math.tan(180/noOfSide)));
	}
	
	/**
	 * This method will return the distance from the origin of the screen to the origin of polygon
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
