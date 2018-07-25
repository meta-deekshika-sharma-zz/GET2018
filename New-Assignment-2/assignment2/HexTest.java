package assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class will have number of test cases apply on hexadecimal values
 * @author Deekshika Sharma
 *
 */
public class HexTest {

	HexCalc hex = new HexCalc();
	
	/**
	 * This test case will check the number of expected value with the actual value.
	 */
	@Test
	public void Hextest() {
		String hexValue = hex.addHexValue("3B", "1F");
		assertEquals("5A", hexValue);
		assertEquals("3AF", hex.substractHexValue("4F5", "146"));
		assertEquals("2E17", hex.mulHexValue("45", "AB"));
		assertEquals("1", hex.divideHexValue("123", "123"));
		assertEquals(59, hex.decimalValue("3B"));
		assertEquals("3D", hex.hexadecimalValue(61));
		
		assertEquals(true, hex.equals("54", "54"));
		assertEquals(true, hex.lessThen("5F", "6D"));
		assertEquals(true, hex.greaterThen("FF", "6D"));
		
		assertEquals(false, hex.equals("54", "84"));
		assertEquals(false, hex.lessThen("5F4", "6D"));
		assertEquals(false, hex.greaterThen("FF", "64D"));
		
		assertEquals(true, hex.isNumberValid("99"));
		assertEquals(false, hex.isNumberValid("8y"));
	}

}
