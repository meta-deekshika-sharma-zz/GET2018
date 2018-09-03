package com.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.JDBCQuery;

public class ProfileFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String email = (String) req.getAttribute("email");
		String password = (String) req.getAttribute("password");
	
		PrintWriter out = response.getWriter();

		if (JDBCQuery.validateUser(email, password)) {
		

			HttpSession session = req.getSession();
			if(session != null)
			{
				session.invalidate();
			}
			HttpSession newSession = req.getSession(true);
			newSession.setAttribute("email", email);
			newSession.setAttribute("password", password);
			chain.doFilter(request, response);
		} else {
			out.print("something wrong happen");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
