package stack;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma The StackTest class will have test cases related to
 *         stack data structure
 */
public class StackTest {

	Stack stack;

	/**
	 * This test case is related to Stack using array It gives positive results
	 */
	@Test
	public void StackUsingArrayTest() {
		stack = new StackUsingArray();
		assertTrue(stack.pushStack(5));
		assertTrue(stack.pushStack(2));
		assertEquals(2, stack.popStack());
		assertEquals(5, stack.peakValue());
		assertEquals(5, stack.popStack());
	}

	/**
	 * This test case is related to Stack using linked list
	 */
	@Test
	public void StackUsingLinkedListTest() {
		stack = new StackUsingLinkedList();
		assertTrue(stack.pushStack(5));
		assertTrue(stack.pushStack(2));
		assertEquals(2, stack.popStack());
		assertEquals(5, stack.peakValue());
	}

	/**
	 * This test case is negative test case for Stack using linked list
	 */
	@Test(expected = AssertionError.class)
	public void StackUsingLinkedListAssertionErrorTest() {
		stack = new StackUsingLinkedList();
		assertTrue(stack.isStackEmpty());
		assertTrue(stack.pushStack(3));
		assertTrue(stack.pushStack(8));
		assertEquals(3, stack.popStack());
		assertEquals(8, stack.popStack());
		assertEquals(2, stack.peakValue()); // give error when stack is empty
		assertEquals(3, stack.popStack()); // give error when stack is empty
	}

	/**
	 * This test case is negative test case for Stack using array
	 */
	@Test(expected = AssertionError.class)
	public void StackUsingArrayAssertionErrorTest() {
		stack = new StackUsingLinkedList();
		assertTrue(stack.isStackEmpty()); // give error if stack is empty
		assertTrue(stack.isStackFull()); // give error when stack is full
		assertTrue(stack.pushStack(3));
		assertTrue(stack.pushStack(6));
		assertTrue(stack.pushStack(3));
		assertTrue(stack.pushStack(2));
		assertTrue(stack.pushStack(1));
		assertTrue(stack.pushStack(6));
		assertTrue(stack.pushStack(3));
		assertTrue(stack.pushStack(8));
		assertTrue(stack.pushStack(6));
		assertTrue(stack.pushStack(6));
		assertTrue(stack.pushStack(3));
		assertTrue(stack.pushStack(8)); // give error when stack is full
	}
}
