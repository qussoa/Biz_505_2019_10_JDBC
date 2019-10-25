package com.biz.dbms.config.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.biz.dbms.config.DBConnection;
import com.biz.dbms.config.dao.BBsDao;
import com.biz.dbms.config.persistence.BBsDTO;

public class BBsServiceV2 {

	SqlSession sqlSession = null;
	Scanner scan = null;

	public BBsServiceV2() {
		sqlSession = DBConnection.getSqlSessionFactory().openSession(true);

		scan = new Scanner(System.in);
	}

	public void bbsMenu() {
		while (true) {
			System.out.println("내용보기(SQ선택) W.작성 U.수정 D.삭제 Q.종료(0)");
			System.out.print("선택 : ");
			String strMenu = scan.nextLine();
			System.out.println("======================================================");

			if (strMenu.equalsIgnoreCase("Q")) {
				return;
			} else if (strMenu.equalsIgnoreCase("Q")) {
				this.viewBBsList();
			} else if (strMenu.equalsIgnoreCase("W")) {
				this.writeBBS();
				this.viewBBsList();
			} else if (strMenu.equalsIgnoreCase("U")) {

			} else if (strMenu.equalsIgnoreCase("D")) {

			} else {
				try {
					long intSEQ = Integer.valueOf(strMenu);
					this.viewText(intSEQ);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void viewText(long bs_id) {
		BBsDao dao = sqlSession.getMapper(BBsDao.class);
		BBsDTO dto = dao.findById(bs_id);

		if (dto == null) {
			System.out.println("내용이 없음");
		} else {
			System.out.println("제목 : " + dto.getBs_subject());
			System.out.println("작성자 : " + dto.getBs_writer());
			System.out.println("작성일 : " + dto.getBs_date());
			System.out.println("작성시각 : " + dto.getBs_time());
			System.out.println(dto.getBs_text());
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
			break;

		} // while end
	}// write end

	public void viewBBsList() {
		BBsDao dao = sqlSession.getMapper(BBsDao.class);
		List<BBsDTO> bbsList = dao.selectAll();
		System.out.println("======================================================");
		System.out.println("슈퍼 BBS V1");
		System.out.println("======================================================");
		System.out.println("SQ\t작성일\t\t시각\t\t작성자\t제목");

		for (BBsDTO dto : bbsList) {
			System.out.print(dto.getBs_id() + "\t");
			System.out.print(dto.getBs_date() + "\t");
			System.out.print(dto.getBs_time() + "\t");
			System.out.print(dto.getBs_writer() + "\t");
			System.out.print(dto.getBs_subject() + "\n");

		}
		System.out.println("======================================================");

	}// viewBBsList end

}
