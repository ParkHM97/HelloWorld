package com.yedam.methods;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student("S001"); // public의 의미 : 다른 클래스에서 접근 가능 / private : 다른 클래스에서 접근 불가능
		//필드에도 public이나 private를 쓸 수 있다.
//		s1.engScore = 1000; 에러... 왜나는지는 몰라 
		s1.setEngScore(1000);
		s1.setStudentName("홍길동");
		s1.setEngScore(70);
		s1.setMathScore(75);
		System.out.println(s1.showInfo());

	}
}
