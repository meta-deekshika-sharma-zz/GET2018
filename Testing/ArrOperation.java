package assignment4;


/** This class will contain the operations performed on the arrays
 *  @author Deekshika Sharma
 */
public class ArrOperation {

		int[] newArray;
		
		/**
		 * This method will calculate the maximum number of mirror values 
		 * @param inputArray take input array
		 * @return the maximum number of mirror values
		 */
		public int maxMirror (int []inputArray)
		{
			isArrayEmpty(inputArray);
			this.newArray = inputArray;
			int returnValue = 0;
			for (int i = 0; i < newArray.length; i++)
			{
				int k = i;
				int l;
				for (int j = newArray.length - 1; j > 0; j--)
				{
					l = j;
					int count = 0;
					while (newArray[k] == newArray[l])
					{
						count++;
						k++;
						l--;
						
						if (k > newArray.length - 1 || l < 0)
						{
							break;
						}
					}
					k = i;
	              
					if (count > returnValue)
					{
					   returnValue = count;
					}
				} 
			}
			return returnValue;
		}
		
		
		/**
		 * This method will calculate the number of clumps present 
		 * @param inputArray takes array as input
		 * @return the number of clumps present in input
		 */
		public int countClumps (int[] inputArray)
		{
			isArrayEmpty(inputArray);
			this.newArray = inputArray;
			boolean isAppearFirst = true;
			int count = 0;
			for (int i = 0; i < newArray.length - 1; i++)
			{
				if (isAppearFirst && newArray[i] == newArray[i+1])
				{
					count++;
					isAppearFirst = false;
				}
				else if (newArray[i] != newArray[i+1])
				{
					isAppearFirst = true;
				}
			}
			return count;
		}
		
		
		/**
		 * This method will adjust in the given array that fix value is always followed by followed value
		 * @param inputArray takes array as input
		 * @param fixValue 
		 * @param followedValue
		 * @return the new array which contains fix value is followed by followed value
		 */
		public int[] fixXYArray (int[] inputArray, int fixValue, int followedValue)
		{	
			isArrayEmpty(inputArray);
			
			fixXYAssertion(inputArray, fixValue, followedValue);
			
			this.newArray = inputArray;
			int k = 0;
			for (int i = 0; i < newArray.length; i++)
			{
				if (newArray[i] == fixValue)
				{
					for (int j = k; j < newArray.length; j++)
					{
						if (newArray[j] == followedValue)
						{
							int temp;
							temp = newArray[j];
							newArray[j] = newArray[i+1];
							newArray[i+1] = temp;
							break;
						}
					}
					k = i + 2;
				}
			}
			return newArray;
		}
		
		/**
		 * This method is used to find assertion errors present in method
		 * @param inputArray
		 * @param fixValue
		 * @param followedValue
		 */
		public void fixXYAssertion(int[] inputArray, int fixValue,	int followedValue) {
			
			if (inputArray[inputArray.length - 1] == fixValue)
				throw new AssertionError("Last value is fix value");
			
			for (int i = 0; i < inputArray.length - 1; i++)
			{
				if (inputArray[i] == inputArray[i+1])
					throw new AssertionError("Two adjacent fix values are present");
			}
			
			if (occurrenceOfValue(fixValue, inputArray) != occurrenceOfValue(followedValue, inputArray))
				throw new AssertionError("Unequal no. of" + fixValue + " & " + followedValue + "present..");
		}


		/**
		 * This method is used to calculate occurrence of a particular value
		 * @param value takes value as input
		 * @param inputArray takes array in which occurrence of value is find
		 * @return the occurrence of value
		 */
		public int occurrenceOfValue (int value, int [] inputArray)
		{
			int occurance = 0;
			for (int i = 0; i < inputArray.length; i++)
			{
				if (inputArray[i] == value)
					occurance++;
			}
			return occurance;
		}
		/**
		 * This method splits the array such that left part sum is equal to right part sum
		 * @param numValue takes input no. of values in array 
		 * @param inputArray take array input
		 * @return the index of array from where the array is splits
		 */ 
		public int indexSplitArray (int [] inputArray) 
		{
			isArrayEmpty(inputArray);
			this.newArray = inputArray;
			for (int k = 1; k < newArray.length; k++)
			{
				if (calculateSum(0, k) == calculateSum(k, newArray.length))
				{
					 return k;
				}
			}
			return -1;
		}
		
		/**
		 * This method will calculate the sum of array elements based on lower limit and upper limit
		 * @param lowerLimit takes lower limit of array
		 * @param upperLimit takes upper limit of array
		 * @return the sum of array elements
		 * @throws ArithmeticException
		 */
	    public int calculateSum (int lowerLimit, int upperLimit)
	    {
	    	int sum = 0;
	    	for (int i = lowerLimit; i < upperLimit; i++)
	    	{
	    		sum += newArray[i];
	    	}
	    	return sum;
	    }
	    
	    public void isArrayEmpty (int [] inputArray)
	    {
	    	if (inputArray.length == 0)
	    		throw new AssertionError("Empty array");
	    }
}
