package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.utils.MySQLDatabaseUtils;

@WebServlet("/ddl-operations")
public class DDLOperationsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			Connection connection = MySQLDatabaseUtils.getConnection();
			
			/*
			 * String CREATE_SQL =
			 * "create table department (eid int(5), deptno char(10),deptname varchar(20))";
			 * 
			 * Statement statement = connection.createStatement();
			 * 
			 * statement.execute(CREATE_SQL);
			 */
			
			/*
			 * String ALTER_SQL = "ALTER TABLE department add depthead varchar(15)";
			 * 
			 * Statement statement = connection.createStatement();
			 * statement.execute(ALTER_SQL);
			 */
			
			String DROP_SQL = "drop table department";
			Statement statement = connection.createStatement();
			statement.execute(DROP_SQL);
			
			statement.close();
			connection.close();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h3>Table Dropped </h3>");
			
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
