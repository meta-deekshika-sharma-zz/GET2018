package setOperation;

import java.util.Arrays;

import poly.Poly;

/**
 * This is an immutable class which specifies some set operations
 * @author Deekshika Sharma
 */
public final class IntSet {

	private int set[]; // a set is initialized
    private int universalSet[]; // a universal set of 1000 element is initialized
	

    
	public IntSet (int[] set) // a parameterized constructor is initialized
	{
		universalSet = new int[1000];
		for (int i = 0; i < 1000; i++)
	    {
	    	universalSet[i] = i + 1;
	    }
		this.set = set;
	}
	

	/**
	 * This method will check whether a value is part of set
	 * @param x takes value as input
	 * @return true if value is found otherwise false
	 */
	public boolean isMember (int x)
	{
		if (x < 0)
			throw new AssertionError();
		for (int i = 0; i < this.set.length; i++)
		{
			if (set[i] == x)
				return true;
		}
		return false;
	}
	
	/**
	 * This method will return size of specified set
	 * @return
	 */
	public int size ()
	{
		return set.length;
	}
	
	/**
	 * This method will check whether the given input set is subset of universal set
	 * @param set takes IntSet as an input
	 * @return true if given set is subset of universal set otherwise false
	 */
	public boolean isSubSet (IntSet set)
	{
		if (set.set.length == 0)
			throw new AssertionError();
		for (int i = 0; i < set.size(); i++)
		{
			if (set.set[i] < 1 || set.set[i] > 1000)
				return false;
		}
		return true;
	}
	
	/**
	 * This method will calculate the complement of given set
	 * @return the complement IntSet
	 */
	public IntSet getComplement ()
	{
		if (this.set.length == 0)
			throw new AssertionError();
		IntSet complementedSet =  new IntSet(new int[1000]);
		boolean isAvailable = false;
		int complementIndex = 0;
		
		for (int i = 0; i < universalSet.length; i++)
		{
			for (int j = 0; j < this.set.length; j++)
			{
				if (universalSet[i] == this.set[j]) // check value is find in the universal set
				{
					isAvailable = true;
					break;
				}
				else
				{
					isAvailable = false;
				}
			}
			if (!isAvailable) // if value is not find in universal set then add it into complemented set
			{
			   complementedSet.set[complementIndex] = universalSet[i];
			   complementIndex++;
			}
		}
		show (complementedSet, complementIndex);
		return complementedSet;
	}
	
	
	/**
	 * This method will union the given two input set
	 * @param set1 
	 * @param set2
	 * @return the union of two set of type IntSet
	 */
	public IntSet unionOfSet (IntSet set1, IntSet set2)
	{
		IntSet unionSet = new IntSet(new int[set1.set.length + set2.set.length]);
		Arrays.sort(set1.set); // sort the set if not
		Arrays.sort(set2.set); // sort the set if not
		
		int union;
		for (union = 0; union < set1.set.length + set2.set.length;)
		{
			for (int set1Index = 0; set1Index < set1.set.length; set1Index++) // add the element of first set
			{
				unionSet.set[union] = set1.set[set1Index];
				union++;
			}
			
			for (int set2Index = 0; set2Index < set2.set.length; set2Index++) // add the element of second set
			{
				unionSet.set[union] = set2.set[set2Index];
				union++;
			}
		}
		
		removeDuplicates(unionSet, union);
		return unionSet;
	}
	
	
	/**
	 * This method will remove the duplicates parametes in set
	 * @param unionSet takes union of sets
	 * @param union index of union set
	 */
	private void removeDuplicates (IntSet unionSet, int union)
	{
		IntSet newUnionSet = new IntSet(new int[union]);
		Arrays.sort(unionSet.set);
		boolean isFound;
		int newUnionIndex = 0;
		newUnionSet.set[newUnionIndex] = unionSet.set[0];
		
		for (int i = 1; i < union; i++)
		{
			isFound = false;
			
			if (newUnionSet.set[0] == unionSet.set[i])
			{
				isFound = true;
			}
			for (int j = 1; j <= newUnionIndex; j++)
			{
				if (unionSet.set[i] == newUnionSet.set[j])
				{
					isFound = true;
					break;
				}
			}
			if (!isFound)
			{
			   newUnionIndex++;
			   newUnionSet.set[newUnionIndex] = unionSet.set[i];
			}
		}
		show (newUnionSet, newUnionIndex + 1);
	}
	/**
	 * This method show the result of IntSet operations
	 * @param result
	 * @param index
	 */
	public void show (IntSet result, int index)
	{
		for (int i = 0; i < index; i++)
		{
			System.out.println(result.set[i]);
		}
	}
}
