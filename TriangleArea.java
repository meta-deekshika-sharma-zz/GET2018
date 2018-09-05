package com.area;

/**
*This class is used to calculate the area of the triangle
*/
public class TriangleArea {

	public double triangleArea(int side1, int side2, int side3) {
		double side = (side1 + side2 + side3) / 2;

		return Math.sqrt(side * (side - side1) * (side - side2)
				* (side - side3));
	}
}
