package graphics;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains various test cases for screen class
 * @author User15
 */
public class ShapeTest {

	Screen screen = new Screen(100,100); // define the screen where the resolution is specified
	Shape circle, rectangle, polygon, triangle, square;
	List<Integer> shapeList;
	
	/**
	 * This test case is run before other test cases
	 */
	@Before
	public void getShapeList()
	{
	    shapeList = new ArrayList<Integer>();
		shapeList.add(20);
		shapeList.add(30);
		shapeList.add(14);
		shapeList.add(30);
		shapeList.add(20);
	}
	
	/**
	 * This test case will create different shapes to the screen
	 */
	@Test
	public void addShapeTest() {
		
		getShapeList();
		circle = ShapeFactory.createShape(ShapeTypes.CIRCLE, new Point(10, 30), shapeList);
		assertTrue(screen.addShape(circle));
		
		rectangle = ShapeFactory.createShape(ShapeTypes.RECTANGLE, new Point(100, 50), shapeList);
		assertTrue(screen.addShape(rectangle));
		
		polygon = ShapeFactory.createShape(ShapeTypes.POLIGON, new Point(15, 20), shapeList);
		assertTrue(screen.addShape(polygon));
		
		triangle = ShapeFactory.createShape(ShapeTypes.TRIANGLE, new Point(87, 40), shapeList);
		assertTrue(screen.addShape(triangle));
		
		square = ShapeFactory.createShape(ShapeTypes.SQUARE, new Point(20, 20), shapeList);
		assertTrue(screen.addShape(square));
	}

	/**
	 * This test case will remove specified shape from screen
	 */
	@Test
	public void deleteShapeTest() {
		addShapeTest();
		assertTrue(screen.deleteShape(circle));
		assertTrue(screen.addShape(square));
	}
	
	/**
	 * This test case will remove specified type of shapes from screen
	 */
	@Test
	public void deleteShapeTypeTest() {
		
		addShapeTest();
		getShapeList();
		assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.CIRCLE, new Point(20, 20), shapeList)));
		assertTrue(screen.deleteShapeType(ShapeTypes.CIRCLE));
		
		assertTrue(screen.deleteShapeType(ShapeTypes.POLIGON));
		assertFalse(screen.deleteShapeType(ShapeTypes.POLIGON)); // give false when no shape will present on screen
	}
	
	/**
	 * This test case will run and sort the shapes according various parameters
	 */
	@Test
	public void sortShapeTest() {
		addShapeTest();
		getShapeList();;
		Shape circle = ShapeFactory.createShape(ShapeTypes.CIRCLE, new Point(10, 30), shapeList);
		assertTrue(screen.addShape(circle));
		assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.CIRCLE, new Point(20, 20), shapeList)));
		assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.POLIGON, new Point(20, 30), shapeList)));
		assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.TRIANGLE, new Point(39, 22), shapeList)));
		assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.TRIANGLE, new Point(30, 22), shapeList)));
		
		assertNotNull(screen.sortedShapeObject(ShapeSorted.AREA)); // sort based on area
		assertNotNull(screen.sortedShapeObject(ShapeSorted.PERIMETER)); // sort based on perimeter
		assertNotNull(screen.sortedShapeObject(ShapeSorted.ORIGINDISTANCE)); // sort based on origin distance
		assertNotNull(screen.sortedShapeObject(ShapeSorted.TIMESTAMPS)); // sort based on time stamp
	}
	
	/**
	 * This test case will used to find the shapes enclosed to a specific point 
	 */
	@Test
	public void pointEnclosedTest() {
		getShapeList();
		addShapeTest();
	    assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.CIRCLE, new Point(20, 20), shapeList)));
		assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.POLIGON, new Point(20, 30), shapeList)));
		assertTrue(screen.addShape(ShapeFactory.createShape(ShapeTypes.TRIANGLE, new Point(39, 22), shapeList)));
		
		assertNotNull(screen.shapeEnclosedPoints(new Point(20, 30)));
	}

	/**
	 * This test case will run for assertion error
	 */
	@Test(expected = AssertionError.class)
	public void assertionErrorTest() {
		assertTrue(screen.deleteShape(circle)); // give error when delete shape before its creation 
		assertTrue(screen.deleteShapeType(ShapeTypes.POLIGON));
	}
}
