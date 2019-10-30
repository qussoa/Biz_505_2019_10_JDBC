package com.biz.iolist.service.iolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.biz.iolist.persistence.DeptDTO;
import com.biz.iolist.persistence.IolistDTO;
import com.biz.iolist.persistence.IolistVO;
import com.biz.iolist.persistence.ProductDTO;
import com.biz.iolist.service.dept.DeptServiceV3;
import com.biz.iolist.service.pro.ProductServiceV4;

public class IolistServiceV3 extends IolistServiceV1 {

	protected DeptServiceV3 deptService = new DeptServiceV3();
	protected ProductServiceV4 proService = new ProductServiceV4();

	@Override
	protected void update() {

		System.out.println("=========================================");
		System.out.println("매입매출수정");
		System.out.println("=========================================");

		System.out.print("거래처명 : ");
		String strDname = scan.nextLine();
		if(strDname.trim().isEmpty()) {
			ioView.viewAllList();
		}else {
			ioView.viewListByDName(strDname);
		}
		
		System.out.print("수정할 SEQ : ");
		String strSEQ = scan.nextLine();

		long longSeq = 0;
		try {
			longSeq = Long.valueOf(strSEQ);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SEQ형식이 틀림");
			return;
		}

		// seq 해당하는 iolist 가져오기
		IolistDTO iolistDTO = iDao.findById(longSeq);

		while (true) {

			System.out.printf("거래구분[%s] 선택 입력 (1:매입  2:매출 -1: 종료) : ", iolistDTO.getIo_inout());
			String strInout = scan.nextLine();
			try {
				int intInout = Integer.valueOf(strInout);
				if (intInout < 0)
					break;

				if (intInout == 1) {
					iolistDTO.setIo_inout("매입");
				} else if (intInout == 2) {
					iolistDTO.setIo_inout("매출");
				} else {
					System.out.println("매입 매출 구분 다시 선택");
					continue;
				}

			} catch (Exception e) {
				System.out.println("매입 매출 구분 다시 입력");
				continue;
			}
			break;
		}

		if (iolistDTO.getIo_inout().isEmpty())
			return;

		while (true) {

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String curDate = sd.format(date);

			System.out.printf("거래일자(%s) : ", curDate);
			String strDate = scan.nextLine();
			if (strDate.trim().isEmpty()) {
				iolistDTO.setIo_date(curDate);

			} else {
				try {
					sd.parse(strDate);
				} catch (ParseException e) {
					System.out.println("날짜 형식이 잘 못 됨");
					continue;
				}
				iolistDTO.setIo_date(strDate);
			}
			break;
		}
		while (true) {
			System.out.print("거래처 검색(-Q) : ");
			String strDName = scan.nextLine();
			if (strDName.equals("Q"))
				break;
			List<DeptDTO> dList = dDao.findByName(strDName);
			if (dList != null && dList.size() > 0) {

				for (DeptDTO ddto : dList) {
					System.out.println(ddto.toString());
				}
				System.out.println("-----------------------------------------------------");

				System.out.print(" 거래처 코드 : ");
				String strDCode = scan.nextLine();

				DeptDTO ddto = dDao.findById(strDCode);
				if (ddto == null) {
					System.out.println("거래처 코드 없음");
					continue;
				} else {
					iolistDTO.setIo_dcode(strDCode);
				}
			} else {
				continue;
			}
			break;
		}
		if (iolistDTO.getIo_dcode().isEmpty())
			return;

		while (true) {
			System.out.print("상품명 입력(-Q) : ");
			String strPName = scan.nextLine();
			if (strPName.equals("Q"))
				break;
			List<ProductDTO> pList = pDao.findByName(strPName);

			if (pList == null && pList.size() < 1) {
				System.out.println("찾는 상품 없음");
				continue;
			} else {
				for (ProductDTO pdto : pList) {
					System.out.println(pdto.toString());
				}
				System.out.print("상품코드 : ");
				String strPCode = scan.nextLine();
				proService.searchPName();
				ProductDTO pdto = pDao.findById(strPCode);
				if (pdto == null) {
					System.out.println("상품코드 확인");
					continue;
				} else {
					iolistDTO.setIo_pcode(strPCode);
					int intPrice = iolistDTO.getIo_inout().equals("매입") ? pdto.getP_iprice() : pdto.getP_oprice();
					iolistDTO.setIo_price(intPrice);
				}
			}
			break;
		}
		if (iolistDTO.getIo_pcode().isEmpty())
			return;
		while (true) {
			System.out.printf("단가입력(%d) : ", iolistDTO.getIo_price());
			String strPrice = scan.nextLine();
			try {
				int price = Integer.valueOf(strPrice);
				iolistDTO.setIo_price(price);
			} catch (Exception e) {
				System.out.println("숫자만 입력");
			}
			break;
		}
		while (true) {
			System.out.print("수량입력 : ");
			String strQty = scan.nextLine();
			try {
				int intQty = Integer.valueOf(strQty);
				iolistDTO.setIo_qty(intQty);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력");
				continue;
			}
			int intToal = iolistDTO.getIo_total() * iolistDTO.getIo_qty();
			iolistDTO.setIo_total(intToal);

			int ret = iDao.update(iolistDTO);
			if (ret > 0) {
				System.out.println("변경완료");
			} else {
				System.out.println("변경실패");
			}

			break;
		}

	}

}
