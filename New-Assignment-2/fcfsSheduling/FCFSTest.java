package fcfsSheduling;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class will have possible test cases on first come first serve sheduling algorithm
 * @author User15
 *
 */
public class FCFSTest {

	FCFSSheduling fcfs = new FCFSSheduling();
	@Test
	public void test() {
		int[][] inputArray = new int[][] {{0,4}, {2,3}, {5,8}, {3,4}};
		assertEquals(7, fcfs.completionTime(1, inputArray, 4));
		assertEquals(14, fcfs.turnAroundTime(3, inputArray, 4));
		assertEquals(0, fcfs.waitingTime(0, inputArray, 4));
		assertEquals(3.0, fcfs.averageWaitingTime(inputArray, 4), 0.0);
		assertEquals(6, fcfs.maxWaitingTime(inputArray, 4));
		
		int[][] inputArray1 = new int[][] {{0,0},{0,0},{0,0},{0,0}};
		assertEquals(0, fcfs.completionTime(3, inputArray1, 4));
	}

}
