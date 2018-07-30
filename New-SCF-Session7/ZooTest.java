package zooManagement;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class will represent positive and negative test cases regarding zoo management
 * @author User15
 *
 */
public class ZooTest {

	Zoo zoo = new Zoo();
	/**
	 * This test case is true for each condition
	 */
	@Test
	public void zooTest1() {
		
		assertTrue(zoo.addZone(AnimalFamily.BIRD, 2, false, true)); // add zone to zoo
		assertTrue(zoo.addCage(AnimalName.PEACOCK, 2)); // add cage to zone
		assertTrue(zoo.addAnimal(new Peacock(5, 2, 33.8))); // add animal to cage
		assertTrue(zoo.removeAnimal(AnimalName.PEACOCK)); // remove animal from cage
	}
	
	/**
	 * This test case is true for each condition
	 */
	@Test
	public void zooTest2() {
		assertTrue(zoo.addZone(AnimalFamily.MAMMAL, 2, true, true)); // add zone to zoo
		assertTrue(zoo.addCage(AnimalName.LION, 2)); // add cage to zone
		assertTrue(zoo.addCage(AnimalName.ELEPHANT, 2)); // add cage to zoo
		assertTrue(zoo.addAnimal(new Lion(129, 35))); // add animal to cage
		assertTrue(zoo.removeAnimal(AnimalName.LION)); // remove animal from cage
	}

	/**
	 * This test case shows the assertion error
	 */
	@Test(expected = AssertionError.class)
	public void zooTest3() {
		assertTrue(zoo.addZone(AnimalFamily.MAMMAL, 2, false, true)); // add zone to cage
		assertTrue(zoo.addCage(AnimalName.LION, 2)); // add cage to zone
		assertTrue(zoo.removeAnimal(AnimalName.LION)); // remove animal from cage without adding, it gives assertion error
	}
}
