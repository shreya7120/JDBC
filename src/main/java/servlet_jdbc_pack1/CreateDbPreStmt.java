package servlet_jdbc_pack1;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateDbPreStmt extends HttpServlet {

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<font size=6 color='purple' face=forte>Servlet Executed for creating database in mysql ...</font>");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310","root","root");
				Statement stmt=conn.createStatement();
				String query="Create Database varshasoftwares";
				stmt.executeUpdate(query);
				
				out.println("<br><font size=8>Database created Succesfully...</font>");
				
			}
			catch(Exception e)
			{
				//out.println("Error Occured...");
				e.printStackTrace();
			}
		}

	}
