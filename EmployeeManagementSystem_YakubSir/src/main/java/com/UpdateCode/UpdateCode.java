package com.UpdateCode;

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

import com.LoginCode.LoginCode;

@WebServlet("/UpdateCode")
public class UpdateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		long mobile_no=Long.parseLong(request.getParameter("mobile"));
		String address=request.getParameter("address");
		if (name.equals(LoginCode.name))
		{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bdb","bdb");
			PreparedStatement ps = con.prepareStatement("UPDATE EMP SET PASSWORD=?, EMAIL=?, MOBILENUMBER=?,ADDRESS=? WHERE NAME=?");
			ps.setString(1,password);
			ps.setString(2,email);
			ps.setLong(3,mobile_no);
			ps.setString(4,address);
			ps.setString(5,name);
			int i=ps.executeUpdate();
			
			if (i>0) {
				out.println("Updated Employee Successfully");
				
			} else {
				out.println("sorry.. something went wrong please try agian..");
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		else {
			out.println("Enter Your Data only not Others");
	
		}
		
	}

}
