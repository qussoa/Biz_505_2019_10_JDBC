package com.biz.dbms.config.dao;

import java.util.List;

import com.biz.dbms.config.persistence.BBsDTO;

public interface BBsDao {

	public List<BBsDTO> selectAll();
	public BBsDTO findById(long bs_id);
	public int insert(BBsDTO dto);
	public int update(BBsDTO dto);
	public int delete(long bs_id);
	
}
