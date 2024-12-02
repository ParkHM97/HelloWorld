package com.yedam.classes;

import com.yedam.student.Student;

public class Calculator {

	// 기본생성자 public Calculator() {}
	// 반환값 + 메소드이름 + 매개변수(...)
	int sum(int n1, int n2) {// sum 메소드
		int result = n1 + n2;
		return result; // sum 메소드를 사용하려면 인스턴스가 존재해야 한다 > CalculatorExe 생성
	}

	// 메소드 오버 로딩 (메소드의 이름이 같고, 매개변수의 개수나 타입이 다른 것 // int와 double의 차이)
	double sum(double n1, double n2) {
		double result = n1 + n2;
		return result;
	}

	double max(double n1, double n2) {
		if (n1 >= n2) {
			return n1; // return문을 만나면 메소드가 종료됨. 조건문을 만족할시 n1을 리턴하고 종료~
		}
		return n2;
	}

	double max(int[] ary) {
		int result = 0;
		for (int i = 0; i < ary.length; i++) {
			if (result < ary[i]) {
				result = ary[i];
			}
		}
		return result;
	}

	void printStar(int times) { // void : 리턴값 없음
		for (int i = 0; i < times; i++) {
			System.out.print("☆");
		}
		System.out.println();
	}

	// 반환값의 유형은 int, 매개변수는 정수배열
	int sumAry(int[] ary) {
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum; // 반환값
	}

	double averageAry(int[] ary) {
		return sumAry(ary) * 1.0 / ary.length; // 1.0을 곱해서 실수로 만들어 준다

	}

	// 매개값으로 Student[]를 활용해서 영어점수가 가장 높은 값을 반환
	Student getMaxScore(Student[] stdAry) { // student 패키지
		int max = 0;
		Student result = null;
		for (int i = 0; i < stdAry.length; i++) {
			if (max < stdAry[i].engScore) { // 타입 동일하게 비교
				max = stdAry[i].engScore;
				result = stdAry[i];
			}
		}
		return result; // 해당 학생 이름도 출력
	}
}
