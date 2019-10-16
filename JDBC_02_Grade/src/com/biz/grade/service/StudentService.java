package com.biz.grade.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.biz.grade.persistence.StudentDTO;
import com.biz.grade.persistence.ScoreVO;
import com.biz.grade.utils.DBContract;

/*
 * 추상클래스 선언
 * 특징 일부는 구현된 method와 형태만 갖는 method
 * 
 */
public abstract class StudentService {

	protected Connection dbConn = null;

	/*
	 * dbConn 을 설정하여 DBMS에 접속할 수 있는 통로 설정
	 */
	protected void dbConnection() {
		try {
			Class.forName(DBContract.DbConn.JdbcDriver);
			dbConn = DriverManager.getConnection(DBContract.DbConn.URL, DBContract.DbConn.USER,
					DBContract.DbConn.PASSWORD);
			System.out.println("DBConnection Ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC DRIVER ERROR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DBMS CONNECT ERROR");
		}
	}

	//CRUD
	public abstract int insert(StudentDTO dvo);
	// 모든 레코드
	// 1개 이상의 레코드
	
	public abstract List<StudentDTO> selectAll();
	// id값을 매개변수로 받아서
	// 1개의 레코드만 조회하는 method
	
	public abstract StudentDTO findById(String num);
	public abstract List<StudentDTO> findByName(String name);
	public abstract List<StudentDTO> findBySubject(String subject);
	public abstract int update(StudentDTO svo);
	public abstract int delete(long id);
}
