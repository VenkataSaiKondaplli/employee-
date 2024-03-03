package com.selectCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectCode
 */
@WebServlet("/SelectCode")
public class SelectCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		long  MOBILE=Long.parseLong(request.getParameter("mobile"));
		

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bdb", "bdb");
			PreparedStatement ps=con.prepareStatement("SELECT NAME ,PASSWORD ,EMAIL ,GENDER ,MOBILENUMBER  ,STATE ,COUNTRY ,ADDRESS  from EMP where MOBILENUMBER= ? ");
			ps.setLong(1,  MOBILE);
			ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm=rs.getMetaData();
			out.println("<table border='1'>");
			int n= rsm.getColumnCount();
			for (int i = 1; i <=n; i++) 
				out.println("<td width=70px> <font color=blue size=2>"  +  " <br> " +rsm.getColumnName(i));
			    out.println("<tr>");
			   while(rs.next()) 
			    {
					for(int i=1;i<=n;i++) 
						out.println("<td><br>"+rs.getString(i));
						out.println("</tr>");
									
		           }
			    
			    con.close();
		}
			    catch (Exception e) {
					// TODO: handle exception
			    	e.printStackTrace();
			
   }
	}

}
