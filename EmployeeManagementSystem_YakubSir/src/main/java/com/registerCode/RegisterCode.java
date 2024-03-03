package com.registerCode;

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

@WebServlet("/RegisterCode")
public class RegisterCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("PASSWORD");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		long mobilenumber=Long.parseLong(request.getParameter("mobile"));
		String state=request.getParameter("state");
		String country=request.getParameter("select_country");
		String address=request.getParameter("address");
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bdb","bdb");
			PreparedStatement ps=con.prepareStatement("insert into EMP values(?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setLong(5,mobilenumber);
			ps.setString(6,state);
			ps.setString(7,country);
			ps.setString(8,address);
			
			
			
			int i=ps.executeUpdate();
			
			if (i>0) {
				out.println("Registerd Successfully");
				
			} else {
				out.println("sorry.. something went wrong please try agian..");
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
