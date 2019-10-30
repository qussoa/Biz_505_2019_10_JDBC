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

public class IolistServiceV4 extends IolistServiceV1 {

	protected DeptServiceV3 deptService = new DeptServiceV3();
	protected ProductServiceV4 proService = new ProductServiceV4();

	@Override
	protected void delete() {
		System.out.println("===========================================");
		while (true) {
			System.out.print("삭제할 SEQ(0:종료) : ");
			String strSEQ = scan.nextLine();
			if (strSEQ.equals("0"))
				break;
			if (strSEQ.trim().isEmpty()) {
				ioView.viewAllList();
			}
			long longSEQ = 0;
			try {
				longSEQ = Long.valueOf(strSEQ);

			} catch (Exception e) {
				// TODO: handle exception
			}
			IolistVO ivo = vDao.findById(longSEQ);
			if (ivo == null) {
				System.out.println("삭제할 SEQ 없음");
				continue;
			}
			ioView.viewItem(ivo);
			System.out.println("삭제 Enter : 실행");
			String YesNo = scan.nextLine();
			if (YesNo.trim().isEmpty()) {
				int ret = iDao.delete(longSEQ);
				if (ret > 0) {
					System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패");
				}
			}
			break;
		}
	}

}
