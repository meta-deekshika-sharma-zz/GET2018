package queue;

/**
 * @author Deekshika Sharma This class will implements the Queue interface and
 *         applying queue method by linked list
 */
public class QueueUsingLinkedList implements Queue {

	private QueueNode rear, front;

	/**
	 * The constructor is initializes when Queue is created
	 */
	public QueueUsingLinkedList() {
		rear = null;
		front = null;
	}

	/**
	 * Perform queue enqueue operation
	 */
	@Override
	public boolean enQueue(int value) {

		if (value != (int) value || value < 0) // check for value validation
			throw new AssertionError("The given input value is not integer!!");
		QueueNode queueNode = new QueueNode(value);
		if (isQueueEmpty()) {
			rear = queueNode;
			rear.link = null;
			front = rear;
		} else {
			queueNode.link = rear;
			rear = queueNode;
		}
		return true;
	}

	/**
	 * Perform queue dequeue operation
	 */
	@Override
	public int deQueue() {
		int value = -1;
		if (!isQueueEmpty()) {
			value = front.value;
			QueueNode queueNode = front;
			front = queueNode.link;
			queueNode.link = null;
		} else
			throw new AssertionError("Queue is empty, cannot pop!!");
		return value;
	}

	/**
	 * Check whether queue is empty or not
	 */
	@Override
	public boolean isQueueEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	/**
	 * Check whether queue is full or not
	 */
	@Override
	public boolean isOueueFull() {
		return false;
	}

}
