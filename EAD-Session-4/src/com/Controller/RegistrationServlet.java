package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Facade.UserFacade;
import com.Model.UserDAO;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date dob = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			dob = format.parse(request.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String contactNumber = request.getParameter("contactNumber");
		String organization = request.getParameter("organization");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String image = "Images/DefaultImage.jpg";

		UserDAO user = new UserDAO(firstName, lastName, email, dob, password,
				contactNumber, organization, image);
		UserFacade userFacade = UserFacade.getInstance();

		PrintWriter out = response.getWriter();
		if (userFacade.validateEmail(user)) {
			request.setAttribute("email", user.getEmail());
			request.setAttribute("password", user.getPassword());
			request.getRequestDispatcher("ProfileServlet").forward(request, response);
		} else {
			out.print("something wrong");
		}
	}
}
