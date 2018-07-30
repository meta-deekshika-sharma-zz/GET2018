package zooManagement;

/**
 * Mammals is the subclass of Animal and it adds the Mammal type animal into Zoo
 * @author Deekshika Sharma
 */
public class Mammal extends Animal{
	
	private final boolean hasFurs;
	
	/**
	 * This intializes the Mammals properties and calls super to add it into animal
	 * @param name
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param hasFurs
	 * @param animalType
	 */
	public Mammal(String name, double weight, int age, String sound,
			int numberOfLegs, boolean hasFurs, AnimalName animalType) {
		
		super(name, weight, age, sound, numberOfLegs, AnimalFamily.MAMMAL, animalType);
		
		this.hasFurs = hasFurs;
	}

	public boolean isHasFurs() {
		return hasFurs;
	}
}
