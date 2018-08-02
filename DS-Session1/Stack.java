package stack;

/**
 * @author Deekshika Sharma This interface will have methods applied on stack
 *         data structure
 */
public interface Stack {
	public final int STACK_CAPACITY = 10; // define capacity of stack

	public boolean pushStack(int value);

	public int popStack();

	public boolean isStackEmpty();

	public boolean isStackFull();

	public int peakValue();
}
