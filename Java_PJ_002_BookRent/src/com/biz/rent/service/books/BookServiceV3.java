package com.biz.rent.service.books;

import java.util.List;

import com.biz.rent.persistence.BookDTO;

public class BookServiceV3 extends BookServiceV2 {

	public void search() {
		System.out.print("도서명(Enter) : ");
		String strName = scan.nextLine();

		List<BookDTO> bList = null;
		if (strName.trim().isEmpty()) {
			bList = bDao.selectAll();
		} else {
			bList = bDao.findByName(strName);
		}
		for (BookDTO dto : bList) {
			this.viewDetail(dto);
			}
	}
	public void insert() {
		System.out.println("==============================================");
		String strBcode;
		while (true) {
			System.out.println("도서코드(자동생성: Enter, 0: 종료)");
			strBcode = scan.nextLine();
			if (strBcode.equals("0"))
				break;
			if (strBcode.trim().isEmpty()) {
				String strTMBCode = bDao.getMaxBCode();
				int intBCode = Integer.valueOf(strTMBCode.substring(2));
				intBCode++;
				strBcode = strTMBCode.substring(0, 2);
				strBcode += String.format("%04d", intBCode);

				System.out.println("생성된 코드 : " + strBcode);
				System.out.println("사용하려면 Enter");
				String strYesNo = scan.nextLine();
				if (strYesNo.trim().isEmpty())
					break;
				else
					continue;
			}
			if (strBcode.length() != 6) {
				System.out.println("도서코드는 6자리");
				continue;
			}
			strBcode = strBcode.toUpperCase();
			if (strBcode.substring(0, 2).equalsIgnoreCase("BC")) {
				System.out.println("도서 코드는 BK");
				continue;
			}
			try {
				Integer.valueOf(strBcode.substring(3));
			} catch (Exception e) {
				System.out.println("도서코드 세번째부터 숫자");
				continue;
			}
			if (bDao.findById(strBcode) != null) {
				System.out.println("이미 등록됨");
				continue;
			}
			break;
		}
		if (strBcode.equals("0"))
			return;
		while (true) {
			System.out.print("도서명(0: 종료) :  ");
			String strBName = scan.nextLine();
			if (strBName.equals("0"))
				break;
			if (strBName.trim().isEmpty()) {
				System.out.println("도서명 입력");
				continue;
			}

			System.out.print("저자(0: 종료) :  ");
			String strBAute = scan.nextLine();
			if (strBAute.equals("0"))
				break;
			if (strBAute.trim().isEmpty()) {
				System.out.println("저자 입력");
				continue;
			}
			System.out.print("출판사(0: 종료) :  ");
			String strBCom = scan.nextLine();
			if (strBCom.equals("0"))
				break;
			if (strBCom.trim().isEmpty()) {
				System.out.println("출판사 입력");
				continue;
			}
			System.out.print("출판일(0: 종료) :  ");
			String strBYear = scan.nextLine();
			if (strBYear.equals("0"))
				break;
			if (strBYear.trim().isEmpty()) {
				System.out.println("출판일 입력");
				continue;
			}
			System.out.print("구입가격(0: 종료) :  ");
			String strBIPrice = scan.nextLine();
			if (strBIPrice.equals("0"))
				break;
			if (strBIPrice.trim().isEmpty()) {
				System.out.println("구입가격 입력");
				continue;
			}
			System.out.print("대여가격(0: 종료) :  ");
			String strBRPrice = scan.nextLine();
			if (strBRPrice.equals("0"))
				break;
			if (strBRPrice.trim().isEmpty()) {
				System.out.println("대여가격 입력");
				continue;
			}
			BookDTO bdto = BookDTO.builder().b_code(strBcode).b_name(strBName).b_auther(strBAute).b_comp(strBCom).b_year(strBYear)
					.b_iprice(strBIPrice).b_rprice(strBRPrice).build();
			int ret = bDao.insert(bdto);
			if (ret > 0) {
				System.out.println("입력완료");
			} else {
				System.out.println("입력실패");
			}
			break;

		}
	}
	
	public void update() {
		System.out.println("==============================================");
		System.out.print("수정할 코드 : ");
		String strBCode = scan.nextLine();
		strBCode.toUpperCase();
		
		BookDTO bdto = this.viewDetail(strBCode);
		System.out.print("도서명 : ");
		String strBName = scan.nextLine();
		if(!strBName.trim().isEmpty()) {
			bdto.setB_name(strBName);
		}
		System.out.print("저자 : ");
		String strBAuth = scan.nextLine();
		if(!strBAuth.trim().isEmpty()) {
			bdto.setB_auther(strBAuth);
		}
		System.out.print("출판사 : ");
		String strBCom = scan.nextLine();
		if(!strBCom.trim().isEmpty()) {
			bdto.setB_comp(strBCom);
		}
		System.out.print("출판일 : ");
		String strBYear = scan.nextLine();
		if(!strBYear.trim().isEmpty()) {
			bdto.setB_year(strBYear);
		}
		System.out.print("가격 : ");
		String strBIprice = scan.nextLine();
		if(!strBIprice.trim().isEmpty()) {
			bdto.setB_iprice(strBIprice);
		}
		System.out.print("대여가격 : ");
		String strBRPrice = scan.nextLine();
		if(!strBRPrice.trim().isEmpty()) {
			bdto.setB_rprice(strBRPrice);
		}
		int ret = bDao.update(bdto);
		if(ret > 0) {
			System.out.println("변경완료");
		}else {
			System.out.println("변경실패");
		}
	}
	public void delete() {
		System.out.println("==============================================");
		while(true) {
			System.out.println("삭제할 도서코드 : ");
			String strDCode = scan.nextLine();
			if(strDCode.equals("0")) break;
			BookDTO bdto = bDao.findById(strDCode);
			if(bdto == null) {
				System.out.println("삭제할 코드 없음");
				continue;
			}
			this.viewDetail(bdto);
			System.out.println("삭제 Enter");
			String YesNO = scan.nextLine();
			if(YesNO.trim().isEmpty()) {
				int ret = bDao.delete(strDCode);
				if(ret>0) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
			}
		}
	}
}
