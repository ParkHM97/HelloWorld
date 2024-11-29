package com.yedam.reference;

public class TodoExe1 {
	public static void main(String[] args) {
		// 정수를 담는 배열 크기는 5개로 선언
		// Math.random() 을 사용해 50 ~ 100 사이의 점수 저장
		// 반복 출력

		int[] score = new int[5];
		for (int i = 0; i < score.length; i++) {
			score[i] = (int) (Math.random() * 51) + 50;
			System.out.println(score[i]);
		}

		System.out.println("끝");
		
		// 중복 방지
		int[] intAry = new int[5];
		for (int i = 0; i < intAry.length;) {
			int temp = (int) (Math.random() * 5) + 50;
			boolean exists = false; // 똑같은 값이 존재하는지에 대한 변수
			for (int j = 0; j <= i - 1; j++) {
				if (intAry[j] == temp) {
					exists = true; // 같은 값이 존재
				}
			}
			// 같은 값이 존재하면 i값을 증가하지 않음
			if (exists) {
				continue;
			}
			intAry[i] = temp;
			i++;

		}
		for(int num : intAry) {
			System.out.println(num);
		}

	}
}
