package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.DAO.JDBCQuery;


public class ShowEmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		List<EmployeeDAO> employeeList = JDBCQuery.showEmployeeData();
		PrintWriter out = response.getWriter();
		
		String cssFile = "<link rel = 'stylesheet' href = 'CSS/Employee.css' />";
		out.println("<!DOCTYPE html>" +
		          "<html>" + "<head>" + "<title>Employee List</title>" + 
		          cssFile + "</head>" +
		          "<body>" + "<h1 align = 'center'>Employee Data</h1>" + "<form>" + "<table id = 'updateTab'>" + "<tr>" +
		          "<th id = 'heading'> First Name </th>" +
		          "<th id = 'heading'> Last Name </th>" +
		          "<th id = 'heading'> Email </th>" +
		          "<th id = 'heading'> Age </th>" + "</tr>");
		
		for(EmployeeDAO employee: employeeList)
		{
			out.print("<tr>" + "<td id = 'row'>" + employee.getFirstName() + "</td>");
			out.print("<td id = 'row'>" + employee.getLastName() + "</td>");
			out.print("<td id = 'row'>" + employee.getEmail() + "</td>");
			out.print("<td id = 'row'>" + employee.getAge() + "</td>");
			out.print("<td id = 'row'>" + "<a href='EditEmployeeServlet?email=" + employee.getEmail() + "&firstName=" + employee.getFirstName() + "&lastName=" + employee.getLastName() + "&age=" + employee.getAge() + "'>Edit</a>" +"</td>" +  "</tr>");
		}
		
		out.println("</table>" + "</form>" +"</body>" + "</html>");
	}

}
