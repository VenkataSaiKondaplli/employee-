package com.DeleteCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCode")
public class DeleteCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();	
		    String email=request.getParameter("email");
		      try
	            {
		    	    Class.forName("oracle.jdbc.driver.OracleDriver");
			        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bdb","bdb");
	                PreparedStatement ps = connection.prepareStatement("delete from EMP where email = ?");
		            ps.setString(1, email);
	                int i=ps.executeUpdate();
			         if(i>0)
			           {
			    	 out.println("Deleted Employee Successfully");
			           }
			         else  {
			    	 out.println("Somthing went wrong,please try again");
		
		                  }
			           connection.close();
		             }
			 
					 catch (Exception e) {
						e.printStackTrace();
					}

		
		
	}

}
