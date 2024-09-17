package com.sms;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/signin")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    String email = request.getParameter("email");
	        String password = request.getParameter("pwd");
	        
	        // Use utility class to validate user credentials
	        if(DBUtil.validateUser(email, password)) {
	        	HttpSession session = request.getSession();
	            session.setAttribute("Email", email);
	            response.sendRedirect("welcome.jsp");
	        } else {
	            response.sendRedirect("login.jsp?error=Invalid email or password");
	        }
		
	}


}
