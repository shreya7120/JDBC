package servlet_jdbc_pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SelectStudent
 */
public class SelectStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("Servlet 1 Executed...");
		try {
			
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/test","root","root");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from student");
		out.println("<table BORDER=2>");
		out.println("<TR>");
		out.println("<TH>ROLLNO</TH>");
		out.println("<TH>NAME</TH>");
		out.println("</TR>");
		
		while(rs.next())
		{
			int roll=rs.getInt("rollno");
			String name=rs.getString("name");
			
			out.println("<br><TR>");
			out.println("<TD>"+roll+"</TD>");
			out.println("<TD>"+name+"</TD>");
			out.println("</TR>");
			
		}
		
		conn.close();
		}
		catch(Exception e)
		{
			out.println("error occured");
		}
		
	}
}
