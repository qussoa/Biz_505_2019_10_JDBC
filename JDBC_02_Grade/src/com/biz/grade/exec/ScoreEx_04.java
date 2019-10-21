package com.biz.grade.exec;

import java.util.Random;
import java.util.Scanner;

import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.persistence.StudentDTO;
import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceV1;
import com.biz.grade.service.StudentService;
import com.biz.grade.service.StudentServiceV1;

public class ScoreEx_04 {
public static void main(String[] args) {
	
	StudentService st = new StudentServiceV1();
	ScoreService sc = new ScoreServiceV1();
	Scanner scan = new Scanner(System.in);
	Random rnd = new Random();
	while(true) {
		System.out.println("========================");
		System.out.println("성적입력");
		System.out.println("========================");
		System.out.print("학번 : ");
		String strNum = scan.nextLine();
		
		StudentDTO stDTO = st.findById(strNum);
		if(stDTO == null) {
			System.out.println("학생정보가 없는 학번");
			System.out.println("학생정보를 먼저 등록해야");
			System.out.println("성적을 입력할 수 있습니다");
			continue;
		}
		System.out.print("과목코드 : ");
		String strSubject = scan.nextLine();
		System.out.print("점수 : ");
		String strScore = scan.nextLine();
		int intScore = Integer.valueOf(strScore);
		
		long s_id = (long)(Math.random()*100000);
		ScoreDTO dvo = ScoreDTO.builder()
				.s_id(s_id)
				.s_std(strNum)
				.s_score(intScore)
				.s_subject(strSubject)
				.build();

				int ret = sc.insert(dvo); 
				if(ret > 0) {
					System.out.println("데이터 추가 완료");
				}else {
					System.out.println("데이터 추가 실패");
				}
	}
}
}
