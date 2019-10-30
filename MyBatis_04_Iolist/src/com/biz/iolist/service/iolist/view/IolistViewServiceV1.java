package com.biz.iolist.service.iolist.view;

import java.util.List;

import com.biz.config.DBConnection;
import com.biz.iolist.dao.IolistViewDao;
import com.biz.iolist.persistence.IolistVO;

public class IolistViewServiceV1 {

	IolistViewDao ivDao;

	public IolistViewServiceV1() {
		ivDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(IolistViewDao.class);
	}
	
	protected void viewList(List<IolistVO> iolist) {
		System.out.println("==========================================================");
		System.out.println("매입매출정보");
		System.out.println("==========================================================");
		System.out.println("SEQ\t거래일자\t구분\t거래처\t상품\t수량\t단가\t합계");
		System.out.println("----------------------------------------------------------");
		for (IolistVO vo : iolist) {
			this.viewItem(vo);
		}
		System.out.println("==========================================================");
	}
	
	public void viewItem(IolistVO vo) {
		System.out.print(vo.getIo_seq()+ "\t");
		System.out.print(vo.getIo_date() + "\t");
		System.out.print(vo.getIo_inout() + "\t");
		System.out.printf("(%s)%s\t", vo.getIo_dcode(), vo.getD_name());
		System.out.printf("(%s)%s\t", vo.getIo_pcode(), vo.getP_name());
		System.out.print(vo.getIo_qty() + "\t");
		System.out.print(vo.getIo_price() + "\t");
		System.out.print(vo.getIo_total() + "\n");		
	}

	public void viewAllList() {
		List<IolistVO> iolist = ivDao.selectAll();
		if (iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}

	}
	// 상품코드 매개 리스트 출력
	public void viewListByPCode(String pcode) {
		List<IolistVO> iolist = ivDao.findByPCode(pcode);
		if (iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}
	// 상품이름 리스트 출력
	public void viewListByPName(String pname) {
		List<IolistVO> iolist = ivDao.findByPName(pname);
		if (iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}
	// 거래처코드 리스트 출력
	public void viewListByDCode(String dcode) {
		List<IolistVO> iolist = ivDao.findByDCode(dcode);
		if (iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}
	// 거래처명 리스트 출력
	public void viewListByDName(String dname) {
		List<IolistVO> iolist = ivDao.findByDName(dname);
		if (iolist != null && iolist.size() > 0) {
			this.viewList(iolist);
		}
	}
	
}

















