package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.JDBCQuery;
import com.Model.UserDAO;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		System.out.println(email + password);
		PrintWriter out = response.getWriter();
		
		UserDAO user = JDBCQuery.getUser(email, password);
		
		out.print("<!DOCTYPE html>" + "<html>" + "<head>"
				+ "<title>Edit Profile</title>"
				+ "<link rel = 'stylesheet' href = 'CSS/UserCSS.css' />"
				+ "</head> <body>");
		out.print("<h1 align = 'center'> User Profile </h1>" + "<table>");
		out.print("<div><table width = '75%'><tr><td><IMG SRC='Capture.PNG' WIDTH='30PX'></TD><TD ALIGN='RIGHT'>");
		out.print("<a href = '#'>Welcome</a>" + "  ");
		out.print("<label for = 'image'><input type = 'file' name = 'image' id = 'image' style = 'display:none;' />"
				+ "<img id = 'profileImage' src = " + user.getImagePath() + " width = '80px';"
				+ " alt = 'images/defaultProfileImage.png' accept = 'image/*' /></label>" + "  "
				+ "<a href = '#'>" + user.getFirstName() + " " + user.getLastName() + "</a>"
				+ "<A HREF='FriendServlet'>Friends</A>"
				+ "<A HREF='LogoutServlet'>Logout</A></TD></TR></TABLE><HR/></DIV>");

		out.print("<form action = 'UpdateProfileServlet'><table>");
		out.print("<tr>"
				+ "<td id = 'label'>First Name</td>"
				+ "<td> <input type = 'text' name='firstName' required = 'required' id = 'firstName' value = '"
				+ user.getFirstName() + "' disabled = 'disabled'> </td>"
				+ "</tr>");
		out.print("<tr>"
				+ "<td id = 'label'>Last Name</td>"
				+ "<td> <input type = 'text' name='lastName' required = 'required' id = 'lastName' value = '"
				+ user.getLastName() + "' disabled = 'disabled'/></td> </tr>");
		out.print("<tr>"
				+ "<td id = 'label'>Email</td>"
				+ "<td> <input type = 'text' name='email' required = 'required' id = 'email' value = '"
				+ email + "' disabled = 'disabled'/></td> </tr>");
		out.print("<tr>"
				+ "<td id = 'label'>DOB</td>"
				+ "<td> <input type = 'date' name='dob' required = 'required' id = 'dob' value = '"
				+ user.getDob() + "' disabled = 'disabled'/></td> </tr>");
		out.print("<tr>"
				+ "<td id = 'label'>Password</td>"
				+ "<td> <input type = 'password' name='password' required = 'required' id = 'password' value = '"
				+ password + "' disabled = 'disabled'/></td> </tr>");
		out.print("<tr>"
				+ "<td id = 'label'>Contact Number</td>"
				+ "<td> <input type = 'number' name='contactNumber' required = 'required' id = 'contactNumber' value = '"
				+ user.getContactNumber()
				+ "' disabled = 'disabled'/></td> </tr>");
		out.print("<tr>"
				+ "<td id = 'label'>Organization</td>"
				+ "<td> <select id = 'organization' name='organization' value = '"
				+ user.getOrganization() + "' disabled = 'disabled'>"
				+ "<option value = 'Metacube'> Metacube Pvt. Ltd.</option>"
				+ "<option value = 'Google'> Google </option>"
				+ "<option value = 'Microsoft'> Microsoft </option>"
				+ "<option value = 'Apple'> Apple </option>"
				+ "<option value = 'Facebook'> Facebook </option>"
				+ "</select></td> </tr>");
		out.print("<tr>"
				+ "<td> <input type = 'submit' value = 'Edit Profile' id = 'editProfileButton'/> </td>"
				+ "</tr>");
		out.print("</table>" + "</form>" + "</body>" + "</html>");
	}
}
