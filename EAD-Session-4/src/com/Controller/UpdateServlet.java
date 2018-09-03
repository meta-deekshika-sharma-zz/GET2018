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

import com.DAO.JDBCQuery;
import com.Model.UserDAO;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date dob = null;
		SimpleDateFormat format = new SimpleDateFormat("mm-dd-yyyy");
		try {
			dob = format.parse(request.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String contactNumber = request.getParameter("contactNumber");
		String organization = request.getParameter("organization");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String image = request.getParameter("image");

		UserDAO user = new UserDAO(firstName, lastName, email, dob, password,
				contactNumber, organization, image);
		response.setContentType("text/html");

		if (JDBCQuery.updateUser(user) > 0)
			out.print("successfully updated");
		else
			out.print("error");

		request.getRequestDispatcher("ProfileServlet").include(request,
				response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
