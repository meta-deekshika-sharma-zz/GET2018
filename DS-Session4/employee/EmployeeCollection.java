package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Deekshika Sharma 
 * This class is used for adding employee to the list
 */
public class EmployeeCollection {

	public List<Employee> listOfEmployee = new ArrayList<Employee>();

	// If employee id does not exists before then add it otherwise discard it 
	public boolean addEmployee(int id, String name, String address) {
		
		if(id <= 0 || name.length() == 0 || address.length() == 0)
			throw new AssertionError("Data is invalid");
		else if(!name.chars().allMatch(Character::isLetter))
			throw new AssertionError("Name does not have only letters");
		
		for (Employee e : listOfEmployee) {
			if (e.getEmpId() == id)
				throw new AssertionError("This employee id is already exists");
		}
		listOfEmployee.add(new Employee(id, name, address));
		return true;
	}
	
	// this method will sort the employee collection based on natural order
	public boolean sortNaturalOrder()
	{
		if(listOfEmployee.size() >= 5)
		{
			Collections.sort(listOfEmployee);
			return true;
		}
		return false;
	}
	
	// this method will sort the employee collection based on name in ascending order
	public boolean sortByName()
	{
		if(listOfEmployee.size() >= 5)
		{
			Collections.sort(listOfEmployee, new SortedByName());
			
			return true;
		}
		throw new AssertionError("Please add at least 5 employee data");
	}

}
