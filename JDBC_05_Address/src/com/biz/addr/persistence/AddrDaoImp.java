package com.biz.addr.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.addr.config.DBContract;
import com.biz.addr.dao.AddrDao;

public class AddrDaoImp extends AddrDao {

	@Override
	public List<AddrDTO> selectAll() {
		
		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rst = pStr.executeQuery();
			
			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				AddrDTO dto = this.rst_2_dto(rst);
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	private AddrDTO rst_2_dto(ResultSet rst) throws SQLException {
		AddrDTO dto = AddrDTO.builder()
				.a_id(rst.getLong("A_ID"))
				.a_name(rst.getString("A_NAME"))
				.a_tel(rst.getString("A_TEL"))
				.a_addr(rst.getString("A_ADDR"))
				.a_chain(rst.getString("A_CHAIN"))
				.build();
		return dto;
	}

	@Override
	public AddrDTO findById(long a_id) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		sql += " WHERE a_id = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, a_id);
			ResultSet rst = pStr.executeQuery();
			
			AddrDTO dto = null;
			if(rst.next()) {
				dto = this.rst_2_dto(rst);
			}
			rst.close();
			pStr.close();
			return dto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddrDTO> findByName(String a_name) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		sql += " WHERE a_name LIKE '%' || ? || '%' ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, a_name);
			ResultSet rst = pStr.executeQuery();
			
			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				AddrDTO dto = this.rst_2_dto(rst);
				
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddrDTO> findByTel(String a_tel) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		sql += " WHERE a_name LIKE '%' || ? ";
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, a_tel);
			ResultSet rst = pStr.executeQuery();
			
			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				AddrDTO dto = this.rst_2_dto(rst);
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AddrDTO> findByChain(String a_chain) {

		PreparedStatement pStr = null;
		String sql = DBContract.SQL.SELECT_ADDR;
		sql += " WHERE a_name LIKE '%' || ? || '%' ";
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, a_chain);
			ResultSet rst = pStr.executeQuery();
			List<AddrDTO> addrList = new ArrayList<AddrDTO>();
			while(rst.next()) {
				AddrDTO dto = this.rst_2_dto(rst);
				addrList.add(dto);
			}
			rst.close();
			pStr.close();
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}
	@Override
	public int insert(AddrDTO dto) {

		PreparedStatement pStr = null;
		String sql = " INSERT INTO tbl_addr( ";
		sql += " A_ID,";
		sql += " A_NAME,";
		sql += " A_TEL,";
		sql += " A_ADDR,";
		sql += " A_CHAIN) ";
		sql += " VALUES(SEQ_ADDR.NEXTVAL,"
		+ "?,?,?,?) ";
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.getA_name());
			pStr.setString(2, dto.getA_tel());
			pStr.setString(3, dto.getA_addr());
			pStr.setString(4, dto.getA_chain());
			
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
	public int update(AddrDTO dto) {

		PreparedStatement pStr = null;
		String sql = " UPDATE tbl_addr SET ";
		sql += " A_NAME = ?, ";
		sql += " A_TEL = ?, ";
		sql += " A_ADDR = ?, ";
		sql += " A_CHAIN= ? ";
		sql += " WHERE A_ID = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.getA_name());
			pStr.setString(2, dto.getA_tel());
			pStr.setString(3, dto.getA_addr());
			pStr.setString(4, dto.getA_chain());
			pStr.setLong(5, dto.getA_id());
			
			int ret = pStr.executeUpdate();
			if(ret > 0) {
				System.out.println(" 주소 변경 성공 ");
			}else {
				System.out.println(" 주소 변경 실패 ");
			}
			pStr.close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public int delete(long a_id) {

		PreparedStatement pStr = null;
		String sql = " DELETE FROM tbl_addr ";
		sql += " WHERE a_id = ? ";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, a_id);
			
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





















