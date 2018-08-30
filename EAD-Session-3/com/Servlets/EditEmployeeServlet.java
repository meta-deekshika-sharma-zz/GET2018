package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String oldEmail = request.getParameter("email");
	    String oldFirstName = request.getParameter("firstName");
	    String oldLastName = request.getParameter("lastName");
	    String oldAge = request.getParameter("age");
	    
	    String cssFile = "<link rel = 'stylesheet' href = 'CSS/Employee.css' />";
	    String jsFile = "<Script src = 'JavaScript/EmployeeValidation.js'></Script>";
	    
	    out.print("<!DOCType HTML>" + "<html>" + "<head>" + cssFile + " " + jsFile +"</head>" + "<body>");
	    out.print("<h1 align = 'center'>Update Details </h1>");
	    out.print("<form action='UpdateEmployeeServlet'> <table>");
	    out.print("<tr> <td id = 'label'> First Name </td> <td> <input type='text' id = 'firstName' name='firstName' value = '"+ oldFirstName +"' required></td></tr>");
	    out.print("<tr> <td id = 'label'> Last Name </td> <td> <input type='text' id = 'lastName' name='lastName' value = '"+ oldLastName +"' required></td></tr>");
	    out.print("<tr> <td id = 'label'> Email </td> <td> <input type='email' id = 'email' name='email' value = '"+ oldEmail +"' required></td></tr>");
	    out.print("<tr> <td id = 'label'> Age </td> <td> <input type='text' id = 'age' name='age' value = '"+ oldAge +"' required></td></tr>");
	    out.print("<input type='hidden' name='oldEmail' value='"+ oldEmail +"'>");
	    out.print("<tr> <td> </td> <td> <input type='submit' value='update' id = 'updateButton'> </td> </tr>");
	    out.print("</table> </form>");
	    out.print("</html>");
	}
}
