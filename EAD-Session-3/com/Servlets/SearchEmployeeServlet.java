package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.DAO.EmployeeDAO;
import com.DAO.JDBCQuery;

public class SearchEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name").replaceAll("\\s","");
		List<EmployeeDAO> employeeList = JDBCQuery.searchEmployeeData(name);
		PrintWriter out = response.getWriter();
		out.print(name);
		
		String cssFile = "<link rel = 'stylesheet' href = 'CSS/Employee.css' />";
		out.println("<!DOCTYPE html>" +
		          "<html>" + "<head>" + "<title>Employee List</title>" + cssFile +
				  "</head>" +
		          "<body>" + "<h1 align = 'center'>Employee Data</h1>" + "<table border = '1px'>" + "<tr>" +
		          "<th id = 'heading'> First Name </th>" +
		          "<th id = 'heading'> Last Name </th>" +
		          "<th id = 'heading'> Email </th>" +
		          "<th id = 'heading'> Age </th>" + "</tr>");
		
		for(EmployeeDAO employee: employeeList)
		{
			out.println("<tr>" + "<td id = 'row'>" + employee.getFirstName() + "</td>");
			out.println("<td id = 'row'>" + employee.getLastName() + "</td>");
			out.println("<td id = 'row'>" + employee.getEmail() + "</td>");
			out.println("<td id = 'row'>" + employee.getAge() + "</td>" + "</tr>");
		}
		
		out.println("</table>" + "</body>" + "</html>");
	}
}
