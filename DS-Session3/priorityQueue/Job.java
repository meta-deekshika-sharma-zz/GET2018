package priorityQueue;

/**
 * @author Deekshika Sharma This class will represent the Job class It have its
 *         value and its priority
 */
public class Job {

	final int value;
	final int priority;

	/**
	 * The constructor is initialized when a new job is created
	 * 
	 * @param value
	 * @param priority
	 */
	public Job(int value, int priority) {

		this.value = value;
		this.priority = priority;
	}

	public int getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}

}
