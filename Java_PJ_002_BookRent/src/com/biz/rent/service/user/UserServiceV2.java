package com.biz.rent.service.user;

public class UserServiceV2 extends UserServiceV1 {

	public void userMenu() {
		System.out.println("==============================================");
		System.out.println("회원 장부");
		System.out.println("==============================================");
		System.out.println("1.검색 2.등록 3.수정 4.삭제 0.종료");
		System.out.println("----------------------------------------------");
		System.out.print("업무선택 : ");
		String strMenu = scan.nextLine();
		int intMenu = -1;
		try {
			intMenu = Integer.valueOf(strMenu);
		
 		} catch (Exception e) {
			// TODO: handle exception
		}
		if(intMenu == 0) return;
		if(intMenu == 1) this.search();
		if(intMenu == 2) this.insert();
		if(intMenu == 3) this.update();
		if(intMenu == 4) this.delete();
	}

	protected void search() {
		// TODO Auto-generated method stub
		
	}

	protected void delete() {
		// TODO Auto-generated method stub
		
	}

	protected void update() {
		// TODO Auto-generated method stub
		
	}

	protected void insert() {
		// TODO Auto-generated method stub
		
	}
	
}
