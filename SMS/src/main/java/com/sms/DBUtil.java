package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class DBUtil
 */
@WebServlet("/DBUtil")
public class DBUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected static Connection getConnection() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/test";
	        String username = "root";
	        String passwrd = "";
	        Class.forName("com.mysql.jdbc.Driver");
	        return DriverManager.getConnection(url, username, passwrd);
	  }
	    public static boolean registerUser(String uname, String rollno, String email, String mobile, String dept, String gender, String pwd) {
	        try (Connection conn = getConnection()) {
	        	if(uname.equals("") || email.equals("") || pwd.equals("")) {
	        		return false;
	        	}
	        	else {
	            String sql = "INSERT INTO student (sname, rollno, email, mobile, course, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, uname);
	            stmt.setString(2, rollno);
	            stmt.setString(3, email);
	            stmt.setString(4, mobile);
	            stmt.setString(5, dept);
	            stmt.setString(6, gender);
	            stmt.setString(7, pwd);
	            stmt.executeUpdate();
	            return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public static boolean validateUser(String rollno, String password) {
	        try (Connection conn = getConnection()) {
	            String sql = "SELECT * FROM student WHERE rollno = ? AND password = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, rollno);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
