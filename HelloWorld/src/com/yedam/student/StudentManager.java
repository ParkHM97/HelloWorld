package com.yedam.student;

import java.util.Scanner;

/*
 * CRUD 처리
 * 1. 추가 2. 목록(학생번호/이름(string)/점수2개) 3. 수정(영어(int), 수학(int) / 학생번호와 비교) 4. 삭제 (학생번호 비교) 9. 종료
 * friendManager 참고
 */
// Student => 학생번호, 이룸, 영어점수, 수학점수 // 영어수학점수의 합을 기준으로 정렬  

public class StudentManager {
	public static void main(String[] args) {
//		int[] intAry = { 50, 67, 94, 83, 45 };
//		for (int j = 0; j < intAry.length -1; j++) {// 1회 반복시 결과 : 50 67 83 45 94로, 모두 정렬되지 않았기 때문에 재반복
//			for (int i = 0; i < intAry.length -1 ; i++) { // intAry 값을 각각 비교해 큰 값이면 뒤로 이동, null 값 X 위해 크기보다 1 작게
//				if (intAry[i] > intAry[i + 1]) {// 인덱스 1값보다 0이 크면 위치를 옮겨줌
//					int temp = intAry[i]; // / 덮어쓰기 하지 않기 위해 변수 선언해서 intAry[i] 값을 담아둠
//					intAry[i] = intAry[i + 1];
//					intAry[i+1] = temp;
//				}
//			} 
//		}
//		for (int num : intAry)
//			System.out.println(num);
//	

		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Student[] studentList = new Student[10];
		boolean isSame = false;
		int idx = 0;

		while (run) {
			System.out.println("1. 학생 추가 | 2. 학생 목록 | 3. 점수 수정 | 4. 삭제 | 5. 상세조회 (합계 / 평균) | 6. 합계점수기준정렬 | 9. 종료");
			System.out.print("메뉴를 선택하세요 >> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 학생 추가
				System.out.println("학생번호를 입력하세요.");
				String personId = scn.nextLine();
				System.out.println("이름을 입력하세요.");
				String personName = scn.nextLine();
				System.out.println("영어 점수를 입력하세요.");
				int personEng = Integer.parseInt(scn.nextLine());
				System.out.println("수학 점수를 입력하세요.");
				int personMath = Integer.parseInt(scn.nextLine());
				for (int i = 0; i < studentList.length; i++) {
					if (studentList[i] == null) {
						studentList[i] = new Student(personId, personName, personEng, personMath); // 인스턴스 생성
//						studentList[i].studentId = personId;
//						studentList[i].studentName = personName;
//						studentList[i].engScore = personEng;
//						studentList[i].mathScore = personMath; // 까지 studentList[i] = new Student(personId, personName, personEng, personMath) 가 동일함
						System.out.println("등록 완료");
						break; // for문 종료
					}
				}
				break;// for 문 종료
			case 2: // 학생 목록
				System.out.println("  번호   |   이름   |  영어  |  수학  |");
				for (int i = 0; i < studentList.length; i++) {
					if (studentList[i] != null) {
//						System.out.printf("%6s %7s %5d %7d", studentList[i].studentId, studentList[i].studentName,
//								studentList[i].engScore, studentList[i].mathScore);
//						System.out.println();
						studentList[i].introduce();
					}
				}
				break;

			case 3: // 점수 수정
				System.out.println("점수를 변경할 학생의 학생번호를 입력하세요. >> ");
				personId = scn.nextLine();

				for (int i = 0; i < studentList.length; i++) {
					if (studentList[i] != null) {
						isSame = personId.equals(studentList[i].studentId);
						if (isSame) {
							idx = i;
							break;
						}
					}
				}
				if (isSame) {
					System.out.println("변경할 영어 점수를 입력하세요. >> ");
					personEng = Integer.parseInt(scn.nextLine());
					System.out.println("변경할 수학 점수를 입력하세요. >> ");
					personMath = Integer.parseInt(scn.nextLine());
					studentList[idx].engScore = personEng;
					studentList[idx].mathScore = personMath;
				} else {
					System.out.println("동일한 학생번호가 존재하지 않습니다.");
				}

			case 4: // 삭제
				System.out.println("삭제할 학생번호를 입력하세요. >> ");
				personId = scn.nextLine();

				for (int i = 0; i < studentList.length; i++) {
					if (studentList[i] != null) {
						isSame = personId.equals(studentList[i].studentId);
						if (isSame) {
							idx = i;
							break;
						}
					}
				}
				if (isSame) {
					for (int i = 0; i < studentList.length; i++) {
						if (studentList[i] != null && personId.equals(studentList[i].studentId)) {
							studentList[i] = null;
						}
					}
					System.out.println(personId + "의 데이터가 정상 삭제 되었습니다.");
				} else {
					System.out.println("일치하지 않는 학생번호입니다.");
				}

			case 5: // 상세 조회(합계 / 평균)
				System.out.println("상세조회 할 학생번호를 입력하세요.");
				personId = scn.nextLine();
				for (int i = 0; i < studentList.length; i++) {
					if (studentList[i] != null) {
						isSame = personId.equals(studentList[i].studentId);
						idx = i;
					}
				}
				if (isSame) {
					for (int i = 0; i < studentList.length; i++) {
						if (studentList[i] != null && personId.equals(studentList[i].studentId)) {
							int plusScore = studentList[i].engScore + studentList[i].mathScore;
							double avarageScore = plusScore / 2;
							System.out.println(
									personId + " 의 합계는 " + plusScore + "점, " + " 평균은 " + avarageScore + "점 입니다.");
						}
					}
				} else {
					System.out.println("일치하지 않는 학생번호입니다.");
				}

//			case 6: // 합계 점수 기준 정렬 (오름차순)
//				for (int j = 0; j < studentList.length - 1; j++) {
//					for (int i = 0; i < studentList.length - 1; i++) {
//						if (studentList[i].engScore + studentList[i].mathScore > studentList[i + 1].engScore
//								+ studentList[i + 1].mathScore) {
//							int temp = studentList[i].engScore + studentList[i].mathScore;
//							studentList[i] = studentList[i + 1];
//							studentList[i + 1] = temp;
//						}
//					}
//				}

//				for (int j = 0; j < intAry.length -1; j++) {// 1회 반복시 결과 : 50 67 83 45 94로, 모두 정렬되지 않았기 때문에 재반복
//				for (int i = 0; i < intAry.length -1 ; i++) { // intAry 값을 각각 비교해 큰 값이면 뒤로 이동, null 값 X 위해 크기보다 1 작게
//					if (intAry[i] > intAry[i + 1]) {// 인덱스 1값보다 0이 크면 위치를 옮겨줌
//						int temp = intAry[i]; // / 덮어쓰기 하지 않기 위해 변수 선언해서 intAry[i] 값을 담아둠
//						intAry[i] = intAry[i + 1];
//						intAry[i+1] = temp;
//					}
//				} 
//			}

			case 9: // 종료
				run = false;
				break;
			} // switch 종료
		} // while 반복문 종료
		System.out.println("프로그램 종료");
	} // main 종료
} // StudentManager 종료
