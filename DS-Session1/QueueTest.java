package queue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma The QueueTest class will have test cases related to
 *         queue data structure
 */
public class QueueTest {

	Queue queue;

	/**
	 * This test case is related to Queue using array It gives positive results
	 */
	@Test
	public void QueueUsingArrayTest() {

		queue = new QueueUsingArray();
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertEquals(2, queue.deQueue());
	}

	/**
	 * This test case is related to Queue using linked list
	 */
	@Test
	public void QueueUsingLinkedListTest() {

		queue = new QueueUsingLinkedList();
		assertTrue(queue.isQueueEmpty());
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(8));
		assertEquals(3, queue.deQueue());
	}

	/**
	 * This test case is negative test case for Queue using linked list
	 */
	@Test(expected = AssertionError.class)
	public void QueueUsingLinkedListAssertionErrorTest() {

		queue = new QueueUsingLinkedList();
		assertTrue(queue.isQueueEmpty());
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(8));
		assertEquals(3, queue.deQueue());
		assertEquals(8, queue.deQueue());
		assertEquals(3, queue.deQueue()); // give error when queue is empty
	}

	/**
	 * This test case is negative test case for Queue using array
	 */
	@Test(expected = AssertionError.class)
	public void QueueUsingArrayAssertionErrorTest() {
		queue = new QueueUsingArray();

		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(8)); // give error when queue is full
	}
}
