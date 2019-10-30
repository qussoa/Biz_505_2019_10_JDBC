package com.biz.config.exec;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFomatCheck_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * simpleDateFomat try을 사용한 방법으로 
		 * 입력하는 날짜형식을 지정하고 싶을때
		 * 입력하는 사람이 지정된 형식대로 입력하지 않으면
		 * 메시지를 보여주고 다시 입력받도록 할 수 있다
		 */
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sd.parse("2019-01-");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("날짜형식이 잘 못 됨");
		}
	}

}
