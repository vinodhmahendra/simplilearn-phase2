package com.simplilearn.workshop.utils;

import java.sql.*; // jdbc api

public class MySQLDatabaseUtils {
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/pgfsd?useSSL=false"; //change it
		String user = "root";// change it
		String password= "simplilearn"; // change it
		//step #1 : load a driver
		Class.forName(driverClassName);
		//step #2 obtain a connection use a DriverManager class
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
	}

}
