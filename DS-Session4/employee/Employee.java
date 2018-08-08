package employee;

/**
 * @author Deekshika Sharma 
 * This class will represent Employee structure and maintain natural order sorting
 */
public class Employee implements Comparable<Employee> {

	private int empId;
	private String name;
	private String address;

	// The constructor is created when new Employee is added
	public Employee(int id, String name, String address) {
		this.empId = id;
		this.name = name;
		this.address = address;
	}

	// Getters and setters are present for further implementation
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	// This override method will maintain the natural order sorting based on
	// empId
	@Override
	public int compareTo(Employee emp) {
		return (this.empId - emp.getEmpId());
	}
}
