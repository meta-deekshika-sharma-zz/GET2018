package mutablePoly;

import static org.junit.Assert.*;

import org.junit.Test;


public class MutablePolyTest {

	int[][] coefficientAndExponent = new int[][] {{1,2} ,{2,1} ,{1, 0}};
	int[][] coefficientAndExponent1 = new int[][] {{2,3}, {1,2} ,{2,1} ,{1, 0}};
	
	MutablePoly mutablePoly = new MutablePoly(coefficientAndExponent);
	MutablePoly mutablePoly1 = new MutablePoly(coefficientAndExponent1);
	
	@Test
	public void MutableTest() {
		assertEquals(4.0f, mutablePoly.evaluate(1.0f), 0.0f);
		assertEquals(2, mutablePoly.degree());
			
		mutablePoly.addElementPoly(3, 2);
		mutablePoly.removeElementPoly(1);
		
		assertNotNull(mutablePoly.addPoly(mutablePoly, mutablePoly1));
		
		assertNotNull(mutablePoly.multiplyPoly(mutablePoly1, mutablePoly));
	}
	
	@Test(expected = AssertionError.class)
	public void ErrorTest () {
		mutablePoly.removeElementPoly(3);
	}
	
}
