package com.biz.addr.service;

import java.util.List;
import java.util.Scanner;

import com.biz.addr.dao.AddrDao;
import com.biz.addr.persistence.AddrDTO;
import com.biz.addr.persistence.AddrDaoImp;

public class AddrServiceV1 {

	AddrDao addrDao = null;
	Scanner scan = null;

	public AddrServiceV1() {

		addrDao = new AddrDaoImp();
		scan = new Scanner(System.in);
	}

	public void viewAddrList() {
		List<AddrDTO> addrList = addrDao.selectAll();
		this.viewList(addrList);
	}

	private void viewList(List<AddrDTO> addrList) {
		System.out.println("======================================");
		System.out.println("주소록");
		System.out.println("======================================");
		System.out.println("ID\t이름\t전화번호\t주소\t관계");
		System.out.println("--------------------------------------");
		for (AddrDTO dto : addrList) {
			System.out.printf("%s\t", dto.getA_id());
			System.out.printf("%s\t", dto.getA_name());
			System.out.printf("%s\t", dto.getA_tel());
			System.out.printf("%s\t", dto.getA_addr());
			System.out.printf("%s\n", dto.getA_chain());
		}
		System.out.println("======================================");
	}

	public void serchAddrName(boolean aConti) {
		while (true) {
			if (this.serchAddrName() != null)
				break;
		}
	}

	public String serchAddrName() {
		System.out.println("======================================");
		System.out.println();
		System.out.println("======================================");
		System.out.print("이름(0: 종료) : ");
		String strName = scan.nextLine();
		if (strName.equals("0"))
			return "0";
		this.serchAddrName(strName);
		return strName;
	}

	public boolean serchAddrName(String strName) {

		List<AddrDTO> addrList = addrDao.findByName(strName);
		if (addrList == null || addrList.size() < 1) {
			System.out.println("찾는 이름 없음");
			return false;
		}
		this.viewList(addrList);
		return true;
	}
	
	public void serchAddrTel(boolean aConti) {
		while (true) {
			if (this.serchAddrTel() != null)
				break;
		}
	}
	public String serchAddrTel() {
		while(true) {
			System.out.println("======================================");
			System.out.println();
			System.out.println("======================================");
			System.out.print("전화번호(0: 종료) : ");
			String strTel = scan.nextLine();
			if(strTel.equals("0")) 
				return "0";
			this.serchAddrTel(strTel);
			
		}
	}
	public boolean serchAddrTel(String strTel) {

		List<AddrDTO> addrList = addrDao.findByTel(strTel);
		if (addrList == null || addrList.size() < 1) {
			System.out.println("찾는 번호 없음");
			return false;
		}
		this.viewList(addrList);
		return true;
	}
	public void serchAddrChain(boolean aConti) {
		while (true) {
			if (this.serchAddrChain() != null)
				break;
		}
	}
	public String serchAddrChain() {
		while(true) {
			System.out.println("======================================");
			System.out.println();
			System.out.println("======================================");
			System.out.print("관계(0: 종료) : ");
			String strChain = scan.nextLine();
			if(strChain.equals("0")) 
				return "0";
			this.serchAddrTel(strChain);
			
		}
	}
	public boolean serchAddrChain(String strChain) {

		List<AddrDTO> addrList = addrDao.findByChain(strChain);
		if (addrList == null || addrList.size() < 1) {
			System.out.println("관계 없음");
			return false;
		}
		this.viewList(addrList);
		return true;
	}
}
