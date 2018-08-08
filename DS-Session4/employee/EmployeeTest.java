package employee;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Deekshika Sharma 
 * This class will have positive and negative test cases for employee collection
 */
public class EmployeeTest {

	EmployeeCollection employee = new EmployeeCollection();

	// This method have positive test cases
	@Test
	public void employeeTest() {
		assertTrue(employee.addEmployee(1, "deekshika", "alwar"));
		assertTrue(employee.addEmployee(4, "prakalpa", "bhiwadi"));
		assertTrue(employee.addEmployee(2, "rachna", "ajmer"));
		assertTrue(employee.addEmployee(7, "arjita", "mp"));
		assertTrue(employee.addEmployee(3, "bhavika", "jaipur"));
		assertTrue(employee.addEmployee(6, "gt", "12, jaipur"));

		assertTrue(employee.sortNaturalOrder());
		assertTrue(employee.sortByName());
	}

	@Test(expected = AssertionError.class)
	public void employeeErrorTest() {
		assertTrue(employee.addEmployee(1, "deekshika", "alwar"));
		assertTrue(employee.addEmployee(4, "prakalpa", "bhiwadi"));
		assertTrue(employee.addEmployee(2, "rachna", "ajmer"));
		assertTrue(employee.addEmployee(7, "arjita", "mp"));

		assertTrue(employee.sortNaturalOrder()); // give error when collection
													// of employees is less then
													// 5 employees
		assertTrue(employee.sortByName());

		assertTrue(employee.addEmployee(-1, "rachna", "ajmer")); // give error
																	// when id
																	// is
																	// negative
		assertTrue(employee.addEmployee(3, "", "")); // give error if name or
														// address is nil
		assertTrue(employee.addEmployee(2, "123Irr*&#", "ajmer")); // give error
																	// if name
																	// has
																	// numeric
																	// values or
																	// special
																	// characters
	}
}
