package servlet_jdbc_pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UseDbPreStmt extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("Servlet Executed for select Database...");
		
		try {
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/test","root","root");
			PreparedStatement stmt=conn.prepareStatement("Use Test");
			stmt.executeUpdate();
			out.println("Given Database Selected...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
				
	}

}
