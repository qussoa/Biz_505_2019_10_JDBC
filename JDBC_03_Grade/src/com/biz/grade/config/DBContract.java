package com.biz.grade.config;
/*
 * DBMS에 연결하고
 * 사용할 sql등과 관련된 정보 등록
 */
public class DBContract {

	public static class DBConn{
		public static final String JdbcDriver = "";
		public static final String URL = "";
		public static final String USER = "";
		public static final String PASSWORD = "";

	}	
	public static class SQL{
		
		public static final String SELECT_SCORE
		=" SELECT S_ID," +
		" S_SCORE," +
		" S_REM," +
		" S_SUBJECT," +
		" S_STD" +
		" FROM tbl_score ";
		
		public static final String SELECT_VIEW_SCORE
		=" SELECT S_SUBJECT," + 
				" S_STD," + 
				" S_SCORE," + 
				" S_ID," + 
				" ST_NAME," + 
				" ST_GRADE," + 
				" ST_DEPT," + 
				" SB_NAME," + 
				" D_TEL," + 
				" D_NAME" +
				" FROM view_score ";
				
		
		
	}
}
