package com.biz.iolist.service.iolist;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.config.DBConnection;
import com.biz.iolist.dao.DeptDao;
import com.biz.iolist.dao.IolistDao;
import com.biz.iolist.dao.IolistViewDao;
import com.biz.iolist.dao.ProductDao;
import com.biz.iolist.persistence.IolistVO;
import com.biz.iolist.service.iolist.view.IolistViewServiceV1;

public class IolistServiceV1 {

	protected IolistDao iDao;
	protected DeptDao dDao;
	protected ProductDao pDao;
	protected IolistViewDao vDao;
	Scanner scan;

	protected IolistViewServiceV1 ioView;

	public IolistServiceV1() {

		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);
		this.iDao = sqlSession.getMapper(IolistDao.class);
		this.pDao = sqlSession.getMapper(ProductDao.class);
		this.dDao = sqlSession.getMapper(DeptDao.class);
		this.vDao = sqlSession.getMapper(IolistViewDao.class);

		ioView = new IolistViewServiceV1();

		scan = new Scanner(System.in);
	}

	public void iolistMenu() {
		while (true) {
			System.out.println("==========================================================");
			System.out.println("헌나라 마트 매입매출 관리 v1");
			System.out.println("==========================================================");
			System.out.println("1.등록 2.수정 3.삭제 4.검색 0.종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("업무선택 : ");
			String strMenu = scan.nextLine();

			int intMenu = -1;
			try {
				intMenu = Integer.valueOf(strMenu);
		

			} catch (Exception e) {
				// TODO: handle exception
			}
			if (intMenu == 0)
				break;
			if (intMenu == 1)
				this.insert();
			if (intMenu == 2)
				this.update();
			if (intMenu == 3)
				this.delete();
			if (intMenu == 4)
				this.serch();
		}
	}

	protected void serch() {
		// TODO 매입매출검색
	}

	protected void delete() {
		// TODO 매입매출삭제

	}

	protected void update() {
		// TODO 매입매출수정

	}

	protected void insert() {
		// TODO 매입매출등록

	}
}