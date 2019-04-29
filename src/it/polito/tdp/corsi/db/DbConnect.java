package it.polito.tdp.corsi.db;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DbConnect {
	public static Connection getConnection() {
	Connection conn;
	try{	
		String jdbcURL= "jdbc:mysql://127.0.0.1:3306/iscritticorsi?user=root&password=password&autoReconnect=true&useSSL=false";
		
		 conn =(Connection) DriverManager.getConnection(jdbcURL);
	}catch (SQLException e) {e.printStackTrace();return null;};

	return conn;
	}
}
