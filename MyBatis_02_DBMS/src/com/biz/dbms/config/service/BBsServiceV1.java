package com.biz.dbms.config.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.dbms.config.DBConnection;
import com.biz.dbms.config.dao.BBsDao;
import com.biz.dbms.config.persistence.BBsDTO;

public class BBsServiceV1 {

	SqlSession sqlSession = null;
	Scanner scan = null;

	public BBsServiceV1() {
		sqlSession = DBConnection.getSqlSessionFactory().openSession(true);

		scan = new Scanner(System.in);
	}

	public void bbsMenu() {
		while (true) {
			System.out.println("1.내용보기 2.작성 3.수정 4.삭제 5.종료(0)");
			String strMenu = scan.nextLine();
			int intMenu = 0;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				System.out.println("0또는 1~4까지 선택");
			}
			if(intMenu == 0) {
				return ;
			}else if(intMenu == 1){
				
			}else if(intMenu == 2){
				
			}else if(intMenu == 3){
				
			}else if(intMenu == 4){
				
			}
		}
	}

	public void writeBBS() {
		/*
		 * 작성일자와 시각은 자동생성 작성자, 제목, 내용 입력하지 않으면 다시 메시지를 보여주고 재입력 받도록 하기
		 */
		while (true) {
			System.out.print("작성자 : ");
			String strWriter = scan.nextLine();
			if (strWriter.equals("-Q"))
				break;
			if (strWriter.trim().length() < 1) {
				System.out.println("작성자 반드시 입력바람");
				continue;
			}

			System.out.print("제목 : ");
			String strSubject = scan.nextLine();
			if (strSubject.equals("-Q"))
				break;
			if (strSubject.trim().length() < 1) {
				System.out.println("제목 반드시 입력바람");
				continue;
			}

			System.out.print("내용 : ");
			String strText = scan.nextLine();
			if (strText.equals("-Q"))
				break;
			if (strText.trim().length() < 1) {
				System.out.println("내용 반드시 입력바람");
				continue;
			}

			Date date = new Date(System.currentTimeMillis());

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat tf = new SimpleDateFormat("HH:mm:SS");

			String curDate = df.format(date);
			String curTime = tf.format(date);

			BBsDTO bbsDTO = BBsDTO.builder().bs_date(curDate).bs_time(curTime).bs_writer(strWriter)
					.bs_subject(strSubject).bs_text(strText).build();
			BBsDao dao = sqlSession.getMapper(BBsDao.class);
			int ret = dao.insert(bbsDTO);

			if (ret > 0) {
				System.out.println("게시판 작성완료");
			} else {
				System.out.println("게시판 작성실패");
			}

			this.viewBBsList();

			System.out.print("계속작성?(Y/N) : ");
			String yesNo = scan.nextLine();
			if (yesNo.equals("N") || yesNo.equalsIgnoreCase("NO")) {
				break;
			}

		} // while end
	}// write end

	public void viewBBsList() {
		BBsDao dao = sqlSession.getMapper(BBsDao.class);
		List<BBsDTO> bbsList = dao.selectAll();
		System.out.println("======================================================");
		System.out.println("슈퍼 BBS V1");
		System.out.println("======================================================");
		System.out.println("작성일\t시각\t작성자\t제목");

		for (BBsDTO dto : bbsList) {
			System.out.print(dto.getBs_date() + "\t");
			System.out.print(dto.getBs_time() + "\t");
			System.out.print(dto.getBs_writer() + "\t");
			System.out.print(dto.getBs_subject() + "\n");

		}
		System.out.println("======================================================");

	}// viewBBsList end

}
