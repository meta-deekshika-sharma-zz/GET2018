package poly;

/**
 * The class Poly contains a polynomial equation and perform operation on it.
 * @author Deekshika Sharma
 */
public final class Poly {

	private int[][] coefficientAndExponent;
	
	/**
	 * Initialize the array into constructor
	 * The array is simply in 2D format where its column range is fix to takes only two parameters in argument
	 * It takes coefficient at 0 index and exponent at 1 index
	 * @param coefficientAndExponent is the array which initialize at the time of object creation
	 */
	public Poly (int[][] coefficientAndExponent)
	{
		this.coefficientAndExponent = coefficientAndExponent;
	}
	
	/**
	 * This method will evaluate the the polynomial by putting float value in variable
	 * @param value takes float value as an input
	 * @return the evaluated result
	 */
	public float evaluate (float value)
	{
		float evaluatedValue = 0.0f;
		for (int i = 0; i < coefficientAndExponent.length; i++)
		{
			evaluatedValue += coefficientAndExponent[i][0] * evaluateMul (coefficientAndExponent[i][1], value);
		}
		return evaluatedValue;
	}
	
	/**
	 * This method is supporter of evaluate (float value) which return the internal result
	 * This method simply calculate the value multiplication till the exponent gets 0
	 * @param exponent take the degree of particular term
	 * @param value takes value as input
	 * @return the evaluated result
	 */
	private float evaluateMul (int exponent, float value)
	{
		float mul = 1.0f;
		for (int i = 0; i < exponent; i++)
		{
			mul *= value;
		}
		return mul;
	}
	
	
	/**
	 * It will return the maximum exponent value i.e. degree of polynomial
	 * @return the degree of polynomial
	 */
	public int degree ()
	{
		int hightestDegree = coefficientAndExponent[0][1];
		for (int i = 0; i < coefficientAndExponent.length; i++)
		{
			if (coefficientAndExponent[i][1] > hightestDegree)
				hightestDegree = coefficientAndExponent[i][1];
		}
		return hightestDegree;
	}
	
	/**
	 * This method calculate the addition of two polynomials
	 * @param p1
	 * @param p2
	 * @return the addition of two polynomials
	 */
	public Poly addPoly (Poly p1, Poly p2)
	{
		if (p1.coefficientAndExponent.length == 0 || p2.coefficientAndExponent.length == 0)
		{
			throw new AssertionError();
		}
		Poly addPolyResult = new Poly(new int[p1.coefficientAndExponent.length + p2.coefficientAndExponent.length][2]);
		int addIndex = 0;
		for (int i = 0, j = 0; i < p1.coefficientAndExponent.length || j < p2.coefficientAndExponent.length;)
		{
			if (p1.coefficientAndExponent[i][1] > p2.coefficientAndExponent[j][1])
			{	
				addPolyResult.coefficientAndExponent[i][0] = p1.coefficientAndExponent[i][0];
				addPolyResult.coefficientAndExponent[addIndex][1] = p1.coefficientAndExponent[i][1];
				i++;
			}
			else if (p1.coefficientAndExponent[i][1] < p2.coefficientAndExponent[j][1])
			{
				addPolyResult.coefficientAndExponent[addIndex][0] = p2.coefficientAndExponent[j][0];
				addPolyResult.coefficientAndExponent[addIndex][1] = p2.coefficientAndExponent[j][1];
				j++;
			}
			else
			{
			    addPolyResult.coefficientAndExponent[addIndex][0] = p1.coefficientAndExponent[i][0] + p2.coefficientAndExponent[i][0];
			    addPolyResult.coefficientAndExponent[addIndex][1] = p1.coefficientAndExponent[i][1];
				i++;
				j++;
			}
			addIndex++;
		}
		
		show(addPolyResult, addIndex);
		return addPolyResult;
	}
	
	/**
	 * This method calculate the multiplication of two polynomials
	 * @param p1
	 * @param p2
	 * @return the multiplication of two polynomials
	 */
	public Poly multiplyPoly (Poly p1, Poly p2)
	{
		if (p1.coefficientAndExponent.length == 0 || p2.coefficientAndExponent.length == 0)
		{
			throw new AssertionError();
		}
		Poly mulPolyResult = new Poly(new int[p1.coefficientAndExponent.length * p2.coefficientAndExponent.length][2]);
		
		int mulIndex = 0;
		for (int i = 0; i < p1.coefficientAndExponent.length; i++)
		{
			for (int j = 0; j < p2.coefficientAndExponent.length; j++)
			{
				mulPolyResult.coefficientAndExponent[mulIndex][0] = p1.coefficientAndExponent[i][0] * p2.coefficientAndExponent[j][0];
				if (p1.coefficientAndExponent[i][1] == 0 && p2.coefficientAndExponent[j][1] == 0)
					mulPolyResult.coefficientAndExponent[mulIndex][1] = p1.coefficientAndExponent[i][1];
				else
					mulPolyResult.coefficientAndExponent[mulIndex][1] = p1.coefficientAndExponent[i][1] + p2.coefficientAndExponent[j][1];
				
				mulIndex++;
			} 
	    }
		
		sortPoly (mulPolyResult, mulIndex);
		return mulPolyResult;
	}
	
	
	/**
	 * This method converts the resultant multiplied array into sorted poly based on their exponent value
	 * @param p1
	 * @param p2
	 */
	private void sortPoly (Poly mulPolyResult, int mulIndex)
	{
		Poly myPolyResult = mulPolyResult;
		int temp;
		for (int i = 0; i < mulIndex - 1; i++)
		{
			for (int j = i + 1; j < mulIndex; j++)
			{
				if (myPolyResult.coefficientAndExponent[i][1] == myPolyResult.coefficientAndExponent[j][1] && j != i + 1) // checks for the exponent are same and arrange it into adjacent order
				{
					temp = myPolyResult.coefficientAndExponent[i + 1][0];
					myPolyResult.coefficientAndExponent[i + 1][0] = myPolyResult.coefficientAndExponent[j][0];
					mulPolyResult.coefficientAndExponent[j][0] = temp;
					
					temp = myPolyResult.coefficientAndExponent[i + 1][1];
					myPolyResult.coefficientAndExponent[i + 1][1] = myPolyResult.coefficientAndExponent[j][1];
					myPolyResult.coefficientAndExponent[j][1] = temp;
				}
			}
		}
		
		addMulPoly (myPolyResult, mulIndex);
		
	}
	
	
	/**
	 * This method will merge the same exponent terms
	 * @param mulPolyResult takes resultant sorted mulPoly
	 * @param mulIndex is the length of sorted array
	 */
	private void addMulPoly (Poly mulPolyResult, int mulIndex)
	{
		Poly newMulPolyResult = new Poly(new int[mulIndex][2]);
		int newMulIndex = 0;
        int count;
		
		for (int i = 0; i < mulIndex; i++)
		{
			newMulPolyResult.coefficientAndExponent[newMulIndex][0] = mulPolyResult.coefficientAndExponent[i][0];
			
			count = 0;
			for (int j = i + 1; j < mulIndex; j++)
			{
				if (mulPolyResult.coefficientAndExponent[i][1] == mulPolyResult.coefficientAndExponent[j][1])
				{
					count++;
					newMulPolyResult.coefficientAndExponent[newMulIndex][0] += mulPolyResult.coefficientAndExponent[j][0];
				}
				else
				{
					if (count > 0)
					{
						i += count;
					}
					break;
				}
			}
			
			newMulPolyResult.coefficientAndExponent[newMulIndex][1] = mulPolyResult.coefficientAndExponent[i][1];
			newMulIndex++;
		}
		
		newMulPolyResult.coefficientAndExponent[newMulIndex][0] = mulPolyResult.coefficientAndExponent[mulIndex - 1][0];
		newMulPolyResult.coefficientAndExponent[newMulIndex][1] = mulPolyResult.coefficientAndExponent[mulIndex - 1][1];
		show (newMulPolyResult, newMulIndex);
		
	}
	
	/**
	 * This method show the result of polynomial operations
	 * @param result
	 * @param index
	 */
	public void show (Poly result, int index)
	{
		for (int i = 0; i < index; i++)
		{
			System.out.print(result.coefficientAndExponent[i][0] + " " + result.coefficientAndExponent[i][1]);
			System.out.println();
		}
	}
}
