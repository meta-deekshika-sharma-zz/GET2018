package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.JDBCQuery;
import com.Model.UserDAO;

public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		List<UserDAO> friendList = JDBCQuery.showFriends(email);
		PrintWriter out = response.getWriter();

		String cssFile = "<link rel = 'stylesheet' href = 'CSS/UserCSS.css' />";
		out.println("<!DOCTYPE html>" + "<html>" + "<head>"
				+ "<title>Friend List</title>" + cssFile + "</head>" + "<body>"
				+ "<h1 align = 'center'>Friends</h1>" + "<form>"
				+ "<table id = 'updateTab'>" + "<tr>"
				+ "<th id = 'heading'> First Name </th>"
				+ "<th id = 'heading'> Last Name </th>"
				+ "<th id = 'heading'> Email </th>");

		for (UserDAO friend : friendList) {
			System.out.println(friend.getContactNumber());
			out.print("<tr>" + "<td id = 'row'>" + friend.getFirstName()
					+ "</td>");
			out.print("<td id = 'row'>" + friend.getLastName() + "</td>");
			out.print("<td id = 'row'>" + friend.getEmail() + "</td>");
			out.print("<td id = 'row'>" + "<a href='FriendDetailServlet?email="
					+ friend.getEmail() + "&firstName=" + friend.getFirstName()
					+ "&lastName=" + friend.getLastName() + "&dob="
					+ friend.getDob() + "&contactNumber= "
					+ friend.getContactNumber() + "'>Open</a>" + "</td>"
					+ "</tr>");
		}
		out.println("</table>" + "</form>" + "</body>" + "</html>");
	}
}
