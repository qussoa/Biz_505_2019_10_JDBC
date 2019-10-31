package com.biz.rent.service.rent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.rent.config.DBConnection;
import com.biz.rent.dao.BookDao;
import com.biz.rent.dao.RentBookDao;
import com.biz.rent.dao.UserDao;
import com.biz.rent.persistence.BookDTO;
import com.biz.rent.persistence.RentBookDTO;
import com.biz.rent.service.books.BookServiceV3;
import com.biz.rent.service.user.UserServiceV3;

public class RentBookServiceV1 {

	protected BookDao bDao;
	protected UserDao uDao;
	protected RentBookDao rDao;
	Scanner scan;
	
	protected BookServiceV3 bs;
	protected UserServiceV3 us;
	
	List<BookDTO> bList;
	BookDTO bdto;
	RentBookDTO rdto;
	
	public RentBookServiceV1() {
		
		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);
		this.bDao = sqlSession.getMapper(BookDao.class);
		this.uDao = sqlSession.getMapper(UserDao.class);
		this.rDao = sqlSession.getMapper(RentBookDao.class);
		
		bs = new BookServiceV3();
		us = new UserServiceV3();
		scan = new Scanner(System.in);
		bList = new ArrayList<BookDTO>();
	}
	public void rentMenu() {
		while (true) {
			System.out.println("==========================================================");
			System.out.println("빛고을 도서관 v1");
			System.out.println("==========================================================");
			System.out.println("1.도서검색 2.회원검색 3.대출 4.반납  0.종료");
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
				bs.search();
			if (intMenu == 2)
				us.search();
			if (intMenu == 3)
				this.insert();
			if (intMenu == 4)
				bs.search();
				this.update();
		}
	}
	private void update() {
		// TODO Auto-generated method stub
		
	}
	private void insert() {
		// TODO Auto-generated method stub
		
	}
	
	
}
