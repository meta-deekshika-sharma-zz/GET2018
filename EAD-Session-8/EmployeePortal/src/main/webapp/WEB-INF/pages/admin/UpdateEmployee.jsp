<%@page import="com.metacube.training.model.Project"%>
<%@page import="com.metacube.training.service.ProjectService"%>
<%@page import="com.metacube.training.service.EmployeeService"%>
<%@page import="com.metacube.training.model.Employee"%>
<%@page import="com.metacube.training.model.Job"%>
<%@page import="com.metacube.training.service.JobService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateEmployee" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname" value="${search.firstName}"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="mname" value="${search.middleName}"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname" value="${search.lastName}"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${search.emailId}"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob" value="${search.dob}"></td>
			</tr>
			<!-- <tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male"> Male</td>
  				<td><input type="radio" name="gender" value="female"> Female</td>
  				<td><input type="radio" name="gender" value="other"> Other</td>
			</tr> -->
			
			<tr>
			    <td>Skype Id:</td>
				<td><input type="text" name="skype" value="${search.skypeId}"></td>
			</tr>
			
			<tr>
			<td>Primary Contact No:</td>
				<td><input type="text" name="primaryContactNo" value="${search.primaryContactNo}"></td>
		    </tr>
		    
		    <tr>
			<td>Secondary Contact No:</td>
				<td><input type="text" name="secondaryContactNo" value="${search.secondaryContactNo}"></td>
		    </tr>
		    
		    <tr>
		        <td><input type = "submit" value = "Update"></td>
		    </tr>
			</table>	
	</form>
</body>
</html>