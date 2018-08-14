package graphics;

import java.util.List;

/**
 * @author Deekshika Sharma This class represent the factory class which create
 *         the objects of different shapes
 */
public class ShapeFactory {

	/**
	 * This method will create a specific type of shape based on parameters
	 * 
	 * @param shapeType
	 * @param point
	 * @param parameters
	 * @return shape object
	 */
	public static Shape createShape(ShapeTypes shapeType, Point point,
			List<Integer> parameters) {
		Shape shape = null;
		// Implements the shapeType enum
		switch (shapeType) {
		case CIRCLE:
			shape = new Circle(point, parameters.get(0));
			break;
		case POLIGON:
			shape = new Polygon(point, parameters.get(0), parameters.get(1), 5);
			break;
		case RECTANGLE:
			shape = new Rectangle(point, parameters.get(0), parameters.get(1));
			break;
		case SQUARE:
			shape = new Square(point, parameters.get(0));
			break;
		case TRIANGLE:
			shape = new Triangle(point, parameters.get(0), parameters.get(1),
					parameters.get(2), parameters.get(3));
			break;

		}

		return shape;
	}
}
