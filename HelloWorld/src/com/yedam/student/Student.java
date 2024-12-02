package com.yedam.student;
/*
 * 학생의 성적 관리 프로그램
 * 관리 항목 : 학생번호, 학생이름, 영어점수, 수학점수
 * Friend 참고 
 */


public class Student {
	public String studentId; // 학생번호  // 필드 
	public String studentName; // 학생이름
	public int engScore; // 영어점수
	public int mathScore; // 수학점수
	
	// 따로 지정하지 않으면 컴파일러가 기본 생성자를 만들어 준다. 매개값이 없는 생성자 (p. 243~)
	public Student() { }// StudentExe의 Student()
	// 매개값이 있는 생성자 
	public Student(String studentId) { // 학생 번호를 넣어주는 생성자
		this.studentId = studentId; // 생성자에서 우선되는 건 매개된 값
		// 객체에서 this는 자기자신이다 / studentId에 매개값으로 전달된 값을 받아주겠다는 의미.. (뭔말?
	}
	public Student(String studentId, String studentName) { // 학생번호와 학생이름 생성자
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	// 모든 값을 받아주는 생성자 
	public Student(String studentId, String studentName, int engScore, int mathScore) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
		
	
	
	// 메소드 (함수)
	public void smile() {
		System.out.println("학생이 웃습니다.");
	}
	public void introduce() {
		System.out.println("이름은 " + studentName + "이고 학번은 " + studentId);
	}
	
	// 메소드 (p.269)영어점수와 수학점수를 더한 
	public int sumScore() {
		return engScore + mathScore;
	}
	
	public double avarage(){
		return (engScore + mathScore)/2;
	}
}
