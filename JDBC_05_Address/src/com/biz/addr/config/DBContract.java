package com.biz.addr.config;

public class DBContract {

	public static class SQL{
		public static final String SELECT_ADDR
		= " SELECT A_ID," + 
				" A_NAME," + 
				" A_TEL," + 
				" A_ADDR," + 
				" A_CHAIN " + 
			" FROM tbl_addr ";
	}
}
