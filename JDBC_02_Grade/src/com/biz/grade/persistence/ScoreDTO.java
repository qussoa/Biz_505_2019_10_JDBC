package com.biz.grade.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * DBMS Table과 연관된 Class
 * VO(Value object), DTO(Data Transfer Object)
 * - 공통기능
 * 		table과 연관되어서 CRUD 수행할때
 * 		데이터를 담아서 method간에 이동할 때 사용
 * - DTO
 * 		물리적 Table과 연관(매핑)되어 완전한 CRUD를 수행할때
 * 		
 * - VO
 * 		View Table, Join 된 SQL과 연관되어
 * 		주로 READ
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ScoreDTO {

	private long s_id;
	private String s_std;
	private String s_subject;
	private int s_score;
	private String s_rem;
	
}
