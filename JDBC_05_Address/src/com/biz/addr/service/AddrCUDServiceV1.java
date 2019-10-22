package com.biz.addr.service;

import java.util.Scanner;

import com.biz.addr.dao.AddrDao;
import com.biz.addr.persistence.AddrDTO;
import com.biz.addr.persistence.AddrDaoImp;

public class AddrCUDServiceV1 {

	private AddrDao dao = null;
	private Scanner scan = null;

	public AddrCUDServiceV1() {
		scan = new Scanner(System.in);
		dao = new AddrDaoImp();
	}

	public void inputAddr() {
		while (true) {
			System.out.println("======================================");
			System.out.println("주소 등록");
			System.out.println("======================================");

			String strA_name = null;
			while (true) {
				System.out.print("1. 이름(0) : ");
				strA_name = scan.nextLine();
				if (strA_name.equals("0"))
					break;
				if (strA_name.isEmpty()) {
					System.out.println("이름을 반드시 입력");
					continue;
				}
				break;
			}
			if (strA_name.equals("0"))
				break;

			System.out.print("2. 전화번호(0) : ");
			String strA_tel = scan.nextLine();
			if (strA_tel.equals("0"))
				break;

			System.out.print("3. 주소(0) : ");
			String strA_addr = scan.nextLine();
			if (strA_addr.equals("0"))
				break;

			System.out.print("4. 관계(0) : ");
			String strA_chain = scan.nextLine();
			if (strA_chain.equals("0"))
				break;
			AddrDTO dto = AddrDTO.builder().a_name(strA_name).a_tel(strA_tel).a_addr(strA_addr).a_chain(strA_chain)
					.build();
			int ret = dao.insert(dto);
			if (ret > 0)
				System.out.println("주소저장완료");
			else
				System.out.println("주소저장실패");
		}

	}
	public void deleteAddr() {
		while(true) {
			System.out.println("======================================");
			System.out.print("삭제할 ID : ");
			String strID = scan.nextLine();
			if(strID.equals("0")) break;
			long longID = Long.valueOf(strID);
			
			AddrDTO dto = dao.findById(longID);
			if(dto == null) {
				System.out.println("ID 없음");
				continue;
			}
			dao.delete(longID);
		}
	}
	public void updateAddr() {
		System.out.println("======================================");
		System.out.println("주소 정보 수정");
		System.out.println("======================================");
		System.out.print("주소 정보 수정(0) : ");
		String strID = scan.nextLine();
		long longID = Long.valueOf(strID);

		AddrDTO dto = dao.findById(longID);
		
		System.out.printf("변경할 이름(%s)",dto.getA_name());
		String strName = scan.nextLine();
		if(strName.trim().length()>0) {
			dto.setA_name(strName.trim());
		}
		System.out.printf("변경할 전화번호(%s)",dto.getA_tel());
		String strTel = scan.nextLine();
		if(strTel.trim().length()>0) {
			dto.setA_tel(strTel.trim());
		}
		System.out.printf("변경할 주소(%s)",dto.getA_addr());
		String strAddr= scan.nextLine();
		if(strAddr.trim().length()>0) {
			dto.setA_addr(strAddr.trim());
		}
		System.out.printf("변경할 관계(%s)",dto.getA_chain());
		String strChain = scan.nextLine();
		if(strChain.trim().length()>0) {
			dto.setA_chain(strChain.trim());
		}
		dao.update(dto);
	}
}















