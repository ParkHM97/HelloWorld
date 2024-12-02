package com.yedam.methods;
/*
 * 학생의 성적 관리 프로그램
 * 관리 항목 : 학생번호, 학생이름, 영어점수, 수학점수
 * Friend 참고 
 */


public class Student {
	
	private String studentId; // 학생번호  // 필드 
	private String studentName; // 학생이름
	private int engScore; // 영어점수
	private int mathScore; // 수학점수

	// 생성자 
	public Student(String studentId) {
		this.studentId = studentId;
	}
	
	public Student(String studentId, String studentName, int engScore, int mathScore) {

		this.studentId = studentId;
		this.studentName = studentName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	
	// getter, setter 메소드
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	// showInfo()
	public String showInfo() {
		return "학번: " + studentId + ", 이름: " + studentName + ", 영어: " + engScore;
	}
	


}

