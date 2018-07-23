package areaFunctions;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class will contain the test cases for different area operations
 * @author Deekshika Sharma
 *
 */
public class AreaTest {

	Area area = new Area();
	
	/**
	 * This test case checks the possible input for triangle area
	 */
	@Test
	public void triangleAreaTest() {
		double triangleArea1 = area.triangleArea(4, 5);
		assertEquals(10.0, triangleArea1, 0.0);
		double triangleArea2 = area.triangleArea(0, 0);
		assertEquals(0.0, triangleArea2, 0.0);
		double triangleArea3 = area.triangleArea(2.9, 3.0);
		assertEquals(4.35, triangleArea3, 0.0);
	}

	/**
	 * This test case checks the possible input for rectangle area
	 */
	@Test
	public void rectangleAreaTest() {
		double rectangleArea1 = area.rectangleArea(20, 4);
		assertEquals(80.0, rectangleArea1, 0.0);
		double rectangleArea2 = area.rectangleArea(0, 0);
		assertEquals(0.0, rectangleArea2, 0.0);
		double rectangleArea3 = area.rectangleArea(3.8, 1);
		assertEquals(3.8, rectangleArea3, 0.0);
	}
	
	/**
	 * This test case checks the possible input for square area
	 */
	@Test
	public void squareAreaTest() {
		double squareArea1 = area.squareArea(2.5);
		assertEquals(6.25, squareArea1, 0.0);
		double squareArea2 = area.squareArea( 0);
		assertEquals(0.0, squareArea2, 0.0);
		double squareArea3 = area.squareArea(3);
		assertEquals(9, squareArea3, 0.0);
	}
	
	/**
	 * This test case checks the possible input for circle area
	 */
	@Test
	public void circleAreaTest() {
		double circleArea1 = area.circleArea(2.5);
		assertEquals(19.625, circleArea1, 0.0);
		double circleArea2 = area.circleArea( 0);
		assertEquals(0.0, circleArea2, 0.0);
		
	}
}
