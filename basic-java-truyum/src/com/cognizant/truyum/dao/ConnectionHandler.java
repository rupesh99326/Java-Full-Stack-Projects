package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class ConnectionHandler {

	public static Connection getConnection() {

		Properties prop = new Properties();
		Connection con = null;
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("connection-url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("password");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("hello");
		return con;
	}


}
