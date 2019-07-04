package recursion;

/**
 * This class will have LCM and HCF method using recursion
 * @author Deekshika Sharma
 */
public class MathsOperation {

	/**
	 * This method calculate LCM of two numbers
	 * @param x
	 * @param y
	 * @return LCM of two given numbers
	 */
	public int LCM (int x, int y)
	{		
		return (x * y)/HCF(x, y);
	}
	
	/**
	 * This method calculate HCF of two numbers using Euclid's Algorithm
	 * @param x
	 * @param y
	 * @return HCF of two given numbers
	 */
	public int HCF(int x, int y)
	{
		if(y != 0)
			return HCF(y, x % y);
		else
			return x;
	}
}
