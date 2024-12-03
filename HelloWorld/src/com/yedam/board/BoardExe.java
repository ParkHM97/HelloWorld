package com.yedam.board;

import java.util.Date;

/*
 * 1. 등록 2. 목록
 */
public class BoardExe {
	private Board[] storage;

	// 등록
	public BoardExe() { // storage 필드 초기화
		storage = new Board[10];
//		storage[0] = new Board(1, "자바...", "열심히 합시다", "user01", "2024-12-03");
//		storage[1] = new Board(2, "화요일", "집에 가고 싶다", "user02", "2024-12-03");
//		storage[2] = new Board(3, "점심시간이", "빨리오면 좋겠다", "user03", "2024-12-03");
		// 글번호 정렬
		storage[1] = new Board(6, "자바...", "열심히 합시다", "user01", new Date());
		storage[2] = new Board(2, "화요일", "집에 가고 싶다", "user02", new Date());
		storage[9] = new Board(9, "점심시간이", "빨리오면 좋겠다", "user03", new Date()); // 제일 마지막에
	}

	public boolean insertBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = board;
				return true;
			}
		}
		return false;
	}

	// 게시판 글 번호순대로 정렬
	public Board[] boardList() {
		for (int j = 0; j < storage.length - 1; j++) {
			for (int i = 0; i < storage.length - 1; i++) {// 배열보다 하나 작은 만큼 반복

				// 뒷자리가 null이면 아무것도 X
				if (storage[i + 1] == null) {
					continue; // null이면 다음으로 이동 (배열 중에 중간에 있는 값이 존재할 수 있으니까)
				}
//				if (storage[i] == null || //
//						storage[i].getBoardNo() > storage[i + 1].getBoardNo()) {
//
//				}
				Board temp = null;
				if (storage[i] == null || // 
						storage[i].getBoardNo() > storage[i + 1].getBoardNo()) {
					temp = storage[i];
					storage[i] = storage[i + 1];
					storage[i + 1] = temp;
				}
			}

		}

		return storage;
	}

	// 글 번호를 가져오는 메소드
	// 글 번호(순차등록) : null 개수를 확인해서 + 1
	// null이 아닌 갯수에 +1
	// boardNo의 max값이 +1 한 값을 반환 (O)

	public int getNextNo() { // 매개값 X, 순번만 필요
		int cnt = 0;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				int bno = storage[i].getBoardNo();
				if (cnt < bno) { // 현재의 Max값보다 큰 값일 경우
					cnt = bno; // cnt에 bno
				}
				// null이 아니면 cnt 1씩 증가
			}
			// null이 아닌 값
		}
		return cnt + 1;
	}

	// 글삭제 기능 => 매개값은 글 번호, 반환값(boolean)은 true (해당 글이 있으면)/ false(해당 글 번호가 없으면) 메소드
	// 이름 deleteBoard()
	public boolean deleteBoard(int bno) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == bno) {
				storage[i] = null; // 삭제
				return true;
			}
		}
		return false;

	}

	// 글 수정기능 => 매개값은 글번호 + 글내용 + 제목, 반환값은 true / false, updateBoard()
	public boolean updateBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == board.getBoardNo()) { // 수정할 글 번호를 찾음
				storage[i].setTitle(board.getTitle()); // 입력한 값을 다시 title에 입력
				storage[i].setContent(board.getContent());
				return true;
			}
		}
		return false;
	}

	// 삭제 수정 권한 있는지 체크 => 어떤 글을 누가 썼는지 // 매개값은 글번호, 작성자, 반환값은 true / 다르면 false
	// checkResponsibility()
	public boolean checkResponsibility(int bno, String writer) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				if (storage[i].getBoardNo() == bno && storage[i].getWriter().equals(writer)) {
//					storage[i] = null;
					return true;
				}
			}
		}
		return false;
	} // checkResponsibility 끝

}
