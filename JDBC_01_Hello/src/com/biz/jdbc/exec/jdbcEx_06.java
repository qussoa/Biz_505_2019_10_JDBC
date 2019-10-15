package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.domain.ScoreVO;
import com.biz.jdbc.service.ScoreJDBCServiceV3;

public class jdbcEx_06 {
public static void main(String[] args) {
	
	ScoreJDBCServiceV3 sc = new ScoreJDBCServiceV3();
	
	List<ScoreVO> stdList  = sc.findById(30);
		
	for(ScoreVO vo : stdList) {
		System.out.println(vo);
	}
}
}
