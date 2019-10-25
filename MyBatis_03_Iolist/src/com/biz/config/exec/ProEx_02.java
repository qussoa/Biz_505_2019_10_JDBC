package com.biz.config.exec;

import com.biz.config.service.ProductServiceV1;
import com.biz.config.service.ProductServiceV2;

public class ProEx_02 {

	public static void main(String[] args) {
		
		ProductServiceV2 ps = new ProductServiceV2();
		ps.searchPName();
		ps.proUpdate();
	}
}
