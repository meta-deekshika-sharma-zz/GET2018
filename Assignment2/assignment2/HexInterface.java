package assignment2;

/**
 * This interface will contain the methods which is to be implemented in other classes to make them generic
 * @author User15
 */
public interface HexInterface {

	public int decimalValue (String hexValue);
	public String hexadecimalValue (int decimalValue);
	public int addHexValue (int decimalFirst, int decimalSecond);
	public int substractHexValue (int decimalFirst, int decimalSecond);
	public int mulHexValue (int decimalFirst, int decimalSecond);
	public int divideHexValue (int decimalFirst, int decimalSecond);
	public String removeLeadingZeroes (String hexNumber);
	public boolean equals(String hexValueFirst, String hexValueSecond);
	public boolean greaterThen(String hexValueFirst, String hexValueSecond);
	public boolean lessThen(String hexValueFirst, String hexValueSecond);
}
