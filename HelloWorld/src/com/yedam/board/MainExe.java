package com.yedam.board;

import java.util.Scanner;



public class MainExe { // 컨트롤(메인 메소드가 있는 클래스)
	static Scanner scn = new Scanner(System.in); // 사용자 입력값
	static BoardExe bexe = new BoardExe();

	public static void main(String[] args) { // static
		boolean run = true; // while 무한반복 시키기 위함

		MemberExe mexe = new MemberExe(); // 인스턴스 생성

		while (run) {
			System.out.println("1 회원등록 | 2 목록 | 3 게시판 | 9 종료");
			System.out.printf("메뉴선택 >> ");
			int menu = Integer.parseInt(scn.nextLine()); // 입력한 값은 String 타입이 되기 때문에 Integer.parseInt

			switch (menu) { // 추가
			case 1:
				System.out.println("회원아이디 입력 >>  ");
				String id = scn.nextLine();
				System.out.println("회원비밀번호 입력>> ");
				String pw = scn.nextLine();
				System.out.println("회원이름 입력>> ");
				String name = scn.nextLine();
				System.out.println("연락처 입력>> ");
				String phone = scn.nextLine();

				boolean result = mexe.addMember(new Member(id, pw, name, phone)); // 등록기능, addMember는 MemberExe파일에 생성함
				if (result) {// true가 반환되면 하나가 등록됨
					System.out.println("정상 등록되었습니다");
				} else {
					System.out.println("등록되지 않았습니다");
				}
				break;

			case 2: // 목록
				Member[] list = mexe.memberList(); // memberList(ctrl + 좌클릭) > storage 값 반환
				// ㄴ만들어둔 기능을 호출해서 사용
				for (Member member : list) { // list라는 배열의 크기만큼 반복 (총 10번)
					if (member != null) {
						System.out.println(member.showInfo()); // member가 가지고 있는 showInfo 메소드 (문자열 반환)
					}
				}
				break;

			case 3:
				// 게시판 관련
				System.out.println("회원아이디 입력 >>  ");
				id = scn.nextLine();
				System.out.println("회원비밀번호 입력>> ");
				pw = scn.nextLine();
				if (mexe.login(id, pw)) { // id & pw 체크
					boardMethod(id); // true 반환 > 해당 id와 pw가 존재(로그인 성공했을 때 게시판 기능)
				} else {
					System.out.println("ID와 PW를 확인하세요");
				}
				break;
			case 9:
				run = false; // 종료
			}
		} // while 문 종료
		System.out.println("프로그램 종료");
	} // 메인메소드 종료

	// 게시판 관련
	public static void boardMethod(String id) {
		// 1. 추가 2. 목록 3. 수정 4. 삭제 9. 상위 메뉴 이동
		boolean run = true;
		BoardExe bexe = new BoardExe();
		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("1 글 등록 | 2 목록 | 3 수정 | 4 삭제 | 9 상위메뉴 이동");
			System.out.println("선택 >> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가
				// System.out.print("글번호 입력 >> "); 순차등록하게
//				int bno = Integer.parseInt(scn.nextLine()); // 수동입력
				int bno = bexe.getNextNo(); // 순차등록
				System.out.print("글제목 입력 >> ");
				String title = scn.nextLine();
				System.out.print("글내용 입력 >> ");
				String content = scn.nextLine();
//				System.out.print("작성자 입력 >> "); 로그인하면 아이디가 작성
				String writer = id;
//				System.out.print("작성일시 입력 >> ");
				java.util.Date ddd = new java.util.Date(); //현재 시간 

				Board board = new Board(bno, title, content, writer, ddd); // board 타입의 인스턴스
				if (bexe.insertBoard(board)) { // 잘 들어오면 true / 아니면 false
					System.out.println("게시글 등록 완료");
				} else {
					System.out.println("게시글 등록 실패");
				}
				break;

			case 2: // 목록
				Board[] list = bexe.boardList();
				for (Board brd : list) { // board brd 변수 동일하면 안 되기 때문에 다른 변수 지정
					if (brd != null) {
						System.out.println(brd.showInfo()); // 게시글번호, 타이틀을 보여줌 (출력) / 목록 보여주는 메소드
					}
				}
				break;
			case 3:

				System.out.print("수정할 글 번호를 입력하세요>> ");
				bno = Integer.parseInt(scn.nextLine());
				System.out.print("글 제목을 입력하세요>> ");
				title = scn.nextLine();
				System.out.print("글 내용을 입력하세요>> ");
				content = scn.nextLine();
	
				// 수정(제목, 내용) => bno, title, content : Board 타입
				if (!bexe.checkResponsibility(bno, id)) { // 권한 확인
					System.out.println("권한이 없습니다");
					break;
				}

				// 글 수정 메소드 호출
				//사용자의 입력값을 updateBoard의 매개값으로 전달
				board = new Board(bno, title, content, null, null);
				if (bexe.updateBoard(board)) {
					System.out.println("정상 수정 되었습니다");
				} else {
					System.out.println("수정할 글 번호를 다시 확인하세요");
				}
				break;
				
				
			case 4: // 삭제
				// 작성자와 로그인한 사람이 동일해야 삭제 됨
				System.out.print("삭제할 글 번호를 입력하세요>> ");
				bno = Integer.parseInt(scn.nextLine());

				if (!bexe.checkResponsibility(bno, id)) { // 권한 확인
					System.out.println("권한이 없습니다");
					break;
				}

				// 글 삭제 메소드 호출
				if (bexe.deleteBoard(bno)) {
					System.out.println("정상 삭제 되었습니다");
				} else {
					System.out.println("삭제할 글 번호를 다시 확인하세요");
				}
				break;
			case 9: // 상위메뉴 (회원관련 메뉴)
				return;
			}
		}
	} // boardMethod 끝

} // 클래스 종료
