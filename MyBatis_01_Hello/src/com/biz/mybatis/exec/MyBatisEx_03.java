package com.biz.mybatis.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.mybatis.config.DBConnection;
import com.biz.mybatis.mapper.BookDao;
import com.biz.mybatis.persistence.BookDTO;

public class MyBatisEx_03 {

	public static void main(String[] args) {

		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);

		BookDao bookDao = sqlSession.getMapper(BookDao.class);

		BookDTO dto = BookDTO.builder()
				.b_name("MyBATIS")
				.b_comp("경영원")
				.b_writer("박지민")
				.b_price(10000)
				.build();
		bookDao.insert(dto);
		
		List<BookDTO> booklist = bookDao.selectAll();
		
		for (BookDTO dtos : booklist) {
			System.out.println(dto.toString());
		}
	}
}
