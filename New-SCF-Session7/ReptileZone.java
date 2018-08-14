package zooManagement;

/**
 * This class will add the Reptile zone into Zoo
 * @author Deekshika Sharma
 */
public class ReptileZone extends Zone{

	/**
	 * It initializes the ReptileZone properties into Zoo
	 * @param capacity
	 * @param hasPark
	 * @param hasCanteen
	 */
	public ReptileZone(int capacity, boolean hasPark,
			boolean hasCanteen) {
		super(AnimalFamily.REPTILE, capacity, hasPark, hasCanteen);
	}
}
