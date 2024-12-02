package com.yedam.classes;

import com.yedam.student.Student;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal1 = new Calculator(); // 인스턴스 생성 / 계산기 실체화
		int sum = cal1.sum(10, 20);
		System.out.println("합계: " + cal1.sum(10, 20)); // int값 덧셈
		System.out.println("합계: " + cal1.sum(10.3, 13.5)); // double값 덧셈
		System.out.println("큰 값은 " + cal1.max(10, 20.7));
		cal1.printStar(3);
		int[] intAry = { 3, 6, 9, 12 };
		sum = cal1.sumAry(intAry); // return 타입은 int 타입 / 매개변수 : int배열 / 배열을 넣으면 배열의 합
		System.out.println("intAry의 합은 " + sum + " 입니다.");
		
		double result = cal1.averageAry(intAry);
		System.out.println("intAry의 평균은 " + result + " 입니다.");
		
		Student s1 = new Student("S001", "홍길동", 83, 78);
		Student s2 = new Student("S002", "김길동", 77, 60);
		Student s3 = new Student("S003", "최길동", 45, 90);
		Student[] stdAry = {s1, s2, s3}; // 다른 패키지 안의 클래스를 사용하려면 ctrl shift o 로 import 해줘야 한다.
		Student std = cal1.getMaxScore(stdAry);
		System.out.println("최고 영어 점수는 " + std.engScore + ", 이름은 " + std.studentName + "입니다.");
	}
}
