package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {
	static Scanner scn = new Scanner(System.in); // 메인메소드가 static이기 때문에
	static StudentDAO dao = new StudentDAO(); // 메인메소드가 static이기 때문에

	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("ID 입력: ");
			String id = scn.nextLine();
			System.out.println("PW 입력: ");
			String pw = scn.nextLine();
			
			String name = dao.login(id, pw); // 값이 있으면 조회됨
			if (name!=null) {
				System.out.println(name + "님 환영합니다");
				break;
			} else {
				System.out.println("로그인 다시 시도");
			}
			break;
		}
		
		
		while (run) {
			System.out.println("1. 목록 | 2. 등록 | 3. 점수등록 | 4. 상세조회 | 9. 종료");
			System.out.print("선택하세요 >> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 목록
				list();
				break;

			case 2: // 등록
				System.out.println("학생번호입력 >> ");
				String no = scn.nextLine();
				System.out.println("이름입력 >> ");
				String name = scn.nextLine();
				System.out.println("연락처 입력 >> ");
				String phone = scn.nextLine();

				Student std = new Student(no, name, phone);

				if (dao.insertStudent(std)) {
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
				if (dao.updateStudent(std)) {
					System.out.println("정상 등록되었습니다");
				} else {
					System.out.println("등록 실패");
				}
				break;
			case 4:
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();
				std = dao.selectStudent(no);
				if (std == null) {
					System.out.println("조회된 결과가 없습니다");
					break;
				}
				System.out.println(std.showDetail());
				break;
			
				
			case 9: // 종료
				run = false;
				break;
			}
		}
		System.out.println("프로그램 끝");
	} // 메인 메소드 종료
		// 목록기능 (분리) case1

	public static void list() {

		Search search = new Search();
		System.out.println("1학생이름 2연락처 3영어점수");
		System.out.print("선택 >> ");
		int menu = Integer.parseInt(scn.nextLine());

		switch (menu) {
		case 1:
			System.out.println("검색할 이름 >> ");
			String name = scn.nextLine();
			search.setName(name);
			break;
		case 2: 
			System.out.println("검색할 연락처 >> ");
			String phone = scn.nextLine();
			search.setPhone(phone);
			break;
		case 3: 
			System.out.println("검색할 점수 >> ");
			int escore = Integer.parseInt(scn.nextLine());
			search.setEngScore(escore);
			break;
		} // switch 종료 (검색조건 선택)
		
		System.out.println("1학생번호정렬 | 2학생이름정렬");
		System.out.print("선택>> ");
		int orderBy = Integer.parseInt(scn.nextLine());
		
		// 정렬조건추가
		switch (orderBy) {
		
		case 1: 
			search.setOrderBy("std_no");
			break;
		case 2:
			search.setOrderBy("std_name");
			break;
			
		}
		ArrayList<Student> list = dao.studentList(search);
		for (Student stud : list) {// 학생번호, 이름, 연락처
			System.out.println(stud.showInfo());
		}

	} // list() 끝

}
