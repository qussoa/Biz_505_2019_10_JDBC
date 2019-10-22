package com.biz.oracle.exec;

import com.biz.oracle.service.BookCUDServiceV1;
import com.biz.oracle.service.BookServiceV1;

public class BookDeleteEx_02 {

	public static void main(String[] args) {

		BookServiceV1 bs = new BookServiceV1();
		BookCUDServiceV1 bc = new BookCUDServiceV1();
		
		bs.serchBookName();
		bc.deleteBook();
		bs.viewBookList();
	}
}
