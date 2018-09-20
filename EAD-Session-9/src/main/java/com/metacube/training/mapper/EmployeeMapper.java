package com.metacube.training.mapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

	Employee employee = new Employee();
	employee.setCode(resultSet.getString("emp_code"));
	employee.setFirstName(resultSet.getString("first_name"));
	employee.setMiddleName(resultSet.getString("middle_name"));
	employee.setLastName(resultSet.getString("last_name"));
	employee.setDob(resultSet.getDate("dob"));
	employee.setPrimaryContactNo(resultSet
			.getString("primary_contact_no"));
	employee.setSecondaryContactNo(resultSet
			.getString("secondary_contact_no"));
	employee.setEmailId(resultSet.getString("email_id"));
	employee.setSkypeId(resultSet.getString("skype_id"));
    employee.setPassword(resultSet.getString("password"));
//	Blob blob = resultSet.getBlob("profile_picture");
//	
//	if(blob == null)
//		employee.setProfilePicture(null);
//	else
//		employee.setProfilePicture(blob.getBinaryStream());
//	
	return employee;
	}
}
