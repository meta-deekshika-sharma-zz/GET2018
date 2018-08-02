package graphics;

import java.util.Date;

/**
 * @author Deekshika Sharma This interface will specify the general shape which
 *         will be implemented in many classes It have some methods which will
 *         override in concrete classes
 */
public interface Shape {

	public double getArea();

	public double getPerimeter();

	public Point getOrigin();

	public boolean isPointEnclosed(Point isEnclosedPoint);

	public ShapeTypes getShapeType();

	public double getOriginDistance();

	public Date getCurrentDate();
}
