package com.biz.rent.dao;

import java.util.List;

import com.biz.rent.persistence.RentBookDTO;
import com.biz.rent.persistence.UserDTO;

public interface RentBookDao {

	public List<RentBookDTO> rentYN();	
	public List<RentBookDTO> selectAll();
	public RentBookDTO findById(long rent_seq);
	public List<RentBookDTO> findByBCode(String rent_bcode);
	public List<RentBookDTO> findByUCode(String rent_ucode);
	
	public int insert(RentBookDTO rdto);
	public int update(RentBookDTO rdto);
}
