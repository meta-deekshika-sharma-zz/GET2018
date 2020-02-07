package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.JDBCQuery;
import com.Model.UserDAO;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		UserDAO user = JDBCQuery.getUser(email, password);
		
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		Date dob = user.getDob();
		String contactNumber = user.getContactNumber();
		String organization = user.getOrganization();
		
		System.out.println(request.getParameter("firstName"));
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>" + "<html>" +"<head>" + "<title>Edit Profile</title>" +
	    "<link rel = 'stylesheet' href = 'CSS/UserCSS.css' />" + "</head> <body>");
	    out.print("<h1 align = 'center'> User Profile </h1>" + "<table>");
		out.print("<div><table width = '75%'><tr><td><IMG SRC='Capture.PNG' WIDTH='30PX'></TD><TD ALIGN='RIGHT'>");
		out.print("<a href = '#'>Welcome</a>" + "  ");
		out.print("<label for = 'image'><input type = 'file' name = 'image' id = 'image' style = 'display:none;' />"
				+ "<img id = 'profileImage' src = " + user.getImagePath() +" width = '80px';"
				+ " alt = 'images/defaultProfileImage.png' accept = 'image/*' /></label>" + "  "
				+ "<a href = '#'>" + user.getFirstName() + " " + user.getLastName() + "</a>"
				+ "<A HREF='FriendServlet'>Friends</A>"
				+ "<A HREF='#'>Logout</A></TD></TR></TABLE><HR/></DIV>");
		
		out.print("<form action = 'UpdateServlet'><table>");
		
		out.print("<tr>" + "<td id = 'label'>First Name</td>" + "<td> <input type = 'text' name = 'firstName' required = 'required' id = 'firstName' value = '"+ firstName +"'> </td>" + "</tr>");
		out.print("<tr>" + "<td id = 'label'>Last Name</td>" + "<td> <input type = 'text' name = 'lastName' required = 'required' id = 'lastName' value = '"+ lastName +"'/></td> </tr>");
		out.print("<tr>" + "<td id = 'label'>Email</td>" + "<td> <input type = 'text' name = 'email' required = 'required' id = 'email' value = '"+ email +"'/></td> </tr>");
		out.print("<tr>" + "<td id = 'label'>DOB</td>" + "<td> <input type = 'date' name = 'dob' required = 'required' id = 'dob' value = '"+ dob +"'/></td> </tr>");
		out.print("<tr>" + "<td id = 'label'>Password</td>" + "<td> <input type = 'password' name = 'password' required = 'required' id = 'password' value = '"+ password +"'/></td> </tr>");
	    out.print("<tr>" + "<td id = 'label'>Contact Number</td>" + "<td> <input type = 'number' name = 'contactNumber' required = 'required' id = 'contactNumber' value = '"+ contactNumber +"'/></td> </tr>");
	    out.print("<tr>" + "<td id = 'label'>Organization</td>" + "<td> <select id = 'organization' name = 'organization' value = '"+ organization +"'>" +
									"<option value = 'Metacube'> Metacube Pvt. Ltd.</option>" +
									"<option value = 'Google'> Google </option>" +
									"<option value = 'Microsoft'> Microsoft </option>" +
									"<option value = 'Apple'> Apple </option>" +
									"<option value = 'Facebook'> Facebook </option>" +
								    "</select></td> </tr>");
	    out.print("<tr>" + "<td> <input type = 'submit' value = 'Update Profile' id = 'updateProfileButton'/> </td>" + "</tr>");
		out.print("</table>" + "</form>" + "</body>" + "</html>");
	}
}
