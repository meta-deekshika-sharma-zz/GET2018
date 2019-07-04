package setOperation;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * There are multiple test cases are present for set operation
 * @author Deekshika Sharma
 *
 */
public class SetTest {

	IntSet intSet = new IntSet(new int[] {2,4,5,7});
	IntSet result = new IntSet(new int[] {1,6,3,8,9,10,6,7,5,3});
	IntSet errorSet = new IntSet(new int[] {1002});
	IntSet intSetError = new IntSet(new int[] {});
	
	/**
	 * There are positive test cases are present
	 */
	@Test
	public void test() {
		assertTrue(intSet.isMember(4)); // check if 4 is member of intSet
		assertTrue(intSet.isSubSet(intSet)); // check if intSet is subset of universal set
		assertEquals(4, intSet.size()); // return size of intSet
		assertNotNull(intSet.getComplement()); // return the complement of intSet
		
		assertNotNull(intSet.unionOfSet(intSet, result)); // shows result of union set
		
	}
	
	/**
	 * There are negative test cases are present
	 */
	@Test(expected = AssertionError.class)
	public void ErrorTest() {
		
		assertFalse(intSet.isMember(9)); // false when value is not found
		assertFalse(intSet.isSubSet(errorSet));// false when value is not found
		assertNull(intSetError.getComplement()); // when set is empty
		assertNull(intSet.unionOfSet(intSetError, intSet)); // when one of or both sets are empty
	}

}
