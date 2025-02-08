package com.jdbc.emp.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbUtil {
	public static Connection getDbConnection() {
		Connection connection=null;
		try {
			//1. load and register mysql driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Establishing a connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		// Just to check whether it works or not
		System.out.println("Connection established..");
		return connection;
	}
}
