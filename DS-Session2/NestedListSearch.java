package nestedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Deekshika Sharma
 * This class will search for values by a specified string
 */
public class NestedListSearch {

	NestedListImplementation nestedList;
	Long value;
	
	// This constructor will get a nested list 
	public NestedListSearch(NestedListImplementation nestedList) 
	{
		this.nestedList = nestedList;
	}
	
	// This method will extract a value from nested list
	public long getValue(String position)
	{
		getValue(nestedList.getNestedList(), position);
		
		return value;
	}
	
	// This is submethod for extracting value
	private void getValue(List<Object> nestedList, String position)
	{
		int lengthOfString = position.length();
		
		// if string length is greater then 1 then extract the list else extract value
		if(lengthOfString > 1)
		{
			if(position.charAt(0) == 'H' || position.charAt(0) == 'h')
			{
				if(nestedList.get(0) instanceof List) // if nested list instance is list then recall the method
					getValue((List)nestedList.get(0), position.substring(1));
				else
					throw new AssertionError("Wrong input");
			}
			else if(position.charAt(0) == 'T' || position.charAt(0) == 't') 
			{
				if(nestedList.get(1) instanceof List)
				{
					List<Object> newList = new LinkedList<>(nestedList);
					newList.remove(0);
					getValue(newList, position.substring(1));
				}
				else
					throw new AssertionError("Wrong input");
			}
			else
				throw new AssertionError("Wrong input");
		}
		else
		{
			if(position.charAt(0) == 'H' || position.charAt(0) == 'h')
			{
				if(nestedList.get(0) instanceof Long)
					value = (Long)nestedList.get(0);
				else
					throw new AssertionError("Wrong input");
			}
			else if(position.charAt(0) == 'T' || position.charAt(0) == 't')
			{
				if(nestedList.get(1) instanceof Long)
					value = (Long)nestedList.get(1);
				else
					throw new AssertionError("Wrong input");
			}
			else
				throw new AssertionError("Wrong input");
		}
		
	}
}
