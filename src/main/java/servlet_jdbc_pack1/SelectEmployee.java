package servlet_jdbc_pack1;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SelectEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<font size=6 color='blue' face='forte'>Fetching record from table employees ...</font>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/oracledb","root","root");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from employees");
			out.println("<TABLE BORDER=2>");
			out.println("<TR>");
			out.println("<TH>ID</TH>");
			out.println("<TH>NAME</TH>");
			out.println("<TH>AGE</TH>");
			out.println("<TH>ADDRESS</TH>");
			out.println("</TR>");
			
			while(rs.next())
			{
			
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int age=rs.getInt("age");
			String address=rs.getString("address");
			
			out.println("<br><TR><TD>"+id+"</TD>");
			out.println("<TD>"+name+"</TD>");
			out.println("<TD>"+age+"</TD>");
			out.println("<TD>"+address+"</TD></TR>");
			}
			
			conn.close();
			
		}
		catch(Exception e)
		{
			out.println("Error Occured");
		}
	}

}
