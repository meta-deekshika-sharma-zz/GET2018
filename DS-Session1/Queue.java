package queue;

/**
 * @author Deekshika Sharma This interface will have methods applied on queue
 *         data structure
 */
public interface Queue {
	public static final int QUEUE_CAPACITY = 10; // define capacity of queue

	public boolean enQueue(int value);

	public int deQueue();

	public boolean isQueueEmpty();

	public boolean isOueueFull();
}
