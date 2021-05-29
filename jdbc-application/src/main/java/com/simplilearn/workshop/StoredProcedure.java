package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.simplilearn.workshop.utils.MySQLDatabaseUtils;

/**
 * Servlet implementation class StoredProcedure
 */
@WebServlet("/stored-procedure")
public class StoredProcedure extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			Connection connection = MySQLDatabaseUtils.getConnection();
		
			//  create a procedure
			String create_procedure = "create procedure show_customers()"
					+ "BEGIN"
					+ " select * from customer;"
					+ "END";
			
			//Statement statement = connection.createStatement();
			//statement.executeUpdate(create_procedure);
			
			CallableStatement callableStatement = connection.prepareCall("{call show_customers()}");
			
			ResultSet rs = callableStatement.executeQuery();
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			while(rs.next()) {
				out.println(rs.getString("NAME") +"<br/>");
			}
			
			callableStatement.close();
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
