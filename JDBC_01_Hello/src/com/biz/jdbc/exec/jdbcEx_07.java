package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.domain.ScoreVO;
import com.biz.jdbc.service.ScoreJDBCServiceV3;

public class jdbcEx_07 {
public static void main(String[] args) {
	
	ScoreJDBCServiceV3 sc = new ScoreJDBCServiceV3();
	
	ScoreVO scoreVO = ScoreVO.builder()
			.s_id(603).s_std("이몽룡").s_score(100).s_rem("연습").build();
		
	int ret = sc.insert(scoreVO);
	System.out.println(ret);
	
	List<ScoreVO> scList =sc.findByName("이몽룡");
	for(ScoreVO sVO : scList) {
		System.out.println(sVO);
	}
}
}
