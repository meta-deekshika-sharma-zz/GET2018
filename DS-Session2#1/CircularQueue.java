package circularQueue;

/**
 * @author Deekshika Sharma This class will perform operations on circular queue
 */
public class CircularQueue {

	private int rear, front;
	private int[] queue;
	private int queueCapacity;

	/**
	 * The constructor is initializes when circular queue is created
	 */
	public CircularQueue(int queueCapacity) {
		queue = new int[queueCapacity];
		this.queueCapacity = queueCapacity;
		rear = -1;
		front = -1;
	}

	/**
	 * Perform circular queue enqueue operation
	 */
	public boolean enQueue(int value) {

		if (isQueueEmpty()) {
			front++;
			rear++;
			queue[rear] = value;
			return true;
		} else if (!isOueueFull()) {
			rear++;
			if (rear == front) // if rear is reached for queue capacity and
								// queue is still non empty then it will now
								// reach at start
				throw new AssertionError("Queue is full, cannot enqueue!!");
			else
				rear = rear % queueCapacity;
			queue[rear] = value;
			return true;
		} else
			return false;
	}

	/**
	 * Perform circular queue dequeue operation
	 */
	public int deQueue() {
		int value = -1;
		if (front == rear && front != -1) {
			value = queue[front];
			front = -1;
			rear = -1;
		} else if (!isQueueEmpty()) {
			value = queue[front];
			front++;
			if (front % queueCapacity == 0) // if front is reached at queue
											// capacity and there are still
											// queue is non empty then it will
											// points to start
				front = front % queueCapacity;
		} else
			throw new AssertionError("Queue is empty, cannot dequeue!!");
		return value;
	}

	/**
	 * Check whether circular queue is empty or not
	 */
	public boolean isQueueEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

	/**
	 * Check whether circular queue is full or not
	 */
	public boolean isOueueFull() {
		if ((rear == queueCapacity - 1 && front == 0))
			return true;
		else
			return false;
	}
}
