package com.biz.mybatis.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.mybatis.config.DBConnection;
import com.biz.mybatis.mapper.BookDao;
import com.biz.mybatis.persistence.BookDTO;

public class MyBatisEx_04 {

	public static void main(String[] args) {

		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);

		BookDao bookDao = sqlSession.getMapper(BookDao.class);

		String[] codes = { "B0041", "B0042", "B0043", "B0044", "B0045" };
		for (String code : codes) {
			BookDTO dto = BookDTO.builder()
					.b_code(code)
					.b_name(code + "-" + (int) (Math.random() * 100))
					.b_comp("경영원")
					.b_writer("박지민")
					.b_price(10000)
					.build();
			bookDao.update(dto);
		}

		List<BookDTO> booklist = bookDao.selectAll();

		for (BookDTO dtos : booklist) {
			System.out.println(dtos.toString());
		}
	}
}
