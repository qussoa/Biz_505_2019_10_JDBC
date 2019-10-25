package com.biz.dbms.config.exec;

import com.biz.dbms.config.service.BBsServiceV1;

public class BBsEx_01 {

	public static void main(String[] args) {
		
		BBsServiceV1 bs = new BBsServiceV1();
		
		bs.writeBBS();
		bs.viewBBsList();
		
	}
}
