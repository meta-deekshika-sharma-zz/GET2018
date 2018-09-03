package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Facade.UserFacade;
import com.Model.UserDAO;


@WebServlet("/EditImageServlet")
public class EditImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session=request.getSession();
	        
	        String email = (String) session.getAttribute("email");
	        String password = (String) session.getAttribute("password");
	        
	        UserFacade userFacade = UserFacade.getInstance();
	        UserDAO user = userFacade.getDetails(email, password);
	        
	        PrintWriter out = response.getWriter();
	        
	        out.print("<table width='75%' align='center'>");
	        out.print("<tr>");
	            out.print("<td>");
	                out.print("<img src='images/html5Logo.png' alt='HTML 5 image' height='50px'/>");
	            out.print("</td>");
	            out.print("<td align='right'>");
	                out.print("<a href='LoginServlet'>" + user.getFirstName() + " " + user.getLastName() + "</a>  ");
	                out.print("<a href='FriendsServlet'>Friends </a>");
	                out.print("<a href='LogoutServlet'>Logout </a>");
	                out.print("  <a href='ImageUpdationServlet'> <img src='" + user.getImagePath() + "' alt='user icon' height='50px'/> </a>");
	            out.print("</td>");
	        out.print("</tr>");
	        out.print("</table>");
	    
	        out.print("<hr/>");
	        
	        out.print("<div align='center'>");
	            out.print("<form action='SetImageServlet'>");
	                out.print("<img src='" + user.getImagePath() + "' height='150px'/><br/>");
	                out.print("<input type='file' name='upload'/><br/><br/>");
	                out.print("<input type='submit' value='Upload image'/>");
	            out.print("</form>");
	        out.print("</div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
