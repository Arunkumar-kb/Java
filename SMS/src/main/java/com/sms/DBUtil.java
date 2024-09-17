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
       
	 private static Connection getConnection() throws Exception {
	        String url = "jdbc:mysql://localhost:3306/test";
	        String username = "root";
	        String password = "";
	        Class.forName("com.mysql.jdbc.Driver");
	        return DriverManager.getConnection(url, username, password);
	  }
	    public static boolean registerUser(String uname, String email, String pwd) {
	        try (Connection conn = getConnection()) {
	        	if(uname.equals("") || email.equals("") || pwd.equals("")) {
	        		return false;
	        	}
	        	else {
	            String sql = "INSERT INTO user (uname, email, pwd) VALUES (?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, uname);
	            stmt.setString(2, email);
	            stmt.setString(3, pwd);
	            stmt.executeUpdate();
	            return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public static boolean validateUser(String email, String password) {
	        try (Connection conn = getConnection()) {
	            String sql = "SELECT * FROM user WHERE email = ? AND pwd = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
