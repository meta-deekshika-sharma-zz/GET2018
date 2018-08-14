package dictionaryImplementation;

import java.util.List;

/**
 * @author Deekshika Sharma
 * This interface is has several methods which have to be implemented in other classes
 */
public interface Dictionary {
	
	public BSTNode addKeyValuePair(String key, String value);
	
	public BSTNode deleteKeyValuePair(String key);
	
	public String getValueForKey(String key);
	
	public List<BSTNode> sortedList();
	
	public List<BSTNode> sortedListBetweenKeys(String key1, String key2);
}
