//executeQuery() is a method of Statement     mn bvcvbnbvbnṁ
package servlet_jdbc_pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestEQ1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<font size=6 color='blue' face='forte'>Fetching record from table employees ...</font>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3310/oracledb","root","root");
			Statement stmt=conn.createStatement();
			stmt.executeQuery("Select * from employees");
			out.println("Test Executed");
			
		}
		catch(Exception e)
		{
			out.println("Error Occured");
		}
	}

}
