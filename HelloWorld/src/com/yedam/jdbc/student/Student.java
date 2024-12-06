package com.yedam.jdbc.student;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * tb1_student의 칼럼을 필드로 선언
 */
public class Student {

	private String stdNo;
	private String stdName;
	private String stdPhone;
	private int engScore;
	private int mathScore;
	private Date creationDate;

	public Student() {

	}

	public Student(String stdNo, String stdName, String stdPhone) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdPhone = stdPhone;

	}

	public Student(String stdNo, int engScore, int mathScore) {
		super();
		this.stdNo = stdNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public Student(String stdNo) {
		super();
		this.stdNo = stdNo;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	// 목록 출력

	public String getStdName() {
		return stdName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
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

	public String showInfo() {
		// Date => 출력 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String cdate = sdf.format(creationDate); // 위에서 지정한 포맷 형식으로 날짜 반환
		return " " + stdNo + " " + stdName + " " + stdPhone + " " //
				+ engScore + " " + mathScore + " " + cdate;
	}

	public String showDetail() {

		String result = "-------------------------------------\n";
		result += "학생번호: " + stdNo + "       이름: " + stdName + "\n";
		result += "연락처: " + stdPhone + " \n";
		result += "영어점수: " + engScore + "    수학점수: " + mathScore + "\n";
			   result += "-------------------------------------\n";
		return result;
	}

}
