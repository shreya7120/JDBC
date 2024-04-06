package servlet_jdbc_pack1;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UseDb extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<font size=7 color='red' >");
		out.println("Servlet Executed to select db ...<br></font>");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310","root","root");
			Statement stmt=conn.createStatement();
			
			String query="Use assembly_advance";
			stmt.executeUpdate(query);
			out.println("Database selected...");
			
		}
		catch(Exception e)
		{
			out.println("Error occured...");
		}
	}

}
