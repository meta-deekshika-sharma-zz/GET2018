package zooManagement;

/**
 * This class inherites the Zone class and used to add Bird Zone in the Zoo
 * @author Deekshika Sharma
 */
public class BirdZone extends Zone{

	/**
	 * The Bird zone constructor add the bird zone into zoo
	 * @param capacity
	 * @param hasPark
	 * @param hasCanteen
	 */
	public BirdZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.BIRD, capacity, hasPark, hasCanteen);
	}
	
}
