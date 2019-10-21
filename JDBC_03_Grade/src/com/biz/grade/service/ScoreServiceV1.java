package com.biz.grade.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.biz.grade.config.DBContract;
import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.persistence.ScoreVO;

public abstract class ScoreServiceV1 {

	protected Connection dbConn = null;
	
	protected void dbConnection() {
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
	
	public abstract List<ScoreVO> selectAll();
	public abstract ScoreVO findById(long id);
	public abstract int insert(ScoreDTO sdto);
	public abstract int update(ScoreDTO sdto);
	public abstract int delete(ScoreDTO sdto);
	
}
