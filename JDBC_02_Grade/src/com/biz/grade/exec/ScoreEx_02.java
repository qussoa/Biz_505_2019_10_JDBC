package com.biz.grade.exec;

import java.util.Scanner;

import com.biz.grade.persistence.ScoreDTO;
import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceV1;

public class ScoreEx_02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ScoreService sc = new ScoreServiceV1();

		while (true) {
			System.out.println("=================================");
			System.out.println("성정처리 v1");
			System.out.println("=================================");
			System.out.print("찾을 데이터 ID : ");

			String strID = scan.nextLine();
			long sID = Long.valueOf(strID);
			ScoreDTO sd = sc.findById(sID);
			if (sd == null) {
				System.out.println("찾는 데이터 없음");
			} else {
				System.out.println(sd.toString());
			}

		}
	}
}
