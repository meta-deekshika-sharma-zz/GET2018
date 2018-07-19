package assignment2;

/**
 * This interface will contain the methods which is to be implemented in other classes to make them generic
 * @author User15
 */
public interface HexInterface {
	
	public int decimalValue (String hexValue);
	
	public String hexadecimalValue (int decimalValue);
	
	public String addHexValue ( String hexaFirst, String hexaSecond);
	
	public String substractHexValue (String hexaFirst, String hexaSecond);
	
	public String mulHexValue (String hexaFirst, String hexaSecond);
	
	public String divideHexValue (String hexaFirst, String hexaSecond);
	
	public String removeLeadingZeroes (String hexNumber);
	
	public boolean equals(String hexValueFirst, String hexValueSecond);
	
	public boolean greaterThen(String hexValueFirst, String hexValueSecond);
	
	public boolean lessThen(String hexValueFirst, String hexValueSecond);
}
