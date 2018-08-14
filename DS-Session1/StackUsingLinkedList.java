package stack;

/**
 * @author Deekshika Sharma This class will implements the Stack interface and
 *         applying stack method by linked list
 */
public class StackUsingLinkedList implements Stack {

	private StackNode top;

	/**
	 * The constructor is initializes when Stack is created
	 */
	public StackUsingLinkedList() {
		top = null;
	}

	/**
	 * Perform push operation on stack
	 */
	@Override
	public boolean pushStack(int value) {
		if (value != (int) value || value < 0) // check for value validation
			throw new AssertionError("The given input value is not integer!!");
		if (isStackEmpty()) {
			top = new StackNode(value);
			top.link = null;
		} else {
			StackNode pushNode = new StackNode(value);
			pushNode.link = top;
			top = pushNode;
		}
		return true;
	}

	/**
	 * Perform pop operation on stack
	 */
	@Override
	public int popStack() {

		int value = -1;
		if (!isStackEmpty()) {
			value = top.value;
			StackNode popNode = top;
			top = popNode.link;
			popNode.link = null;
		} else
			throw new AssertionError("Stack is empty, cannot pop!!");
		return value;
	}

	/**
	 * Check whether stack is empty or not
	 */
	@Override
	public boolean isStackEmpty() {

		if (top == null)
			return true;
		else
			return false;
	}

	/**
	 * Check whether stack is full or not
	 */
	@Override
	public boolean isStackFull() {
		return false;
	}

	/**
	 * Return the peak value of stack
	 */
	@Override
	public int peakValue() {
		if (!isStackEmpty())
			return top.value;
		else
			throw new AssertionError("Stack is empty!!");
	}
}
