package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class will have various recursion methods
 * @author Deekshika Sharma
 */
public class RecursionTest {
	
	/** 
	 * This method will have LCM and HCF test cases with expected and actual values
	 */
	@Test
	public void MathsTest() {
		MathsOperation maths = new MathsOperation();
		assertEquals(18, maths.LCM(9, 6));
		assertEquals(3, maths.HCF(9, 6));
	}

	/** 
	 * This method will have Binary Search and Linear Search test cases with expected and actual values
	 */
	@Test
	public void searchTest() {
		Search search = new Search();
		int linear = search.linearSearch(new int[] {2,4,8,4,5,3,9}, 0, 4);
		assertEquals(1, linear);
		int binary = search.binarySearch(new int[]{2,3,5,7,9,10,12}, 0, 6, 10);
		assertEquals(5, binary);
	}
	
	/** 
	 * This method will have N Queens Problem test case
	 * It return true if all queens are placed
	 */
	@Test
	public void queenTest() {
		QueensProblem queen = new QueensProblem();
		int[][] array = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		boolean result = queen.nQueen(array, 0, 4);
		assertEquals(true, result);
	}
}

