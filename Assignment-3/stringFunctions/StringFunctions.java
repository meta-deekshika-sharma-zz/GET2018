package stringFunctions;

import java.util.ArrayList;
import java.util.List;


/**
 * this class will include the methods which will perform different operations on string
 * @author User15
 * arithmetic exceptions are handled
 */
public class StringFunctions {
	
	/**
	 * this method will calculate the string length
	 * @param string take string as input
	 * @return the length of string
	 * @throws ArithmeticException
	 */
	public int stringLength (String string) throws ArithmeticException
	{
		string = string + '\0';
		int count = 0;
		for (int i = 0; string.charAt(i) != '\0' ; i++)
		{
			count++;
		}
		return count;
	}
	
	/**
	 * this method will compare the two strings and return 1 if they are same otherwise 0
	 * @param firstString take input the first string
	 * @param secondString take input the first string
	 * @return result 1 if both are same otherwise 0
	 * @throws ArithmeticException
	 */
	public int compareStrings (String firstString, String secondString) throws ArithmeticException
	{
		for (int i = 0, j = 0; i < stringLength(firstString) || j < stringLength(secondString); i++, j++)
		{
			if (firstString.charAt(i) != secondString.charAt(j))
			{
				return 0;
			}
		}
		return 1;
	}
	
	/**
	 * this method will reverse the input string 
	 * @param string takes input in string
	 * @return the reverse string
	 * @throws ArithmeticException
	 */
	public String reverseString (String string) throws ArithmeticException
	{
		String reverseString = "";
		for (int i = 0, j = stringLength(string) - 1; i < stringLength(string) && j >= 0; i++, j--)
		{
			reverseString += string.charAt(j);
		}
		return reverseString;
	}
	
	/**
	 * this method the lower case characters into upper case and vice versa
	 * @param string takes input in string
	 * @return the change string which converts lower case characters into upper case and vice versa
	 * @throws ArithmeticException
	 */
	public String changeCaseOfString (String string) throws ArithmeticException
	{
		String changedString = "";
		for (int i = 0; i < stringLength(string); i++)
		{
			if (string.charAt(i) >= 97 && string.charAt(i) <= 122)
			{
				changedString += (char) (string.charAt(i) - 32);
			}
			else if (string.charAt(i) >= 65 && string.charAt(i) <= 90)
			{
				changedString += (char) (string.charAt(i) + 32);
			}
			else
			{
				changedString += (char) string.charAt(i);
			}
		}
		return changedString;
	}
	
/**
 * this method will fine longest word in a input string
 * @param string takes the string array in input
 * @return the longest word in whole string
 * @throws ArithmeticException
 */
	public String largestWordString (String[] string) throws ArithmeticException
	{
		String temp = "";
		String largestWord = ""; 
		
		for (String str : string)
		{
		    if (stringLength(str) >= stringLength(largestWord))
		    {
		    	largestWord = str;
		    }
		    else if (stringLength(largestWord) == stringLength(largestWord))
		    {
		    	for (int i = 0; i < str.length(); i++)
		    	{
		    	   if (str.charAt(i) > largestWord.charAt(i))
		    	   {
		    		   largestWord = str;
		    	   }
		    	}
		    }
		}
		return largestWord;
	}
}
