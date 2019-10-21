package com.biz.grade.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConn = null;

	/*
	 * static 생성자
	 * 
	 * 프로젝트가 시작된과 동시에
	 * JVM에 의해 자동으로 실행되는 클래스와 무관한
	 * 전역(전체에서 접근 가능한) 생성자 method
	 */
	static {
		String jdbcDriver = DBContract.DBConn.JdbcDriver;
		String url = DBContract.DBConn.URL;
		String user = DBContract.DBConn.USER;
		String password = DBContract.DBConn.PASSWORD;

		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
