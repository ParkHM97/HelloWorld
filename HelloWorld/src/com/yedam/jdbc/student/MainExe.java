package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		
		StudentDAO dao = new StudentDAO();
		
		while(run) {
			System.out.println("1. 목록 | 2. 등록 | 3. 점수등록 | 4. 상세조회 | 9. 종료");
			System.out.print("선택하세요 >> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1: //목록
				ArrayList<Student>list = dao.studentList();
				for (Student stud : list) {//학생번호, 이름, 연락처
					System.out.println(stud.showInfo());
				}
				break;
			case 2: // 등록
				System.out.println("학생번호입력 >> ");
				String no = scn.nextLine();
				System.out.println("이름입력 >> ");
				String name = scn.nextLine();
				System.out.println("연락처 입력 >> ");
				String phone = scn.nextLine();
				
				Student std = new Student(no, name, phone);
				
				
				if(dao.insertStudent(std)) {
					System.out.println("정상 등록되었습니다");
				} else {
					System.out.println("등록 실패");
				}
				break;
				
			case 3: // 점수등록 (업데이트) 학생번호 입력, 영어점수, 수학점수 입력 받아야
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();
				System.out.print("영어 점수 입력 >> ");
				int eScore = Integer.parseInt(scn.nextLine());
				System.out.print("수학 점수 입력 >> ");
				int mScore = Integer.parseInt(scn.nextLine());
				
				std = new Student(no, eScore, mScore);
				if(dao.updateStudent(std)) {
					System.out.println("정상 등록되었습니다");
				} else {
					System.out.println("등록 실패");
				}
				break;
			case 4: 
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();
				std = dao.selectStudent(no);
				if(std == null) {
					System.out.println("조회된 결과가 없습니다");
					break;
				}
//				System.out.println(std.showDetail());
				break;
			case 9: // 종료
				run = false;
				break;
			}
		}
		System.out.println("프로그램 끝");
	}
}
