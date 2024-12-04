package com.yedam.api;

public class Student {
	private int sno; // 학생번호
	private String sname;
	private int score;

	// 생성자
	public Student(int sno, String sname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.score = score;
	}

	// haschCode() & equals() => 학번이 같으면 논리적으로 동등한 객체
//	students.add(new Student(1001, "홍길동", 80));
//	students.add(new Student(1002, "김민동", 70));
//	students.add(new Student(1003, "최우동", 60));
//	students.add(new Student(1004, "박길돈", 50));
//	students.add(new Student(1001, "홍길동", 80));
//	결과값 > (순서가 달라짐)
//	학번: 1001 이름: 홍길동 점수: 80
//	학번: 1002 이름: 김민동 점수: 70
//	학번: 1001 이름: 홍길동 점수: 80
//	학번: 1004 이름: 박길돈 점수: 50
//	학번: 1003 이름: 최우동 점수: 60
//	

	@Override
	public int hashCode() {
		return sno; // 학생번호를 hashCode값으로
	}

	@Override
	public boolean equals(Object obj) { // casting 후 sno 비교
		if (obj instanceof Student) {
			Student s1 = (Student) obj;
			if(sno == s1.sno) {
				return true;
			}
		} 
		return false;
	}

	public int getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "학번: " + sno + " 이름: " + sname + " 점수: " + score;
	}

}
