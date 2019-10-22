package com.biz.addr.exec;

import com.biz.addr.service.AddrCUDServiceV1;
import com.biz.addr.service.AddrServiceV1;

public class AddrUpdateEx_01 {

	public static void main(String[] args) {

	AddrServiceV1 as = new AddrServiceV1();
	AddrCUDServiceV1 ac = new AddrCUDServiceV1();
	as.viewAddrList();
	String strName = as.serchAddrName();
	if(strName.equals("0")) {
		System.out.println("주소 정보 변경 업무 종료");
	}else {
		ac.updateAddr();
		as.serchAddrName(strName);
	}
	}

}
