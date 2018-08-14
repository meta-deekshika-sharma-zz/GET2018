package dictionaryImplementation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Deekshika Sharma
 * This class will have test cases for Dictionary using binary search tree
 */
public class DictionaryTest {

	Dictionary dictionaryImplementation = new DictionaryImplementation("D:\\java\\Dictionary\\Trees.json");

	// This test case is run before all test cases and add key value pair to
	// dictionary
	@Before
	public void addValues() {

		assertNotNull(dictionaryImplementation.addKeyValuePair("d", "dd"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("b", "bb"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("c", "cc"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("a", "aa"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("e", "ee"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("g", "gg"));
		assertNotNull(dictionaryImplementation.sortedList());
		assertNotNull(dictionaryImplementation.sortedListBetweenKeys("a", "d"));
	}

	// This test will delete the key value pair from dictionary
	@Test
	public void deleteValues() {
		assertNotNull(dictionaryImplementation.deleteKeyValuePair("a"));
		assertNotNull(dictionaryImplementation.deleteKeyValuePair("e"));

		assertNotNull(dictionaryImplementation.sortedList());
		assertNotNull(dictionaryImplementation.sortedListBetweenKeys("c", "g"));
	}

	// This test case will return values corresponding to key
	@Test
	public void getValues() {
		assertEquals("bb", dictionaryImplementation.getValueForKey("b"));
		assertEquals(
				"Pistachio shells may be helpful in cleaning up pollution created by mercury emissions",
				dictionaryImplementation.getValueForKey("Pistachio"));
	}

	// This test case is run for assertion error
	@Test(expected = AssertionError.class)
	public void dictionaryErrors() {
		assertEquals("bb", dictionaryImplementation.getValueForKey("po")); // give
																			// error
																			// when
																			// key
																			// is
																			// not
																			// found
		assertNotNull(dictionaryImplementation.addKeyValuePair("g", "hh")); // give
																			// error
																			// when
																			// key
																			// is
																			// reentered
		assertNotNull(dictionaryImplementation.addKeyValuePair("", "")); // give
																			// error
																			// if
																			// key
																			// or
																			// value
																			// is
																			// empty
	}
}
