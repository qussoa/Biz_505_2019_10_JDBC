package com.biz.oracle.exec;

import com.biz.oracle.service.BookCUDServiceV1;
import com.biz.oracle.service.BookServiceV1;

/*
 * 도서명을 입력받아서
 * 리스트를 보여주고
 * 수정할 도서코드를 입력받고
 * 해당하는 도서를 수정
 * 1. 각 항목을 보여주고
 * 	  새로운 값을 입력하면 수정
 * 	  그냥 Enter 입력하면 그대로 유지
 */
public class BookUpdateEx_01 {
	public static void main(String[] args) {

		BookServiceV1 bs = new BookServiceV1();
		BookCUDServiceV1 bc = new BookCUDServiceV1();
		String strName = bs.serchBookName();
		if(strName.equals("-Q")) {
			System.out.println("도서정보 변경 업무 종료");
		}else {
			bc.updateBook();
			
			bs.serchBookName(strName);
		}
		
		
	}
}
