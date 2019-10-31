package com.biz.rent.service.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.rent.config.DBConnection;
import com.biz.rent.dao.BookDao;
import com.biz.rent.persistence.BookDTO;

public class BookServiceV1 {

	BookDao bDao;
	Scanner scan;
	BookDTO dto;
	List<BookDTO> bList = null;

	public BookServiceV1() {
		bDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(BookDao.class);
		scan = new Scanner(System.in);
		bList = new ArrayList<BookDTO>();
	}

	public void viewAllList() {
		List<BookDTO> bList = bDao.selectAll();
		if (bList == null || bList.size() < 1) {
			System.out.println("리스트가 없음");
		} else {
			this.viewList(bList);
		}
	}

	public void viewNameList() {
		System.out.println("==================================");
		System.out.print("도서명 : ");
		String strName = scan.nextLine();
		if (strName.trim().isEmpty()) {
			bList = bDao.selectAll();
		} else {
			bList = bDao.findByName(strName);
		}
		this.viewList(bList);
	}

	public void viewNameAndAuther() {
		System.out.println("==================================");
		System.out.print("도서명 : ");
		String strName = scan.nextLine();

		System.out.print("저자 : ");
		String strAut = scan.nextLine();
		if (strName.trim().isEmpty() && strAut.trim().isEmpty()) {
			bList = bDao.selectAll();
		} else if (strName.trim().isEmpty()) {
			bList = bDao.findByAuther(strAut);
		} else if (strAut.trim().isEmpty()) {
			bList = bDao.findByName(strName);
		} else {
			bList = bDao.findByNameAndAuther(strName, strAut);
		}
		this.viewList(bList);

	}

	public void viewList(List<BookDTO> bdto) {
		System.out.println("=========================================================");
		System.out.println("도서 정보");
		System.out.println("=========================================================");
		System.out.println("코드\t도서명\t저자\t출판사\t출판일\t가격\t대여비");
		System.out.println("---------------------------------------------------------");
		for (BookDTO dto : bList) {
			this.viewList(dto);
		}
		System.out.println("=========================================================");
	}

	public void viewList(BookDTO dto) {
		System.out.print(dto.getB_code() + "\t");
		System.out.print(dto.getB_name() + "\t");
		System.out.print(dto.getB_auther() + "\t");
		System.out.print(dto.getB_comp() + "\t");
		System.out.print(dto.getB_year() + "\t");
		System.out.print(dto.getB_iprice() + "\t");
		System.out.print(dto.getB_rprice() + "\n");
	}

	public void viewDetail(BookDTO dto) {
		System.out.println("==============================================");
		System.out.print("코드 : " + dto.getB_code());
		System.out.print("도서명 : " + dto.getB_name());
		System.out.print("저자 : " + dto.getB_auther());
		System.out.print("출판사 : " + dto.getB_comp());
		System.out.print("출판일 : " + dto.getB_year());
		System.out.print("가격 : " + dto.getB_iprice());
		System.out.print("대여비 : " + dto.getB_rprice());
		System.out.println("==============================================");

	}

	public BookDTO viewDetail(String strBCode) {
		BookDTO dto = bDao.findById(strBCode);
		if (dto == null)
			return null;
		System.out.println("==============================================");
		System.out.print("코드 : " + dto.getB_code());
		System.out.print("도서명 : " + dto.getB_name());
		System.out.print("저자 : " + dto.getB_auther());
		System.out.print("출판사 : " + dto.getB_comp());
		System.out.print("출판일 : " + dto.getB_year());
		System.out.print("가격 : " + dto.getB_iprice());
		System.out.print("대여비 : " + dto.getB_rprice());
		System.out.println("==============================================");
		return dto;
	}

}
