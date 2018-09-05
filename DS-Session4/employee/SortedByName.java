package employee;

import java.util.Comparator;

/**
 * @author Deekshika Sharma 
 * This class will sort the list based on employee name
 */
public class SortedByName implements Comparator<Employee> {

	// This override method will compare two employees name and sort them
	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}

}
