package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.domain.ScoreVO;
import com.biz.jdbc.service.ScoreJDBCServiceV1;

public class jdbcEx_03 {
public static void main(String[] args) {
	
	ScoreJDBCServiceV1 sc = new ScoreJDBCServiceV1();
	
	sc.selectAll();
	List<ScoreVO> scoreList = sc.getScoreList();
	
	for(ScoreVO vo : scoreList) {
		System.out.println(vo.toString());
	}
}
}
