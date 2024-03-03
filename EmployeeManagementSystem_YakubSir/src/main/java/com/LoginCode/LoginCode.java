package com.LoginCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCode")
public class LoginCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public static String name;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
	
		 try
	        {
		         Class.forName("oracle.jdbc.driver.OracleDriver");
		         Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bdb","bdb");
                 PreparedStatement ps = connection.prepareStatement("select * from EMP where email = ? and password = ?");
	             ps.setString(1, email);
	             ps.setString(2, password);	
		        
		      ResultSet rs = ps.executeQuery();
		         if(rs.next())
		           {
		    	 response.sendRedirect("empHome.html");
		           }
		         else  {
		        	 response.sendRedirect("failed.html");
	
	                  }
		           connection.close();
	             }
		 
		 catch (Exception e) {
			// TODO: handle exception
		}	}

}
