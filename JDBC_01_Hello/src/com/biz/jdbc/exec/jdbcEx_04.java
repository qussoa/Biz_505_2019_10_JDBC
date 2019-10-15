package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.domain.ScoreVO;
import com.biz.jdbc.service.ScoreJDBCServiceV2;

public class jdbcEx_04 {
public static void main(String[] args) {
	
	ScoreJDBCServiceV2 sc = new ScoreJDBCServiceV2();
	
	sc.selectAll();
	List<ScoreVO> stdList = sc.selectAll();
	stdList = sc.findById(30);
	stdList = sc.findByName("갈한수");
	
	for(ScoreVO vo : stdList) {
		System.out.println(vo.toString());
	}
}
}
