package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.DAO.JDBCQuery;


public class AddEmployeeServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		if((JDBCQuery.insertEmployeeData(new EmployeeDAO(firstName, lastName, email, age))) > 0)
		{
			out.println("inserted successfully");
		}
	}
}
