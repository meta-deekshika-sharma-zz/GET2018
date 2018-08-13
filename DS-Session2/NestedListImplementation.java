package nestedList;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Deekshika Sharma
 * This class have methods for sum of list, max in list and search a value in list
 */
public class NestedListImplementation implements NestedList{

	List<Object> nestedList = new LinkedList<>();
	long sum = 0, max = Long.MIN_VALUE;
	
	public NestedListImplementation(String fileLocation) {
        JSONParser parser = new JSONParser();
        try 
        {
            Object object = parser.parse(new FileReader(fileLocation)); // read a file location
            JSONObject jsonObject = (JSONObject) object;
            
            nestedList = createNestedList(jsonObject);
            
            for(Object obj: nestedList)
            	System.out.println(obj.toString());
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
	}
	
	
	public List<Object> getNestedList() {
		return nestedList;
	}

// return sum of elements of list
	@Override
	public long sumOfList() {
		
		return sum;
	}

	// return max from list
	@Override
	public long largestValue() {
		
		return max;
	}

	// it will search a value and return true if find else false
	@Override
	public boolean searchValue(long value) {
		
		return search(value, nestedList);
	}
	
	// This method create nested list form json object 
	private List<Object> createNestedList(JSONObject jsonObject)
	{
		LinkedList<Object> nestedList = new LinkedList<>();
		for(Object key: jsonObject.keySet())
		{
			if(jsonObject.get(key) instanceof Long) // if key is instance of Long then sum its value and check for max
			{
				long value = (Long)jsonObject.get(key);
				nestedList.addFirst(value);
				sum += value;
				if(value > max)
					max = value;
				
			}
			else // create a nested list for a new list
			{
				JSONObject newJson = (JSONObject)jsonObject.get(key);
				List<Object> list = createNestedList(newJson);
				nestedList.add(list);
			}
		}
		
		return nestedList;
	}

	
	// This method will search for a value in list
	private boolean search(long value, List<Object> list)
	{
		boolean found = false;
		
		for(Object nestedListValue: list)
		{
			if(nestedListValue instanceof Long)
			{
				if(value == (Long)nestedListValue)
				{
					found = true;
					break;
				}
			}
			else 
			{
				found = search(value, (List)nestedListValue);
			}
			
			if(found)
				break;
		}
		return found;
	}
}
