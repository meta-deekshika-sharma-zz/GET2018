package queue;

/**
 * @author Deekshika Sharma This class will implements the Queue interface and
 *         applying queue method by array
 */
public class QueueUsingArray implements Queue {

	private int rear, front;
	private int[] queue;

	/**
	 * The constructor is initializes when Queue is created
	 */
	public QueueUsingArray() {
		queue = new int[QUEUE_CAPACITY];
		rear = -1;
		front = -1;
	}

	/**
	 * Perform queue enqueue operation
	 */
	@Override
	public boolean enQueue(int value) {
		if (value != (int) value || value < 0) // check for value validation
			throw new AssertionError("The given input value is not valid!!");

		if (isQueueEmpty()) {
			front++;
			rear++;
			queue[rear] = value;
			return true;
		} else if (!isOueueFull()) {
			rear++;
			queue[rear] = value;
			return true;
		} else
			throw new AssertionError("Queue is full, cannot enqueue!!");
	}

	/**
	 * Perform queue dequeue operation
	 */
	@Override
	public int deQueue() {
		int value = -1;
		if (front == rear && front != -1) {
			value = queue[front];
			front = -1;
			rear = -1;
		} else if (!isQueueEmpty()) {
			value = queue[front];
			front++;
		} else
			throw new AssertionError("Queue is empty, cannot dequeue!!");
		return value;
	}

	/**
	 * Check whether queue is empty or not
	 */
	@Override
	public boolean isQueueEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

	/**
	 * Check whether queue is full or not
	 */
	@Override
	public boolean isOueueFull() {
		if (rear == QUEUE_CAPACITY - 1)
			return true;
		else
			return false;
	}

}
