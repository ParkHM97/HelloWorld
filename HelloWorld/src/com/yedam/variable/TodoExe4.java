package com.yedam.variable;

import java.util.Scanner;

//public class TodoExe4 {
//	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("출력할 단을 입력하세요 >> ");
//		//scn.nextLine(); // 사용자가 입력한 값을 문자열(string)로 
//		// scn.nextInt(); // 사용자가 입력한 값을 정수로 반환
//		int dan = scn.nextInt(); 
//		
//		
////		String num = scn.nextLine();
//		for (int i = 1; i < 10; i++) {
////			System.out.printf("3 * %1d는 %1d입니다. \n", i, 3 * i); 3단만
//			System.out.printf("%d * %d = %2d \n", dan, i, dan * i);
//		}
//		System.out.println("end of prog");
//	}
//}

public class TodoExe4 {
	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("몇 단까지 출력하겠습니까? >> "); // 2단부터 시작해서
//		// scn.nextLine(); // 사용자가 입력한 값을 문자열(string)로
//		// scn.nextInt(); // 사용자가 입력한 값을 정수로 반환
//		int dan = scn.nextInt();
////
////		for (int j = 2; j <= dan; j++) {
////			System.out.printf("현재 %d 단입니다. \n", j);
////			for (int i = 1; i < 10; i++) {
////				System.out.printf("%d * %d = %2d \n", j, i, j * i);
////			}
////		}
////		System.out.println("end of prog");
//
//		for (int j = 2; j <= 9; j++) {
////			System.out.print("\n", j);
//			for (int i = 2; i <= dan; i++) {
//				System.out.printf("%d * %d = %2d  ", i, j, j * i);
//			}
//			System.out.println();
//		}

		// 별찍기 
//		for(int j = 1; j<=5; j++) {
//			for (int i = 1; i <= j; i++) {
//				System.out.print("*");
//			
//			}
//			System.out.println();
//		}
//		
		for(int i = 1; i <= 5; i++) {
			for (int j = 5; i <= j; j--) {
				
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		System.out.println("end of prog");
	}
}
