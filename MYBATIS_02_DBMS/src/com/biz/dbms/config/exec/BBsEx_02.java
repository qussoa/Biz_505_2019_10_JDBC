package com.biz.dbms.config.exec;

import com.biz.dbms.config.service.BBsServiceV2;

public class BBsEx_02 {

	public static void main(String[] args) {
		
		BBsServiceV2 bs = new BBsServiceV2();
		bs.viewBBsList();
		bs.bbsMenu();
	}
}
