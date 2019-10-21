package com.biz.oracle.service;

import java.util.List;
import java.util.Scanner;

import com.biz.oracle.dao.BookDao;
import com.biz.oracle.persistence.BookDTO;
import com.biz.oracle.persistence.BookDaoImp;

public class BookServiceV1 {

	// 객체 선언(아직 준비단계)
	BookDao bookDao = null;
	Scanner scan = null;

	// 클래스 생선자
	public BookServiceV1() {

		// 선언된 객체를 사용할 수 있도록 초기화
		// 초기화된 클래스 = 인스턴스(화되었다)
		scan = new Scanner(System.in);
		bookDao = new BookDaoImp();

	}

	/*
	 * 도서 정보 전체 리스트를 DB로부터 읽어서 console 보이기
	 */
	public void viewBookList() {
		// dao의 selectAll() method를 호출하여
		// 전체 리스트를 DB로부터 가져와서 bookList에 받기
		List<BookDTO> bookList = bookDao.selectAll();
		// bookList에는 전체 리스트가 담겨있을 것
		// viewList() 전체리스트를 콘솔에 보일것이다
		this.viewList(bookList);

	}

	/*
	 * bookList를 매개변수로 받아서 console에 보이기
	 */
	private void viewList(List<BookDTO> bookList) {
		System.out.println("====================================");
		System.out.println("전체 도서 리스트 v1");
		System.out.println("====================================");
		System.out.println("코드\t도서명\t출판사\t저자\t가격");
		System.out.println("------------------------------------");
		for (BookDTO dto : bookList) {
			System.out.printf("%s\t", dto.getB_code());
			System.out.printf("%s\t", dto.getB_name());
			System.out.printf("%s\t", dto.getB_comp());
			System.out.printf("%s\t", dto.getB_writer());
			System.out.printf("%s\n", dto.getB_price());
		}
		System.out.println("====================================");

	}

	// 키보드에서 도서이름을 입력받아 리스트를 콘솔에 보이기
	public void serchBookName(boolean bConti) {

		while (true) {
			if(this.serchBookName()) break;
		}
	}

	public boolean serchBookName() {

		System.out.println("====================================");
		System.out.println("도서검색");
		System.out.println("====================================");
		System.out.print("도서명(-Q:quit) : ");
		String strName = scan.nextLine();
		if (strName.equals("-Q"))
			return true;
		List<BookDTO> bookList = bookDao.findByName(strName);

		if (bookList == null || bookList.size() < 1) {
			System.out.println("찾는 도서명이 없음");
			return false;
		}
		this.viewList(bookList);
		return true;
	}

	public void serchBookPrice() {

		while (true) {
			System.out.println("====================================");
			System.out.println("도서가격검색");
			System.out.println("====================================");

			try {
				System.out.print("시작가격(-Q:quit) : ");
				String strSPrice = scan.nextLine();
				if (strSPrice.equals("-Q"))
					break;
				int sPrice = Integer.valueOf(strSPrice);
				System.out.print("종료가격(-Q:quit) : ");
				String strEPrice = scan.nextLine();
				if (strEPrice.equals("-Q"))
					break;
				int eprice = Integer.valueOf(strEPrice);

				List<BookDTO> bookList = bookDao.findByPrice(sPrice, eprice);

				this.viewList(bookList);

			} catch (Exception e) {
				System.out.println("가격은 숫자로만 입력하시오");
			}
		}
	}

}
