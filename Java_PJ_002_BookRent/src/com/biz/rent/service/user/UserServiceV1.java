package com.biz.rent.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.rent.config.DBConnection;
import com.biz.rent.dao.UserDao;
import com.biz.rent.persistence.BookDTO;
import com.biz.rent.persistence.UserDTO;

public class UserServiceV1 {

	UserDao uDao;
	Scanner scan;
	List<UserDTO> uList;

	public UserServiceV1() {

		uDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(UserDao.class);
		scan = new Scanner(System.in);
		uList = new ArrayList<UserDTO>();
	}

	public void viewAllList() {
		List<UserDTO> uList = uDao.selectAll();
		if (uList == null || uList.size() < 1) {
			System.out.println("리스트 없음");
		} else {
			this.viewList(uList);
		}
	}

	public void viewNameList() {
		System.out.println("==================================");
		System.out.print("회원명 : ");
		String strUName = scan.nextLine();
		if (strUName.trim().isEmpty()) {
			uList = uDao.selectAll();
		} else {
			uList = uDao.findByName(strUName);
		}
		this.viewList(uList);
	}

	public void viewNameAndTel() {
		System.out.println("==================================");
		System.out.print("회원명 ; ");
		String strUName = scan.nextLine();
		System.out.print("전화번호 : ");
		String strTel = scan.nextLine();
		if (strUName.trim().isEmpty() && strTel.trim().isEmpty()) {
			uList = uDao.selectAll();
		} else if (strUName.trim().isEmpty()) {
			uList = uDao.findByTel(strTel);
		} else if (strTel.trim().isEmpty()) {
			uList = uDao.findByName(strUName);
		} else {
			uList = uDao.findByNameAndTel(strUName, strTel);
		}
		this.viewList(uList);
	}

	public void viewList(List<UserDTO> uList) {
		System.out.println("=========================================");
		System.out.println("회원 정보");
		System.out.println("=========================================");
		System.out.println("코드\t회원명\t전화번호\t주소");
		System.out.println("------------------------------------------");
		for (UserDTO udto : uList) {
			this.viewList(udto);
		}
		System.out.println("=========================================");

	}

	public void viewList(UserDTO udto) {
		System.out.print(udto.getU_code()+ "\t");
		System.out.print(udto.getU_name()+ "\t");
		System.out.print(udto.getU_tel()+ "\t");
		System.out.print(udto.getU_addr()+ "\n");		
	}

	public void viewDetail(UserDTO dto) {
		System.out.println("==============================================");
		System.out.print("코드 : " + dto.getU_code());
		System.out.print("회원명 : " + dto.getU_name());
		System.out.print("전화번호 : " + dto.getU_tel());
		System.out.print("주소 : " + dto.getU_addr());
		System.out.println("==============================================");

	}

	public UserDTO viewDetail(String strUcode) {
		UserDTO udto = uDao.findById(strUcode);
		if(udto == null) return null;
		System.out.println("==============================================");
		System.out.print("코드 : " + udto.getU_code());
		System.out.print("회원명 : " + udto.getU_name());
		System.out.print("전화번호 : " + udto.getU_tel());
		System.out.print("주소 : " + udto.getU_addr());
		System.out.println("==============================================");
		return udto;
	}
}
