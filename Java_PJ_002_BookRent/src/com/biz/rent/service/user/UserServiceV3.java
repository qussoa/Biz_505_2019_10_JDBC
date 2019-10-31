package com.biz.rent.service.user;

import java.util.List;

import com.biz.rent.persistence.BookDTO;
import com.biz.rent.persistence.UserDTO;

public class UserServiceV3 extends UserServiceV2 {

	public void search() {
		System.out.print("회원명(Enter) : ");
		String strName = scan.nextLine();

		List<UserDTO> uList = null;
		if (strName.trim().isEmpty()) {
			uList = uDao.selectAll();
		} else {
			uList = uDao.findByName(strName);
		}
		for (UserDTO dto : uList) {

			this.viewDetail(dto);
}
	}
	public void insert() {
		System.out.println("==============================================");
		String strUcode;
		while (true) {
			System.out.println("회원코드(자동생성 : Enter)");
			strUcode = scan.nextLine();
			if (strUcode.equals("0"))
				break;
			if (strUcode.trim().isEmpty()) {
				String strTMUCode = uDao.getMaxUCode();
				int intUCode = Integer.valueOf(strTMUCode.substring(1));
				intUCode++;
				strUcode = strTMUCode.substring(0, 1);
				strUcode += String.format("%05d", intUCode);

				System.out.println("생성된 코드 : " + strUcode);
				System.out.print("사용하려면 Enter");
				String strYesNo = scan.nextLine();
				if (strYesNo.trim().isEmpty())
					break;
				else
					continue;
			}
			if (strUcode.length() != 6) {
				System.out.println("회원코드는 6자리");
				continue;
			}
			strUcode = strUcode.toUpperCase();
			if (strUcode.substring(0, 1).equalsIgnoreCase("S")) {
				System.out.println("도서 코드는 U");
				continue;
			}
			try {
				Integer.valueOf(strUcode.substring(1));
			} catch (Exception e) {
				System.out.println("도서코드 두번째부터 숫자");
				continue;
			}
			if (uDao.findById(strUcode) != null) {
				System.out.println("이미 등록됨");
				continue;
			}
			break;
		}
		if (strUcode.equals("0"))
			return;

		while (true) {
			System.out.print("회원명(0: 종료) : ");
			String strUName = scan.nextLine();
			if (strUName.trim().isEmpty()) {
				System.out.println("도서명 입력");
				continue;
			}
			System.out.print("전화번호(0: 종료) : ");
			String strTel = scan.nextLine();
			if (strTel.trim().isEmpty()) {
				System.out.println("전화번호 입력");
				continue;
			}
			System.out.print("주소(0: 종료) : ");
			String strUAddr = scan.nextLine();
			if (strUAddr.trim().isEmpty()) {
				System.out.println("주소 입력");
				continue;
			}
			UserDTO udto = UserDTO.builder().u_code(strUcode).u_name(strUName).u_tel(strTel).u_addr(strUAddr).build();
			int ret = uDao.insert(udto);
			if (ret > 0) {
				System.out.println("입력완료");
			} else {
				System.out.println("입력실패");
			}
			break;
		}
	}

	public void update() {
		System.out.println("==============================================");
		System.out.print("수정할 코드 : ");
		String strUCode = scan.nextLine();
		strUCode.toUpperCase();

		UserDTO udto = this.viewDetail(strUCode);
		System.out.print("회원명 : ");
		String strUName = scan.nextLine();
		if (!strUName.trim().isEmpty()) {
			udto.setU_name(strUName);
		}
		System.out.print("전화번호 : ");
		String strUTel = scan.nextLine();
		if (!strUTel.trim().isEmpty()) {
			udto.setU_tel(strUName);
		}
		System.out.print("주소 : ");
		String strUAddr = scan.nextLine();
		if (!strUAddr.trim().isEmpty()) {
			udto.setU_addr(strUAddr);
		}
		int ret = uDao.update(udto);
		if (ret > 0) {
			System.out.println("변경완료");
		} else {
			System.out.println("변경실패");
		}
	}

	public void delete() {
		System.out.println("==============================================");
		while (true) {
			System.out.println("삭제할 회원코드 : ");
			String strUCode = scan.nextLine();
			if (strUCode.equals("0"))
				break;
			UserDTO udto = uDao.findById(strUCode);
			if (udto == null) {
				System.out.println("삭제할 코드 없음");
				continue;
			}
			this.viewDetail(udto);
			System.out.println("삭제 Enter");
			String YesNO = scan.nextLine();
			if (YesNO.trim().isEmpty()) {
				int ret = uDao.delete(strUCode);
				if (ret > 0) {
					System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패");
				}
			}
		}
	}
}
