package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.utils.MySQLDatabaseUtils;

import java.sql.*;

@WebServlet("/insert-data")
public class InsertSqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//Read the parameter's from request
		String name = request.getParameter("NAME");
		String email = request.getParameter("EMAIL");
		String phone = request.getParameter("PHONE");
		
		
		try {
			//Initialize the database
			Connection connection = MySQLDatabaseUtils.getConnection();
			
			String INSERT_SQL = "insert into customer(name,email,phone) values(?,?,?)";
			
			// create a Prepared Statement
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, phone);
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			out.println("<h3>Successfully Inserted</h3>");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
