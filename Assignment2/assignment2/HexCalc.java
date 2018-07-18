package assignment2;

/**
 * this class will contain the different methods which will perform calculations on hexa values 
 * @author User15
 * it implements the HexInterface
 */
public class HexCalc implements HexInterface {

	/**
	 * It will convert hexadecimal value into decimal value
	 * @param hexValue contains the input hexadecimal value
	 * @return the decimal value corresponding hexadecimal value
	 */
	@Override
	public int decimalValue (String hexValue)
	{
		hexValue = hexValue.toUpperCase();
		String digits = "0123456789ABCDEF";
		int returnDecimalValue = 0;
		int length = hexValue.length();
		for (int i = 0; i < hexValue.length(); i++)
		{
			length--;
			char c = hexValue.charAt(i);
			int index = digits.indexOf(c);
			returnDecimalValue += (index * (int)Math.pow(16, length));
		}
		return returnDecimalValue;
	}
	

	/**
	 * It will convert decimal value into hexadecimal value
	 * @param decimalValue contains the input decimal value
	 * @return the hexadecimal value corresponding decimal value
	 */
	@Override
	public String hexadecimalValue (int decimalValue)
	{
		int num = decimalValue, temp;
		String decimal = "";
		String digits = "0123456789ABCDEF";
		while (num != 0)
		{
			temp = num % 16;
			num = num / 16;
			char c = digits.charAt(temp);
			decimal = decimal + c;
		}
		
		String reverseDecimalString = "";
		for (int i = decimal.length() - 1; i >= 0; i--)
		{
			reverseDecimalString = reverseDecimalString + decimal.charAt(i);
		}
		return reverseDecimalString;
	}
	
	/**
	 * this method will add two hexadecimal values through converting into decimal value
	 * @param decimalFirst contains first decimal value
	 * @param decimalSecond contains second decimal value
	 * @return corresponding addition result
	 */
	@Override
	public int addHexValue (int decimalFirst, int decimalSecond)
	{
		int add = decimalFirst + decimalSecond;
		return add;
	}
	
	/**
	 * this method will subtract two hexadecimal values through converting into decimal value
	 * @param decimalFirst contains first decimal value
	 * @param decimalSecond contains second decimal value
	 * @return corresponding subtraction result
	 */
	@Override
	public int substractHexValue (int decimalFirst, int decimalSecond)
	{
		int sub = decimalFirst - decimalSecond;
		return sub;
	}
	
	/**
	 * this method will multiply two hexadecimal values through converting into decimal value
	 * @param decimalFirst contains first decimal value
	 * @param decimalSecond contains second decimal value
	 * @return corresponding multiplication result
	 */
	@Override
	public int mulHexValue (int decimalFirst, int decimalSecond)
	{
		int mul = decimalFirst * decimalSecond;
		return mul;
	}
	
	/**
	 * this method will divide two hexadecimal values through converting into decimal value
	 * @param decimalFirst contains first decimal value
	 * @param decimalSecond contains second decimal value
	 * @return corresponding divide result
	 */
	@Override
	public int divideHexValue (int decimalFirst, int decimalSecond)
	{
		int div = decimalFirst / decimalSecond;
		return div;
	}
	
	/**
	 * this method will eliminate the leading zeros present in hexadecimal number
	 * @param hexNumber take hexadecimal value
	 * @return new hexadecimal value removing leading zeroes
	 */
	@Override
	public String removeLeadingZeroes (String hexNumber)
	{
		for(int i = 0; i <hexNumber.length(); i++)
		{ 
			if(hexNumber.charAt(i) != '0')
			{
				return hexNumber.substring(i);
			}
		}
		return "0";
	}
	
	/**
	 * this method will check if two hexadecimal values are equal or not 
	 * @param hexValueFirst takes first hexadecimal value
	 * @param hexValueSecond takes second hexadecimal value
	 * @return result that two values are equal or not
	 */
	@Override
	public boolean equals(String hexValueFirst, String hexValueSecond)
	{
		String firstNumber = removeLeadingZeroes(hexValueFirst);
		String secondNumber = removeLeadingZeroes(hexValueSecond);
		if(firstNumber.equals(secondNumber))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * this method will check if first hexadecimal is greater then other 
	 * @param hexValueFirst takes first hexadecimal value
	 * @param hexValueSecond takes second hexadecimal value
	 * @return result that first values is greater then other
	 */
	@Override
	public boolean greaterThen(String hexValueFirst, String hexValueSecond)
	{
		String firstNumber = removeLeadingZeroes(hexValueFirst);
		String secondNumber = removeLeadingZeroes(hexValueSecond);
		

		int firstLength = firstNumber.length();
		int secondLength = secondNumber.length();
		if(firstNumber.length() == secondNumber.length())
		{
			for (int i = 0, j = 0; i < firstLength || j < secondLength; i++, j++)
			{
				if(firstNumber.charAt(i) > secondNumber.charAt(j))
				{
					return true;
				}
			}
			return false;
		}
		else if (firstLength > secondLength)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * this method will check if first hexadecimal is less then other 
	 * @param hexValueFirst takes first hexadecimal value
	 * @param hexValueSecond takes second hexadecimal value
	 * @return result that first values is less then other
	 */
	@Override
	public boolean lessThen(String hexValueFirst, String hexValueSecond)
	{
		String firstNumber = removeLeadingZeroes(hexValueFirst);
		String secondNumber = removeLeadingZeroes(hexValueSecond);
		

		int firstLength = firstNumber.length();
		int secondLength = secondNumber.length();
		if(firstNumber.length() == secondNumber.length())
		{
			for (int i = 0, j = 0; i < firstLength || j < secondLength; i++, j++)
			{
				if(firstNumber.charAt(i) < secondNumber.charAt(j))
				{
					return true;
				}
			}
			return false;
		}
		else if (firstLength < secondLength)
		{
			return true;
		}
		return false;
	}
}
