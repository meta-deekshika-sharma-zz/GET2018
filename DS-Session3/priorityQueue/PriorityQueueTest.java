package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma This class will have the test cases for priority
 *         queue It uses circular queue for space utilization
 */
public class PriorityQueueTest {

	PriorityQueue priorityQueue;

	@Test
	public void priorityQueueTest() {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2))); // to enqueue the
															// value
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue()); // to dequeue the
																// value
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 2)));
		assertTrue(priorityQueue.enqueue(new Job(4, 3)));
		assertTrue(priorityQueue.enqueue(new Job(6, 4)));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(7, 1))); // if two jobs have
															// same priority
															// then it will
															// follow the FIFO
															// order
		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

	}

	@Test(expected = AssertionError.class)
	public void priorityQueueErrorTest() {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(7, priorityQueue.dequeue().getValue()); // if queue is
																// empty it
																// gives error

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertTrue(priorityQueue.enqueue(new Job(7, 4)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3))); // if queue exceeds
															// its limit it give
															// error
	}

}
