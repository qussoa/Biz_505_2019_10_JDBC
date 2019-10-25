package com.biz.config.service;

import com.biz.iolist.persistence.ProductDTO;

public class ProductServiceV3 extends ProductServiceV2 {
	
	public void menuProduct() {
		System.out.println("==================================");
		System.out.println("대한쇼핑몰 상품관리시스템");
		System.out.println("==================================");
		System.out.println("1.등록 2.수정 3.삭제 4.검색 0.끝");
		System.out.print("업무선택 : ");
		String strMenu = scan.nextLine();
	}
	
	
	public void insertProduct() {
		while(true) {
			System.out.print("상품명(Q) : ");
			String strPName = scan.nextLine();
			if(strPName.equals("Q")) break;
			if(strPName.trim().length() <1 ) {
				System.out.println("상품명을 반드시 입력바람");
				continue;
			}
			System.out.print("매입단가(Q) : ");
			String strIprice = scan.nextLine();
			int intIprice = Integer.valueOf(strIprice);
			if(strIprice.equals("Q")) break;
			if(strIprice.trim().length() <1 ) {
				System.out.println("매입단가를 반드시 입력바람");
				continue;
			}
			System.out.print("매출단가(Q) : ");
			String strOprice = scan.nextLine();
			int intOprice = Integer.valueOf(strOprice);
			if(strOprice.equals("Q")) break;
			if(strOprice.trim().length() <1 ) {
				System.out.println("매출단가를 반드시 입력바람");
				continue;
			}
			ProductDTO pdto = ProductDTO.builder().p_name(strPName)
					.p_iprice(intIprice).p_oprice(intOprice).build();
			int ret = pDao.insert(pdto);
			if (ret > 0) {
				System.out.println("게시판 작성완료");
			} else {
				System.out.println("게시판 작성실패");
			}
			break;
		}
	}
}
