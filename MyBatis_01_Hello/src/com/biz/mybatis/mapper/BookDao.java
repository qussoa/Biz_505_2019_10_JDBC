package com.biz.mybatis.mapper;

import java.util.List;

import com.biz.mybatis.persistence.BookDTO;

public interface BookDao {
	
	public List<BookDTO> selectAll();

	public BookDTO findById(String b_code);
	
	public List<BookDTO> findByName(String b_name);

	public int insert(BookDTO dto);
	public int update(BookDTO dto);
	public int delete(String b_code);
}
