package recursion;

/**
 * This class will have methods to implement the search operations
 * @author Deekshika Sharma
 */
public class Search {

	/**
	 * This method will calculate the value in array through linear search using recursion
	 * @param array
	 * @param leftIndex
	 * @param valueToSearch 
	 * @return the index where value is found
	 */
	public int linearSearch(int[] array, int leftIndex, int valueToSearch)
	{
		if(array.length == leftIndex)
			return -1;
		else if(array[leftIndex] == valueToSearch)
			return leftIndex;
		else
			return linearSearch(array, leftIndex + 1, valueToSearch);
	}
	
	/**
	 * This method will calculate the value in array through binary search using recursion
	 * Assume that array is in sorted order
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @param valueToSearch
	 * @return index where value is found
	 */
	public int binarySearch (int[] array, int leftIndex, int rightIndex, int valueToSearch)
	{
		if (leftIndex > rightIndex)
			return -1;
		
		int mid = (leftIndex + rightIndex)/2; // calculate the middle element
		
		if (array[mid] == valueToSearch)
		    return mid;
		else if (array[mid] > valueToSearch) // search in left half
			return binarySearch(array, 0, mid - 1, valueToSearch);
		else
			return binarySearch(array, mid + 1, rightIndex, valueToSearch);// search in right half
	}
}
