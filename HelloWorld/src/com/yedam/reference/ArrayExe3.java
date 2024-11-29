package com.yedam.reference;

import java.util.Scanner;

/*
 * 배열활용 연습
 * 11월 29일
 */

public class ArrayExe3 {
	public static void main(String[] args) {
		// 배열의 인덱스를 활용해서 같은 순번에 있는 값들은 동일한 사람의 값
		// 학생의 이름과 해당 학생의 점수를 담고 싶음
		String[] names = { "홍길동", "김민수", "최두식" };
		int[] scores = { 80, 90, 70 };
//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i] + "의 점수는 " + scores[i]);
//		}
		// quit 입력시 프로그램 종료
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = ""; // 사용자가 입력한 값을 담아두는 변수
//		while (run) {// 무한 반복
//			// names 배열에서 사용자가 입력한 이름
//			System.out.println("이름을 입력하세요.");
//			searchName = scn.nextLine();
//			for (int i = 0; i < names.length; i++) {
//				if (names[i].equals(searchName)) {
//					System.out.println(names[i] + "의 점수는 " + scores[i]);
//				}
//
//			}
//			if (searchName.equals("quit")) {
//				System.out.println("종료");
//				break;
//			}
//			System.out.println("종료");
//		}

		while (run) {
			System.out.println("이름을 입력하세요.");
			
			// 사용자의 입력값 저장
			searchName = scn.nextLine();
			// quit 입력시 종료
			if (searchName.equals("quit")) {
				break;
			}
	
			boolean isExists = false;
			int idx = 0;
			for (int i = 0; i < names.length; i++) {
				isExists = names[i].equals(searchName);
				if (isExists) {
					idx = i;
					break;
				}
			} 		
			// 동일 이름 확인
			if (isExists) {
				System.out.println(names[idx] + ", " + scores[idx]);
			} else {
				System.out.println("찾는 이름 없음");
			} // if 끝
			
		} // while 끝
		System.out.println("프로그램 종료");
	} // main 끝
} // class 끝
