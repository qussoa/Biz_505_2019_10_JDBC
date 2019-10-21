package com.biz.oracle.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.oracle.config.DBContract;
import com.biz.oracle.dao.BookDao;

public class BookDaoImp extends BookDao {

	@Override
	public List<BookDTO> selectAll() {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_BOOKS;

		try {
			// sql 문자열을 JDBC 드라이버를 통해
			// DBMS로 전송하기 위한 데이터형으로 변환하는 절차
			pStr = dbConn.prepareStatement(sql);
			ResultSet rst = pStr.executeQuery();

			List<BookDTO> bookList = new ArrayList<BookDTO>();
			// DBMS에게 보낸 SQL을 실행하여
			// 얻어진 결과를 나에게 달라
			// DBMS가 보낸 결과를 ResultSet에 받기

			// rst가 받은 데이터가 최소 1개의 recode 이상이면
			// rst.next() method는 결과값이 true가 되고
			// rst 내부에서는 recode를 추출할 수 있도록 준비 상태가 된다

			// 반복문내에서 rst.next()를 실행하여
			// 읽을 recode가 있는가 검사하고
			// 잇으면 while(){}내의 코드를 실행하여
			// 값을 추출
			while (rst.next()) {
				// rst로부터 각 칼럼별로 데이터를 추출
				// 추출한 데이터를 DTO에- 담고
				// DTO를 List에추가

				BookDTO dto = this.rst_2_dto(rst);

				bookList.add(dto);
			}
			rst.close();
			pStr.close();
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private BookDTO rst_2_dto(ResultSet rst) throws SQLException {
		BookDTO dto = BookDTO.builder().b_code(rst.getString("B_CODE")).b_name(rst.getString("B_NAME"))
				.b_comp(rst.getString("B_COMP")).b_writer(rst.getString("B_WRITER")).b_price(rst.getInt("B_PRICE"))
				.build();

		return dto;
	}

	@Override
	public BookDTO findById(String b_code) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_BOOKS;
		sql += " WHERE b_code = ? ";

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, b_code);
			ResultSet rst = pStr.executeQuery();

			BookDTO bookDTO = null;
			if (rst.next()) {
				bookDTO = this.rst_2_dto(rst);
			}
			rst.close();
			pStr.close();
			return bookDTO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookDTO> findByName(String b_name) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_BOOKS;
		sql += " WHERE b_name LIKE '%' || ? || '%' ";

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, b_name);
			ResultSet rst = pStr.executeQuery();

			List<BookDTO> bookList = new ArrayList<BookDTO>();
			while (rst.next()) {
				BookDTO dto = this.rst_2_dto(rst);

				bookList.add(dto);
			}
			rst.close();
			pStr.close();
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<BookDTO> findByComp(String b_comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByWriter(String b_writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByPrice(int sprice, int eprice) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_BOOKS;
		sql += " WHERE b_price BETWEEN ? and ? ";

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setInt(1, sprice);
			pStr.setInt(2, eprice);

			ResultSet rst = pStr.executeQuery();
			List<BookDTO> bookList = new ArrayList<BookDTO>();

			while (rst.next()) {
				bookList.add(this.rst_2_dto(rst));
			}
			rst.close();
			pStr.close();
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insert(BookDTO bookDTO) {

		PreparedStatement pStr = null;
		String sql = " INSERT INTO tbl_books( ";
		sql += "	B_CODE,";
		sql += "	B_NAME,";
		sql += "	B_COMP,";
		sql += "	B_WRITER,";
		sql += "	B_PRICE)";
		sql += " VALUES(" + " 'B' || LPAD(SEQ_BOOKS.NEXTVAL,4,'0')," + "?," + "?," + "?," + "?) ";

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bookDTO.getB_name());
			pStr.setString(2, bookDTO.getB_comp());
			pStr.setString(3, bookDTO.getB_writer());
			pStr.setInt(4, bookDTO.getB_price());

			int ret = pStr.executeUpdate();

			pStr.close();
			return ret;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(BookDTO bookDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String b_code) {

		PreparedStatement pStr = null;
		String sql = " DELETE FROM tbl_books ";
		sql += " WHERE b_code = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, b_code);
			
			int ret = pStr.executeUpdate();
			
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
