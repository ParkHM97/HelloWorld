package com.yedam.reference;

import java.util.Scanner;

/*
 * 은행 프로그램 (p 183 / Q7)
 * 11월 29일
 */
public class ArrayEx2 {
	public static void main(String[] args) {
		// 변수 초기화, 10만원 초과 불가
		// 90000원이 있는데 20000원을 추가 입금함 < 20000원 추가 입금 안 되게 만들기
		boolean run = true; // 반복문 무한 반복
		int balance = 0; // 잔액
		int maxBalance = 100000;
		Scanner scn = new Scanner(System.in);

		while (run) {// 계속 반복
			System.out.println("---------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			System.out.print("선택 >> ");
			int menu = Integer.parseInt(scn.nextLine()); // 문자열을 정수로 바꿔줌 integer.parseInt
			switch (menu) {
			case 1:
				System.out.println("예금액 > ");
				int inBalance = Integer.parseInt(scn.nextLine());
				if (balance + inBalance <= maxBalance) {
					balance += inBalance;
					System.out.println("정상처리 되었습니다.");
				} else {
					System.out.println("잔액이 10만원을 초과했습니다.");
				}
				break;
			case 2:
				System.out.println("출금액 > ");
				inBalance = Integer.parseInt(scn.nextLine());
				if (balance - inBalance > 0) {
					balance -= inBalance;
				} else {
					System.out.println("마이너스로 출금할 수 없습니다.");
				}
			case 3:

				System.out.println("잔액 > " + balance + "원 입니다.");

			case 4:
				run = false;
			}
		}
		System.out.println("프로그램 종료");

	}
}
