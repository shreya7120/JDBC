package servlet_jdbc_pack1;

import java.sql.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CreateDb extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<font size=6 color='purple' face=forte>Servlet Executed for creating database in mysql ...</font>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310","root","root");
			PreparedStatement stmt=conn.prepareStatement("Create Database RajBlack ");
			stmt.executeUpdate();
			
			out.println("<br><font size=8>Database created Succesfully...</font>");
			
		}
		catch(Exception e)
		{
			//out.println("Error Occured...");
			e.printStackTrace();
		}
	}

}
