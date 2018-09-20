package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.Employee;

public interface EmployeeRepository<P> extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByFirstName(String firstName);

	@Query("select emailId from Employee where "
			+ "empCode = :emp_code AND password = :password")
	String findByUsernameAndPassword(String emp_code, String password);
	
	@Query("from Employee where "
			+ "empCode = :emp_code AND password = :password")
	Employee findByUsername(String emp_code);
	
}
