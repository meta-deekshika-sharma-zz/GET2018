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

import com.DAO.JDBCQuery;
import com.Facade.UserFacade;
import com.Model.UserDAO;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		UserDAO user = new UserDAO(firstName, lastName, email, dob, password, contactNumber, organization);
		UserFacade userFacade = UserFacade.getInstance();
		
		PrintWriter out = response.getWriter();
		if(userFacade.validateEmail(user))
		{
			request.getRequestDispatcher("ProfileServlet").include(request, response);
		}
	    else
	    {
	    	out.print("something wrong");
	    }
	}
}
