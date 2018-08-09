package dictionaryImplementation;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Deekshika Sharma
 * This class is create a dictionary based on key value pair 
 */
public class DictionaryImplementation implements Dictionary{

	private BSTNode root;
	private List<BSTNode> sortedList;
	
	public DictionaryImplementation(String initialEntry) {
		
		JSONParser parser = new JSONParser();
		 root = null;

        try {

            Object obj = parser.parse(new FileReader(initialEntry));

            JSONObject jsonObject = (JSONObject) obj;
            
            for(Object obj1: jsonObject.keySet())
            {
            	System.out.println(obj1.toString());
            }
                
            
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	
	// This method adds the key value pair to dictionary
	public BSTNode add(BSTNode node, String key, String value)
	{
		if (node == null)
            node = new BSTNode(key, value);
        else
        {
            if (key.compareTo(node.getKey()) == 0)
                throw new AssertionError("Duplicate entry");
            else if (key.compareToIgnoreCase(node.getKey()) < 0)
            	node.setLeftChild(add(node.getLeftChild(), key, value));
            else
                node.setRightChild(add(node.getRightChild(), key, value));
        }
        return node;
	}
	
	// This method delete the key value pair from dictionary
	public BSTNode delete(BSTNode node, String key)
	{
        BSTNode node1, node2, n;
        
        if (node.getKey().equals(key))
        {
            BSTNode left, right;
            left = node.getLeftChild();
            right = node.getRightChild();

            if (left == null && right == null)
                return null;
            else if (left == null)
            {
                node1 = right;
                return node1;
            }
            else if (right == null)
            {
                node1 = left;
                return node1;
            }
            else
            {
                node1 = right;
                node2 = right;
                
                while (node2.getLeftChild() != null)
                    node2 = node2.getLeftChild();

               node2.setLeftChild(left);
               return node1;
            }
        }

        if (key.compareTo(node.getKey()) < 0)
        {
            n = delete(node.getLeftChild(), key);
            node.setLeftChild(n);
        }
        else
        {
            n = delete(node.getRightChild(), key);
            node.setRightChild(n);             
        }
        
        return node;
	}
	
	// This method is override to add key value pair
	@Override
	public BSTNode addKeyValuePair(String key, String value) {
		root = add(root, key, value);
		if(root != null)
		{
			return root;
		}
		else
			return null;
	}

	// This method is override to delete key value pair
	@Override
	public BSTNode deleteKeyValuePair(String key) {
		
		root = delete(root, key);
		if(root != null)
		{
			return root;
		}
		else
			return null;
	}

	// This method is find the value for particular key
	public String getValue(BSTNode node, String key)
	{
		String value = "";
		while(node != null)
		{
			if(node.getKey().equals(key))
				value = node.getKey();
			else if(node.getKey().compareToIgnoreCase(key) < 0)
				value = getValue(node.getLeftChild(), key);
			else
				value = getValue(node.getRightChild(), key);
		}
		return value;
	}
	
	// This method will override to find value for particular key
	@Override
	public String getValueForKey(String key) {
		
		if(isEmpty())
			throw new AssertionError("Dictionary is empty");
		else if(key.length() == 0)
			throw new AssertionError();
		else
			return getValue(root, key);
	}

	// This method will return the list of nodes in sorted order 
	@Override
	public List<BSTNode> sortedList() {
			
		sortedList = new ArrayList<BSTNode>();
		inOrderTraversal(root);
		return sortedList;
	}
	
	// This method will traverse the tree in in order
	public void inOrderTraversal(BSTNode root)
	{
		if(root != null)
		{
			inOrderTraversal(root.getLeftChild());
			System.out.print(root.getKey() + " ");
			inOrderTraversal(root.getRightChild());
		}
	}

	// This method will return list of keys in between specified key
	@Override
	public List<BSTNode> sortedListBetweenKeys(String key1, String key2) {
	
        List<BSTNode> sortedSubList = new ArrayList<BSTNode>();
     
        Iterator<BSTNode> iterator = sortedList.iterator();    
        
        while(iterator.hasNext())
        {
            BSTNode entry = iterator.next();
            if(key1.compareTo(entry.getKey()) >= 0)
            {
            	System.out.println(entry.getKey());
                sortedSubList.add(entry);
                break;
            }
        }
        
        while(iterator.hasNext())
        {
            BSTNode entry = iterator.next();
            if(key2.compareTo(entry.getKey()) < 0)
                break;
            
            sortedSubList.add(entry);
        }
        inOrderTraversal(root);
        return sortedSubList;
	}

	// return true if tree is empty
	public boolean isEmpty()
    {
        return root == null;
    }
}
