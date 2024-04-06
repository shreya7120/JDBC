package servlet_jdbc_pack1;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

/*import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

/*
 * Servlet implementation class JDBCConnection1
 */
public class JDBCConnection1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("Servlet 1 Executed...<br>");
		try {
			
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/test","root","root");
		out.println(conn);
		conn.close();
		}
		catch(Exception e)
		{
			out.println("error occured");
		}
	} 

}
