package com.biz.dbms.config.exec;

import com.biz.dbms.config.service.BBsServiceV3;

public class BBsEx_03 {

	public static void main(String[] args) {
		
		BBsServiceV3 bs = new BBsServiceV3();
		bs.viewBBsList();
		bs.bbsMenu();
	}
}
