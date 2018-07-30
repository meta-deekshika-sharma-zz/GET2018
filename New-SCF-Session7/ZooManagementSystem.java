package zooManagement;

import java.util.Scanner;

/**
 * This is the main method from where zoo management is begin
 * @author Deekshika Sharma
 */
public class ZooManagementSystem {

	
	public static void main(String[] args) {

		Zoo zoo = new Zoo(); // create object of zoo class
		
		// a while loop which is true for each situation
		while(true)
		{
			System.out.println("MENU!!!!");
			System.out.println("1. Add Zone to the Zoo");
			System.out.println("2. Add Cage to the Zone");
			System.out.println("3. Add Animal to cage");
			System.out.println("4. Remove animal from cage");
			
			System.out.println("Enter your choice..");
			Scanner sc = new Scanner(System.in);
			
			int ch = sc.nextInt();
			try {
			if (ch < 0)
			{
				throw new NumberFormatException();
			} }catch (NumberFormatException e)
			{
				System.out.println("Number format exception occure");
			}
			
			switch (ch) // this switch case will show various operations of zoo class
			{
			case 1: AnimalFamily zoneType = chooseZone(sc);
					System.out.println("Please enter the capacity");
					int capacity = sc.nextInt();
					System.out.println("Does the zone has a park? (Enter true or false)");
					boolean hasPark = sc.nextBoolean();
					System.out.println("Does the zone has a canteen? (Enter true or false)");
					boolean hasCanteen = sc.nextBoolean();
			
					zoo.addZone(zoneType, capacity, hasPark, hasCanteen);
					break;
			
			case 2: AnimalName cageType = chooseCage(sc);
					System.out.println("Enter the capacity of the cage");
					int capacityOfCage = sc.nextInt();
		
					if(zoo.addCage(cageType, capacityOfCage))
					{
						System.out.println("Cage is successfully added");
					}
					break;
		    
			case 3: AnimalName animalType = chooseCage(sc);
			        Animal animal = addNewAnimal(sc, animalType);
					if(zoo.addAnimal(animal))
						System.out.println("Animal added successfully");
					break;
			
			case 4: AnimalName animalType1 = chooseCage(sc);
					if(zoo.removeAnimal(animalType1))
						System.out.println("Remove successfully");
					break;
			}
		}
	}

	/**
	 * This will create a animal object to add animal
	 * @param sc
	 * @param animalType
	 * @return animal object
	 */
	private static Animal addNewAnimal(Scanner sc, AnimalName animalType) {
		
		Animal animal = null;
		double weight;
		int age;
		double wingSpan;
		switch(animalType)
		{
		case CROCODILE: System.out.println("Enter the weight and age of crocodile");
		     weight = sc.nextDouble();
		     age = sc.nextInt();
		     animal = new Crocodile(weight, age);
			 break;
			
		case ELEPHANT: System.out.println("Enter the weight and age of elephant");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         animal = new Elephant(weight, age);
			 break;
			
		case LION: System.out.println("Enter the weight and age of Lion");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         animal = new Lion(weight, age);
			 break;
			
		case PARROT: System.out.println("Enter the weight, age and wing span of Parrot");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         wingSpan = sc.nextDouble();
	         animal = new Parrot(weight, age, wingSpan);
			 break;
			
		case PEACOCK:System.out.println("Enter the weight, age and wing span of Peacock");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         wingSpan = sc.nextDouble();
	         animal = new Peacock(weight, age, wingSpan);
			 break;
			
		case SNAKE: System.out.println("Enter the weight and age of snake");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         animal = new Snake(weight, age);
		   	 break;
			
		}
		return animal;
	}

	/**
	 * Used to find animal name
	 * @param sc takes scanner as input
	 * @return  the animal name form AnimalName
	 */
	private static AnimalName chooseCage(Scanner sc) {
		AnimalName cageType = null;
		System.out.println("List of Cage Types");
	    System.out.println("1. Lion");
	    System.out.println("2. Elephant");
	    System.out.println("3. Parrot");
	    System.out.println("4. Peacock");
	    System.out.println("5. Snake");
	    System.out.println("6. Crocodile");
	    System.out.println("Choose from the cage types..");
	    
	    int cage = sc.nextInt();
	    
	    switch(cage)
	    {
	    case 1: 
	    	cageType = AnimalName.LION;
	    	break;
	    case 2: 
	    	cageType = AnimalName.ELEPHANT;
	    	break;
	    case 3: 
	    	cageType = AnimalName.PARROT;
	    	break;
	    case 4: 
	    	cageType = AnimalName.PEACOCK;
	    	break;
	    case 5: 
	    	cageType = AnimalName.SNAKE;
	    	break;
	    case 6: 
	    	cageType = AnimalName.CROCODILE;
	    	break;
	    default:
			System.out.println("No result found!!");
			break;	
	    }
		return cageType;
	}

	/**
	 * This is useful to select a particular zone
	 * @param sc
	 * @return the zone type from AnimalFamily
	 */
	private static AnimalFamily chooseZone(Scanner sc) {
		
		AnimalFamily zoneType = null;
		System.out.println("List of Zones");
	    System.out.println("1. Bird");
	    System.out.println("2. Mammal");
	    System.out.println("3. Reptile");
	    System.out.println("Choose from the zone types..");
	    
	    int zone = sc.nextInt();
	    
	    switch (zone) {
		case 1:
			zoneType = AnimalFamily.BIRD;
			break;
		case 2:
			zoneType = AnimalFamily.MAMMAL;
			break;
		case 3:
			zoneType = AnimalFamily.REPTILE;
			break;
		default:
			System.out.println("No result found!!");
			break;
		}
		return zoneType;
	}

}
