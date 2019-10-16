package com.biz.grade.exec;

import java.util.List;
import java.util.Scanner;

import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.persistence.StudentDTO;
import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceV1;
import com.biz.grade.service.StudentService;
import com.biz.grade.service.StudentServiceV1;

public class ScoreEx_03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StudentService st = new StudentServiceV1();
		ScoreService sc = new ScoreServiceV1();

		while (true) {
			System.out.println("=================================");
			System.out.println("성정처리 v1");
			System.out.println("=================================");
			System.out.print("학생이름 : ");
			String strName = scan.nextLine();
			List<StudentDTO> stdList = st.findByName(strName);
			if (stdList == null || stdList.size() <1) {
				System.out.println("찾는 학생 없음");
				continue;
			}
			for (StudentDTO sDTO : stdList) {
				System.out.println(sDTO.toString());
				List<ScoreDTO> scList = sc.findByName(sDTO.getSt_num());
				if (scList != null) {
					for (ScoreDTO scDTO : scList) {
						System.out.println(scDTO.toString());
					}
				}
			}

		}
	}
}
