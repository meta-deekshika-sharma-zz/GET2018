<%@page import="com.metacube.training.service.JobService"%>
<%@page import="com.metacube.training.model.Job"%>
<%@page import="com.metacube.training.service.EmployeeService"%>
<%@page import="com.metacube.training.service.ProjectService"%>
<%@page import="com.metacube.training.model.Project"%>
<%@page import="com.metacube.training.dao.EmployeeDAO"%>
<%@page import="com.metacube.training.service.PreSignUpService"%>
<%@page import="com.metacube.training.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addEmployee" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male"> Male</td>
  				<td><input type="radio" name="gender" value="female"> Female</td>
  				<td><input type="radio" name="gender" value="other"> Other</td>
			</tr>
			<tr>
				<td>Date Of Joining:</td>
				<td><input type="date" name="doj"></td>
			</tr>
			
			<tr>
				<td>Total Experience:</td>
				<td><input type="text" name="totalExp"></td>
			</tr>
			
			<tr>
				<td>Job Code:</td>
				<td>
				    <select name = "jobCode">
				    <option value = "null">Null</option>
				       <%
				          List<Job> jobs = new JobService().retreive();
				          for(Job job: jobs)
				          {%>
				        	 <option value=" <%=job.getCode() %>"> <%=job.getTitle() %> </option> 
				          <%}
				       %>
				    </select>
				</td>
			</tr>
			
			<tr>
				<td>Reporting Manager:</td>
				<td>
				    <select name = "reportingMgr">
				    <option value = "null">Null</option>
				       <%
				          List<Employee> employees = new EmployeeService().retreive();
				          for(Employee employee: employees)
				          {%>
				        	 <option value="<%=employee.getCode() %>"> <%=employee.getCode() %> </option> 
				          <%}
				       %>
				    </select>
				</td>
			</tr>
			
			<tr>
				<td>Team Lead:</td>
				<td>
				    <select name = "teamLead">
				       <option value = "null">Null</option>
				       <%
				          List<Employee> employeeList = new EmployeeService().retreive();
				          for(Employee employee: employeeList)
				          {%>
				        	 <option value="<%=employee.getCode() %>"> <%=employee.getCode() %> </option> 
				          <%}
				       %>
				    </select>
				</td>
			</tr>	
			
			<tr>
				<td>Project Id:</td>
				<td>
				    <select name = "projectId">
				    <option value = "null">Null</option>
				       <%
				          List<Project> projects = new ProjectService().retreive();
				          for(Project project: projects)
				          {%>
				        	 <option value="<%=project.getId() %>"> <%=project.getDescription() %> </option> 
				          <%}
				       %>
				    </select>
				</td>
			</tr>	
				
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
		</table>	
	</form>
</body>
</html>