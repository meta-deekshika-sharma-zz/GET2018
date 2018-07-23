package stringFunctions;

import static org.junit.Assert.*;

import org.junit.Test;

/** This class will have number of test cases regarding strings 
 * @author Deekshika Sharma
 *
 */
public class StringTest {

	StringFunctions string = new StringFunctions();
	
	/**
	 * This test cases are consider in positive test cases
	 */
	@Test
	public void stringTest() {
		
		assertEquals(1, string.compareStrings("hlo", "hlo"));
		assertEquals("5%RTeeG&&88F", string.changeCaseOfString("5%rtEEg&&88f"));
		assertEquals("doog", string.reverseString("good"));
		assertEquals(3, string.stringLength("sky"));
		
		assertEquals(0, string.compareStrings("hlo", "hloo"));
	}

	/**
	 * This method will have negative test cases
	 */
	@Test(expected = AssertionError.class)
	public void stringTestError() {
		
		assertEquals(0, string.compareStrings("", ""));
		assertEquals("", string.changeCaseOfString(""));
		
	}
}
