package com.yedam.jdbc.student;

import java.util.ArrayList;

public class TestExe {
	public static void main(String[] args) {
		// 검색조건 
		Search search = new Search();
		search.setName("길동"); // 길동이름으로 검색
		search.setPhone("12"); // 번호에 22 들어간 휴대폰 검색		
		search.setEngScore(60); // 60점 이상
		search.setOrderBy("std_no"); // 학생번호 정렬 
		
		StudentDAO sdao = new StudentDAO();
		ArrayList<Student> list = sdao.studentList(search); // 검색조건을 담고 있는 값, studentList 는 ArrayList
		for(Student std : list) {//그래서 반복문을 쓴다
			System.out.println(std.showInfo());
			
		}
	}
}
