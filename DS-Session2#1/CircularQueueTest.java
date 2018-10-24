package circularQueue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma This class contains the test cases for circular
 *         queue
 */
public class CircularQueueTest {

	CircularQueue queue;

	/**
	 * This test case is related to circular queue which gives positive results
	 */
	@Test
	public void circularQueueTest() {

		queue = new CircularQueue(5);
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertEquals(2, queue.deQueue());
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(2));
		assertEquals(3, queue.deQueue());
		assertEquals(7, queue.deQueue());
		assertEquals(3, queue.deQueue());
		assertEquals(6, queue.deQueue());
		assertTrue(queue.enQueue(5));
		assertTrue(queue.enQueue(7));
		assertEquals(2, queue.deQueue());
		assertEquals(5, queue.deQueue());
		assertEquals(7, queue.deQueue());
		assertFalse(queue.isOueueFull());
		assertTrue(queue.isQueueEmpty());
	}

	/**
	 * This test case is related to circular queue which gives negative results
	 */
	@Test(expected = AssertionError.class)
	public void circularQueueErrorTest() {

		queue = new CircularQueue(5);
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertEquals(2, queue.deQueue());
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(3));
		assertEquals(3, queue.deQueue());
		assertEquals(7, queue.deQueue());
		assertEquals(3, queue.deQueue());
		assertEquals(6, queue.deQueue()); // give error while dequeue and queue
											// is empty
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(3)); // give error when capacity exceeds
	}
}
