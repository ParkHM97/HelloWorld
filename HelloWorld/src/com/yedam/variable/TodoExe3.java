package com.yedam.variable;

import java.util.Scanner;

public class TodoExe3 {
	public static void main(String[] args) {
		String[] names = { "박창석", "홍영민", "김익수", "이화영" };

		Scanner scn = new Scanner(System.in);
		System.out.println("친구 이름을 입력하세요 >>> ");
		String search = scn.nextLine();

		System.out.println(names);
		// 입력한 이름이 존재합니다 / 입력한 이름이 없습니다
		// end of prog

		boolean isExists = false; // 결과 반복 안 되게 하려고 ??
		for (int i = 0; i < names.length; i++) {
			isExists = names[i].equals(search);
			if(isExists) {
				break; // 없으면 반복문 종료
			}
		}
		
		if (isExists) {
			System.out.println("입력한 이름이 존재합니다"); // print 출력 / println 출력 후 줄바꿈
			// printf < 자바스크립트처럼 문자와 혼용해서 사용가능 % 사용 (% 첫번째를 대신 받아옴, s => string 타입)
			// "입력한 이름 %10s가 존재합니다. 나이는 %2d 입니다.", 박창석, 30
			// % : 인수를 대신 받음 / 10 : 해당 인수의 길이 / s : string (줄바꿈 x)
			// 강제 줄바꿈 : \n
			// 탭 : \t (교재 111p)
		} else {
			System.out.println("입력한 이름이 없습니다.");
		}
		System.out.println("end of prog");

	}
}
