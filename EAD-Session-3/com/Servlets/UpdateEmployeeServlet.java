package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.DAO.JDBCQuery;


public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String oldEmail = request.getParameter("oldEmail");
	    
	    EmployeeDAO employee = new EmployeeDAO(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"), Integer.parseInt(request.getParameter("age")));
	    if(JDBCQuery.updateEmployeeData(employee, oldEmail) > 0)
	        out.print("successfully updated");
	    else
	        out.print("error");
	    
	    request.getRequestDispatcher("ShowEmployeeServlet").include(request, response);
	}
	
}
