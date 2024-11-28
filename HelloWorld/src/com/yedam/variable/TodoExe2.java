package com.yedam.variable;

import java.util.Scanner;

public class TodoExe2 {
	public static void main(String[] args) {
		String name = "김길동";

		Scanner scn = new Scanner(System.in); // 클래스 (ctrl shift O) > 풀네임 import java.util.Scanner;
		// System.in : 키보드로 입력한 값
		System.out.println("이름을 입력하세요.");
		String inputValue = scn.nextLine(); // scn.nextLine(); : 사용자의 입력값을 반환
		System.out.println(""); // 같은 이름, 다른 이름 (if else)

		if (inputValue.equals(name)) {
			System.out.println("입력한 이름은 " + name + "입니다.");
		} else {
			System.out.println("입력한 이름은 " + inputValue + "입니다.");
		}

		System.out.println("end of prog");
	}
}
