package com.biz.dbms.config.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BBsDTO {

	/*
	 *  DTO, VO 생성할때
	 *  필드이름은 TABLE의 칼럼이름과 같게 설정
	 *  mybatis 자동setter, getter 호출 
	 */
	private long bs_id;			//  number
	private String bs_date;		//	varchar2
	private String bs_time;		//	varchar2
	private String bs_writer;	//	nvarchar2
	private String bs_subject;	//	nvarchar2
	private String bs_text;		//	nvarchar2
	private int bs_count;		//	number
}
