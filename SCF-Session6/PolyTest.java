package poly;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {

	
	@Test
	public void test() {
		int[][] coefficientAndExponent = new int[][] {{1,2} ,{2,1} ,{1, 0}};
		int[][] coefficientAndExponent1 = new int[][] {{2,3}, {1,2} ,{2,1} ,{1, 0}};
		
		Poly poly = new Poly(coefficientAndExponent);
		Poly poly1 = new Poly(coefficientAndExponent);
		assertEquals(4.0f, poly.evaluate(1.0f), 0.0f);
		assertEquals(2, poly.degree());
		
		Poly p1 = new Poly(coefficientAndExponent);
		Poly p2 = new Poly(coefficientAndExponent1);
		assertNotNull(poly.addPoly(p1, p2));
		
		assertNotNull(poly.multiplyPoly(p1, p2));
	}

}
