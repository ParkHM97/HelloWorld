package com.yedam.variable;
// 파일이름.java => 클래스의 이름은 파일 이름과 같아야 한다.

public class IntExe1 {
	public static void main(String[] args) { // ctrl + spacebar 단축기능 (자동완성)
		int myAge = 20; // int 는 정수타입이기 때문에 숫자
		int yourAge = 23; 
		
		int ageSum = myAge + yourAge; // int타입 + int타입 = int타입 
		System.out.println("ageSum의 값: " + ageSum + " 입니다.");
		
		// 자바의 배열은 중괄호 {10, 20, 30} (자바스크립트 [])
		int[] intAry = { 10, 20, 30 };
		int sum = intAry[0] + intAry[1] + intAry[2]; // 배열 인덱스간 합 
				System.out.println("intAry의 합: " + sum + " 입니다.");
	}
}

