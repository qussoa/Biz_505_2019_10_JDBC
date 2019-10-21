package com.biz.oracle.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConn = null;
	static{
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "user4";
		String password = "user4";
		
		// JDBC 드라이버를 메모리에 load하여 사용할 준비를 하라
		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DBConnection OK");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static Connection getDBConnection() {
		return dbConn;
	}
	
}
