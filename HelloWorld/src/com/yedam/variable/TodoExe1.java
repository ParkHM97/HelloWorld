package com.yedam.variable;

public class TodoExe1 {
	public static void main(String[] args) {
		// Math.random() : 0 ~ 1 사이 임의의 실수
		// 1 ~ 100 까지 임의의 정수 3번 생성
		// 3개 변수의 합 
				
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			int randomValue = (int) (Math.random() * 100) + 1; // 1이 안나와서 1을 더함 
			// (int) < 정수화하는 구문
			sum += randomValue;
		} 
		System.out.println(sum);
	
	
	}
}
