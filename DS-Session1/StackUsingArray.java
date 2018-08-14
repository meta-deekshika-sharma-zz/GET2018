package stack;

/**
 * @author Deekshika Sharma This class will implements the Stack interface and
 *         applying stack method by array
 */
public class StackUsingArray implements Stack {

	private int[] stack;
	private int top;

	/**
	 * The constructor is initializes when Stack is created
	 */
	public StackUsingArray() {
		stack = new int[STACK_CAPACITY];
		top = -1;
	}

	/**
	 * Perform push operation on stack
	 */
	@Override
	public boolean pushStack(int value) {
		if (value != (int) value || value < 0) // check value is valid or not
			throw new AssertionError("The given input value is not integer!!");
		if (!isStackFull()) {
			top++;
			stack[top] = value;
			return true;
		} else
			throw new AssertionError("Stack is full, cannot push!!");
	}

	/**
	 * Perform pop operation on stack
	 */
	@Override
	public int popStack() {

		int value = -1;
		if (!isStackEmpty()) {
			value = stack[top];
			top--;
			return value;
		} else
			throw new AssertionError("Stack is empty, cannot pop!!");
	}

	/**
	 * Check whether stack is empty or not
	 */
	@Override
	public boolean isStackEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	/**
	 * Check whether stack is full or not
	 */
	@Override
	public boolean isStackFull() {
		if (top == STACK_CAPACITY - 1)
			return true;
		else
			return false;
	}

	/**
	 * Return the peak value of stack
	 */
	@Override
	public int peakValue() {
		if (!isStackEmpty())
			return stack[top];
		else
			throw new AssertionError("Stack is empty!!");
	}
}
