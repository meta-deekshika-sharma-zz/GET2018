package nestedList;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma
 * This class will have the methods for testing the nested list classes
 */
public class NestedListTest {

	// This test case is implemented for nested list implementation and return sum of list element, max in list and search a value in list
	@Test
	public void nestedListImplementationTest() {
		NestedList nestedList = new NestedListImplementation("D:\\java\\DS-Session2\\test.json");
		assertEquals(207, nestedList.sumOfList());
		assertEquals(99, nestedList.largestValue());
		assertTrue(nestedList.searchValue(99));
	}

	// This test case is implemented for nested list search and it will search based on a string
	@Test
	public void nestedListSearchtest() {
		NestedListImplementation nestedList = new NestedListImplementation("D:\\java\\DS-Session2\\test.json");
		NestedListSearch search = new NestedListSearch(nestedList);
		assertEquals(5, search.getValue("thh"));
	}
	
	@Test(expected = AssertionError.class)
	public void nestedListErrortest() {
		NestedListImplementation nestedList = new NestedListImplementation("D:\\java\\DS-Session2\\test.json");
		NestedListSearch search = new NestedListSearch(nestedList);
		assertEquals(5, search.getValue("th")); // if a list is found then give error
		assertEquals(5, search.getValue("ht")); // give error if list is found
	}
}
