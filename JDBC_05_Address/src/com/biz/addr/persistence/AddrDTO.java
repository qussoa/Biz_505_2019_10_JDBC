package com.biz.addr.persistence;

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

public class AddrDTO {

	private long a_id;
	private String a_name;
	private String a_tel;
	private String a_addr;
	private String a_chain;
}
