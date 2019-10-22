package com.biz.addr.dao;

import java.sql.Connection;
import java.util.List;

import com.biz.addr.config.DBConnection;
import com.biz.addr.persistence.AddrDTO;

public abstract class AddrDao {

	protected Connection dbConn = null;
	
	public AddrDao() {
		this.dbConn = DBConnection.getDBConnection();
	}
	public abstract List<AddrDTO> selectAll();
	public abstract AddrDTO findById(long a_id);
	public abstract List<AddrDTO> findByName(String a_name);
	public abstract List<AddrDTO> findByTel(String a_tel);
	public abstract List<AddrDTO> findByChain(String a_chain);
	
	public abstract int insert(AddrDTO dto);
	public abstract int update(AddrDTO dto);
	public abstract int delete(long a_id);
	
}
