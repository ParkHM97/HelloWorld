package com.yedam.reference;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		String name = new String("홍길동"); // "홍길동"
		int age = 20;

		Friend f1 = new Friend(); // Friend를 ctrl 클릭하면 Friend.java로 이동
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1111";
		f1.friendBirth = "1991-01-11";

		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-2222";
		f2.friendBirth = "1992-02-22";

		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-3333";
		f3.friendBirth = "1993-03-30";

		Friend[] myFriends = { f1, f2, f3 }; // 변수(f1) 하나가 세 가지 값을 가지고 있음

//		System.out.println(myFriends[0].friendName); // 1번째 홍길동의 이름
//		System.out.println(myFriends[0].friendPhone); // 연락처
//		System.out.println(myFriends[0].friendBirth); // 생일 

		// 이름을 입력하면 이름, 연락처와 생일을 출력

		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = "";

		/*
		 * 1. 사용자의 입력값을 searchName에 저장 2. searchName의 값을 friend 배열에서 검색 3. 찾는 사람이 있으면
		 * 이름, 연락처, 생년월일 출력 4. 없으면 찾는 이름 없음 출력 5. 입력값이 quit이면 while 반복문 종료
		 */

		while (run) {
			System.out.println("이름을 입력하세요.");
			searchName = scn.nextLine();
			if (searchName.equals("quit")) {
				System.out.println("종료");
				break; // 입력값이 quit면 while 종료
			}
			boolean isExits = false;
			int idx = 0;
			for (int i = 0; i < myFriends.length; i++) {
				isExits = searchName.equals(myFriends[i].friendName);
				if (isExits) {
					idx = i;
					break;
				}
			}
			if(isExits) {
				System.out.println("연락처는 " + myFriends[idx].friendPhone + ", 생년월일은 " + myFriends[idx].friendBirth + "입니다.");
			} else {
				System.out.println("동일한 이름이 존재하지 않습니다.");
			}

			if (searchName.equals(myFriends[0])) {
				System.out.println("종료");

			}

		}
	}
}
