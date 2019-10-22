package com.biz.oracle.dao;

import java.sql.Connection;
import java.util.List;

import com.biz.oracle.config.DBConnection;
import com.biz.oracle.persistence.BookDTO;

/*
 * 추상클래스 선언
 * tbl_books 테이블의 CRUD 구현
 * 
 */
public abstract class BookDao {

	protected Connection dbConn = null;
	public BookDao() {
		this.dbConn = DBConnection.getDBConnection();
	}
	/*b_code : PK 기준으로 값검색 findByid(String b_code)
	 *b_name : findByName(String b_name)
	 *b_comp : findByComp(String b_comp)
	 *b_writer : findByWriter(String b_writer)
	 *b_price : findByPrice(int price)
	 *			findByPrice(int sprice, int eprice)
	 */
	
	// 전체조회
	public abstract List<BookDTO> selectAll();
	
	//PK 기준
	public abstract BookDTO findById(String b_code);
	public abstract List<BookDTO>findByName(String b_name);
	public abstract List<BookDTO> findByComp(String b_comp);
	public abstract List<BookDTO> findByWriter(String b_writer);
	
	// 값이 일치하는 도서 리스트
	public abstract List<BookDTO> findByPrice(int price);
	
	// 값의 범위에 들어있는 도서 리스트
	public abstract List<BookDTO> findByPrice(int sprice, int eprice);
	
	public abstract int insert(BookDTO bookDTO);
	public abstract int update(BookDTO bookDTO);
	public abstract int delete(String b_code);
}
