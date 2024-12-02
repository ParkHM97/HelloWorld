package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		// Student s1 = new Student(); // Student s1 > student 데이터를 담는 변수 / 실체생성 (인스턴스 생성)
		//s1.studentId = "S001";
		//>> 
		Student s1 = new Student("S001");
		s1.studentName = "홍길동"; // 실체를 만든 후에 값을 입력할 수 있다. 
		s1.engScore = 60;
		s1.mathScore = 70;
		System.out.println(s1.studentId + ", " + s1.studentName + "의 합계 점수는 " + s1.sumScore() + ", 평균 점수는 " + s1.avarage());
		
		// int num = 10; // < 처럼 클래스일 경우 new로 인스턴스를 생성하고 변수에 담는다. 
		// Student s1; 와 int num;의 의미는 같음 (변수만 존재하고 어떤 값이 있는지는 모른다) 
		// Teacher t1 = new Teacher(); // 먼저 Teacher()이라는 기능이 정의되어 있어야 함 지금은 teacher라는 기능이 없기 때문에 오류가 발생한다. 
		// 기본적인 규격 (클래스) 가 존재해야 한다 (설계도)
		// String s2 = new Student(); // 타입은 오른쪽과 왼쪽이 같아야 한다.
//		Student s2 = new Student();
	// 	System.out.println(s1 == s2); // 결과값 false | 참조하고 있는 주소값이 다르기 때문에 다른 값이다 / s1 s2 지정하고 안의 값 동일하게 넣었을 때
//		s2.studentId = "S001";
//		s2.studentName = "홍길동"; // s1과 같은 값 대입 

		Student s2 = new Student("S002", "김길동");
		System.out.println(s2.studentId + ", " + s2.studentName);
		s2.engScore = 70;
		s2.mathScore = 75;
		
		Student s3 = new Student("S003", "최길동", 80, 90);
		System.out.println(s3.studentId + ", " + s3.studentName + ", " + s3.engScore + ", " + s3.mathScore);
		
	}
} 
