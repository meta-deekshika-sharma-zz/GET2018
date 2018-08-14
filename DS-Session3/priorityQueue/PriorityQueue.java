package priorityQueue;

/**
 * @author Deekshika Sharma This interface have the method for implementing
 *         priority queue
 */
public interface PriorityQueue {

	public boolean enqueue(Job value);

	public Job dequeue();

	public boolean isEmpty();

	public boolean isFull();
}
