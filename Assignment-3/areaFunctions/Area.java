package areaFunctions;

/**
 * this class will contains methods which calculate of areas of different shapes
 * @author Dell
 * arithmetic exceptions are handled
 */
public class Area {
	
	/**
	 * this method will calculate the area of triangle
	 * @param height take height of triangle
	 * @param width take the width of triangle
	 * @return area of triangle
	 * @throws ArithmeticException
	 */
	public double triangleArea (double height, double width) throws ArithmeticException
	{
		return (height * width)/2;
	}

	/**
	 * this method will calculate the area of rectangle
	 * @param height take height of rectangle
	 * @param width take the width of rectangle
	 * @return area of rectangle
	 * @throws ArithmeticException
	 */
	public double rectangleArea (double height, double width) throws ArithmeticException
	{
		return (height * width);
	}

	/**
	 * this method will calculate the area of square
	 * @param width take the width of square
	 * @return area of square
	 * @throws ArithmeticException
	 */
	public double squareArea (double width) throws ArithmeticException
	{
		return (width * width);
	}

	/**
	 * this method will calculate the area of circle
	 * @param radius take the width of circle
	 * @return area of circle
	 * @throws ArithmeticException
	 */
	public double circleArea (double radius) throws ArithmeticException
	{
		return (3.14 * radius * radius);
	}
}
