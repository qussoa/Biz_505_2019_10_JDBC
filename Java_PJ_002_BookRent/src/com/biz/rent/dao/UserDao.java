package com.biz.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.rent.persistence.BookDTO;
import com.biz.rent.persistence.UserDTO;

public interface UserDao {

	public String getMaxUCode();

	public List<UserDTO> selectAll();
	public UserDTO findById(String u_code);
	public List<UserDTO> findByName(String u_name);
	public List<UserDTO> findByTel(String u_tel);
	public List<UserDTO> findByNameAndTel(
			@Param("u_name") String u_name,
			@Param("u_tel") String u_tel);
	public int insert(UserDTO udto);
	public int update(UserDTO udto);
	public int delete(String u_code);
}
