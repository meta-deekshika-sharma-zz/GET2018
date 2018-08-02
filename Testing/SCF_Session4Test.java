package assignment4;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * This class contains the various test cases applied on various operations
 * @author Deekshika Sharma
 *
 */
public class SCF_Session4Test {

	ArrOperation arrOperation = new ArrOperation();
	
	
	/**
	 * This method will apply test cases on maxMirror operation
	 * The result will be matched with expected value
	 */
	@Test
	public void mnirrorTest1() {
		int maxValue1 = arrOperation.maxMirror(new int[]{1,2,3,4,5,3,2,1,2,2,1});
		assertEquals(4, maxValue1);
		int maxValue2 = arrOperation.maxMirror(new int[]{1,1,1,1,1});
		assertEquals(5, maxValue2);
		int maxValue3 = arrOperation.maxMirror(new int[]{1,4,5,3,5,4,1});
		assertEquals(7, maxValue3);
	}
	
	/**
	 * This method will apply test cases on countClumps operation
	 * The result will be matched with expected value
	 */
	@Test
	public void countClumpsTest() {
		int count1 = arrOperation.countClumps(new int[]{1,2,2,3,4,4});
		assertEquals(2, count1);
		int count2 = arrOperation.countClumps(new int[]{1,2,2,2,3,4,4});
		assertEquals(2, count2);
		int count3 = arrOperation.countClumps(new int[]{1,1,1,1,1});
		assertEquals(1, count3);
	}

	 /**
	 * This method will apply test cases on indexSplitArray operation
	 * The result will be matched with expected value
	 */
	@Test
	public void splitArrayTest() {
		int index1 = arrOperation.indexSplitArray(new int[]{2,2});
        assertEquals(1, index1);
        int index2 = arrOperation.indexSplitArray(new int[]{2,1,1,2,1});
        assertEquals(-1, index2);
        int index3 = arrOperation.indexSplitArray(new int[]{1,1,1,2,1});
        assertEquals(3, index3);
        int index4 = arrOperation.indexSplitArray(new int[]{6,1,1,2,2});
        assertEquals(1, index4);
	}
	
	/**
	 * This method will apply test cases on fixXYArray operation
	 * The result will be matched with expected value
	 */
	@Test
	public void fixXYTest() {
		int[] result1 = arrOperation.fixXYArray(new int[]{5,4,9,4,9,5},4,5);
		assertArrayEquals(new int[]{9,4,5,4,5,9}, result1);	
		int [] result2 = arrOperation.fixXYArray(new int[]{1,4,1,5}, 4, 5);
		assertArrayEquals(new int[]{1,4,5,1}, result2);	
	}
	/**
	 * This method will applied if given input array is empty
	 */
	@Test(expected = AssertionError.class)
	public void mirrorAssertionError() {
		int result = arrOperation.maxMirror(new int[]{});
	}
	
	/**
	 * This method will applied if given input array is empty
	 */
	@Test(expected = AssertionError.class)
	public void countClumpsAssertionError() {
		int result = arrOperation.countClumps(new int[]{});
	}
	
	/**
	 * This method will applied if given input array is empty
	 */
	@Test(expected = AssertionError.class)
	public void splitArrayAssertionError() {
		int result = arrOperation.indexSplitArray(new int[]{});
	}
	
	/**
	 * This method will applied if given input array is empty
	 */
	@Test(expected = AssertionError.class)
	public void fixXyAssertionError() {
		int result[] = arrOperation.fixXYArray(new int[]{}, 0 , 0); // if given array is empty
		int result1[] = arrOperation.fixXYArray(new int[]{1,2,2,4,5}, 2, 3); // if there are two adjacent x are present
		int result2[] = arrOperation.fixXYArray(new int[]{1,2,2,3,5}, 2, 3); // if there are unequal no. of x and y are present
		int result3[] = arrOperation.fixXYArray(new int[]{1,2,2,3,2}, 2, 3); // if x is present at the last index
	}
}
