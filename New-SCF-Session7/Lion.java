package zooManagement;

/**
 * Lion is the subclass of Mammal
 * @author Deekshika Sharma 
 * It initializes the properties of Lion when added to Zoo
 */
public class Lion extends Mammal{

private static int id = 1;
	
    /**
     * This intializes Lion and calls its super to add it into Mammal
     * @param weight
     * @param age
     */
	public Lion(double weight, int age) {
		super("Lion" + (id++), weight, age, "Roar", 4, false, AnimalName.LION);
		// TODO Auto-generated constructor stub
	}

}
