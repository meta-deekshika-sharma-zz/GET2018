package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FriendDetailServlet")
public class FriendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FriendDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String contactNumber = request.getParameter("contactNumber");
		
		out.print("<!DOCTYPE html>" + "<html>" +"<head>" + "<title>Edit Profile</title>" +
	    "<link rel = 'stylesheet' href = 'CSS/UserCSS.css' />" + "</head> <body>");
		out.print("<h1 align ='center'>Friend Detail </h1>" + "<form>" + "<table id = 'openTab'>");
		out.print("<tr>" + "<td id = 'label'>First Name</td>" + "<td id = 'label'>" + firstName + "</td>" + "</tr>");
		out.print("<tr>" + "<td id = 'label'>Last Name</td>" + "<td id = 'label'>" + lastName + "</td>" + "</tr>");
		out.print("<tr>" + "<td id = 'label'>Email</td>" + "<td id = 'label'>" + email + "</td> </tr>");
	    out.print("<tr>" + "<td id = 'label'>DOB</td>" + "<td id = 'label'>" + dob + "</td></tr>");
		out.print("<tr>" + "<td id = 'label'>Contact Number</td>" + "<td id = 'label'>" + contactNumber + "</td></tr>");
		
		out.print("<tr> <td> <a href = 'FriendServlet' id = 'backButton'>Back</a></td></tr>");
        out.print("</table>" + "</form>" + "</body>" + "</html>");		
	}
}
