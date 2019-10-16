package com.biz.grade.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.persistence.ScoreVO;
import com.biz.grade.utils.DBContract;

public class ScoreServiceV1 extends ScoreService {

	@Override
	public int insert(ScoreDTO dvo) {

		this.dbConnection();
		PreparedStatement pStr = null;
		
		String sql = " INSERT INTO tbl_score ( " ;
		sql += " S_ID,"
				+ "S_SCORE,"
				+ "S_REM,"
				+ "S_SUBJECT,"
				+ "S_STD ) ";
		sql += " VALUES(?,?,?,?,?) ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, dvo.getS_id());
			pStr.setInt(2, dvo.getS_score());
			pStr.setString(3, dvo.getS_rem());
			pStr.setString(4, dvo.getS_subject());
			pStr.setString(5, dvo.getS_std());
			
			int ret = pStr.executeUpdate();
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<ScoreDTO> selectAll() {
		this.dbConnection();
		PreparedStatement pStr = null;
	//	String sql = " SELECT S_ID,S_STD,S_SCORE, S_SUBJECT,S_REM FROM "; 
	//	sql += DBContract.TABLE.SCORE;
		
		try {
			pStr = dbConn.prepareStatement(DBContract.SQL.SCORE_SELECT);
			ResultSet rst = pStr.executeQuery();
			List<ScoreDTO> scoreList = new ArrayList<ScoreDTO>();
			
			/*
			 * ResultSet으로 부터 데이터를 getter할때 칼럼의
			 * 위치값(숫자)로  사용하던 것을 
			 * 지금 칼럼의 이름으로 사용할 수 있다
			 */
			while(rst.next()) {
				scoreList.add(ScoreDTO.builder()
						.s_id(rst.getLong("S_ID"))
						.s_std(rst.getString("S_STD"))
						.s_score(rst.getInt("S_SCORE"))
						.s_subject(rst.getString("S_SUBJECT"))
						.s_rem(rst.getString("S_REM"))
						.build());
			}
			rst.close();
			dbConn.close();
			
			return scoreList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ScoreDTO findById(long id) {

		this.dbConnection();
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SCORE_SELECT;
		sql += " WHERE s_id = ? ";
		try {
			pStr = dbConn.prepareStatement(sql);
			// SQL 문의 ? 대신 사용할 값 setting
			pStr.setLong(1, id);
			
			ResultSet rst = pStr.executeQuery();
			ScoreDTO scoreDTO =null;
			if(rst.next()) {
				scoreDTO = ScoreDTO.builder()
						.s_id(rst.getLong("S_ID"))
						.s_std(rst.getString("S_STD"))
						.s_score(rst.getInt("S_SCORE"))
						.s_subject(rst.getString("S_SUBJECT"))
						.s_rem(rst.getString("S_REM"))
						.build();
				
			}
			rst.close();
			dbConn.close();
			return scoreDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int update(ScoreDTO dvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ScoreDTO> findByName(String name) {
		
		this.dbConnection();
		PreparedStatement pStr = null;
		
		String sql = DBContract.SQL.SCORE_SELECT ;
		sql += " WHERE s_std = ? ";
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			ResultSet rst = pStr.executeQuery();
			
			List<ScoreDTO> scoreList = new ArrayList<ScoreDTO>();
			
			while(rst.next()) {
				scoreList.add(
						ScoreDTO.builder()
						.s_id(rst.getLong("S_ID"))
						.s_std(rst.getString("S_STD"))
						.s_score(rst.getInt("S_SCORE"))
						.s_subject(rst.getString("S_SUBJECT"))
						.s_rem(rst.getString("S_REM"))
						.build());
					}
			rst.close();
			dbConn.close();
			return scoreList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<ScoreDTO> findBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

}
