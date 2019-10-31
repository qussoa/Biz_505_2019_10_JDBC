package com.biz.rent.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
	private String b_code;		//  varchar2(6 byte)
	private String b_name;		//	nvarchar2(125 char)
	private String b_auther;	//	nvarchar2(125 char)
	private String b_comp;		//	nvarchar2(125 char)
	private String b_year;		//	number
	private String b_iprice;	//	number
	private String b_rprice;	//	number
}
