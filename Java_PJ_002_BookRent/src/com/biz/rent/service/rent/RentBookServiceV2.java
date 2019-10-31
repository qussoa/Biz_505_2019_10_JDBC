package com.biz.rent.service.rent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.biz.rent.persistence.RentBookDTO;

public class RentBookServiceV2 extends RentBookServiceV1 {

	public void insert() {
		while (true) {
			System.out.print("도서코드 : ");
			String strBCode = scan.nextLine();
			if(strBCode.equals("0")) break;
			bs.viewDetail(strBCode);
			if(bdto == null) {
				System.out.println("도서코드 없음");
				continue;
			}else {
				rdto.setRent_bcode(strBCode);
			}
			break;
			} 
		if(rdto.getRent_bcode().isEmpty())
			return;
		
		while(true) {
			System.out.print("도서명 : ");
			String strBName = scan.nextLine();
			bList = bDao.findByName(strBName);
			if(bList != null && bList.size()>0) {
				bs.viewNameList();
			}
			break;
		}
		while(true) {
			System.out.println("대출");
			String strRentY = scan.nextLine();
			if(strRentY == null ) {
				rdto.setRent_retur_yn(strRentY);
			} 
			List<RentBookDTO> rList = rDao.rentYN();
			if(rList.size()>0) {
				System.out.println("이미 대출된 도서입니다.");
				this.
				continue;
			}
		}
		if(rdto.getRent_retur_yn().isEmpty())
			return;
		while(true) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String curDate = sd.format(date);
			System.out.printf("대출날짜(%s) : ", curDate);
			String strDate = scan.nextLine();
			if(strDate.trim().isEmpty()) {
				rdto.setRent_return_date(curDate);
			}
					
		}
	}
	
}
