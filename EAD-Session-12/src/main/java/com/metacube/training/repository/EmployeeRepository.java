package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.model.Employee;

public interface EmployeeRepository<P> extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByFirstName(String firstName);

	Employee findByEmailId(String emailId);
	
}
