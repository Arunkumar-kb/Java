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
		    String rollno = request.getParameter("rollno");
	        String password = request.getParameter("pwd");
	        
	        // Use utility class to validate user credentials
	        if(DBUtil.validateUser(rollno, password)) {
	        	HttpSession session = request.getSession();
	            session.setAttribute("rollno", rollno);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/profileDao");
	            dispatcher.forward(request, response);
//	            response.sendRedirect("welcome.jsp");
	        } else {
	            response.sendRedirect("login.jsp?error=Invalid email or password");
	        }
		
	}


}
