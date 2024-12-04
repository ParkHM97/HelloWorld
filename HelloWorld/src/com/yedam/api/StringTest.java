package com.yedam.api;

import java.util.Date;

public class StringTest {
	public static void main(String[] args) {

		test1();
		test2();
		test3();
	}

	static void test1() {
		// 현재 시간을 yyyy/MM/dd hh:mm:ss 로 출력.
		Date now = new Date();
		answer1(now);
	}

	static void answer1(Date today) {
		String result = "%d/%d/%s %s:%s:%s \n";
		int yyyy = today.getYear() + 1900;
		int MM = today.getMonth() + 1;
		String dd = "0" + today.getDay();
		String hh = "0" + today.getHours();
		String mm = "0" + today.getMinutes();
		String ss = "0" + today.getSeconds();
		System.out.printf(result, yyyy, MM, dd, hh, mm, ss);
   	}
	

	public static void test2() {
		// 주민번호를 받아서 성별을 구별하는 프로그램.
		String[] numbers = { "9501231234567", "950405 2345678", "980102-1345678" };
		for (int i = 0; i < numbers.length; i++) {
		System.out.println(numbers[i] + "는 " + answer2(numbers[i]));
		}
	}

	static String answer2(String ssn) {
			int gender = ssn.length()-7;
			switch(ssn.charAt(gender)) {
			case '1':
				return "남자입니다.";
			case '2':
				return "여자입니다.";
			default : 
				return "알수없음";
			}
		}
		

	static void test3() {
		// 파일의 이름과 확장자를 구하는 코드.
		String[] files = { "c:/temp/rose.jpg", "d:/download/new.txt", "temp/good.jpeg" };
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i] + "의 확장자는 " + answer3(files[i]) + " 입니다.");
		
		}
	}

	static String answer3(String name) {
		int endPos = name.indexOf(".");
		int startPos = name.lastIndexOf("/");
		String ext = name.substring(startPos + 1, endPos);
		return ext;

	}
}
