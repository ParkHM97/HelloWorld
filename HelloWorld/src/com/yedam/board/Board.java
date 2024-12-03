package com.yedam.board;

import java.util.Date;

/*
 * 게시글 번호, 제목, 내용, 작성자, 등록일시
 */

public class Board {
	private int boardNo; // 게시글 번호
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자 (회원아이디)
	private Date writeDate; // 등록일시 
	
	// 생성자 (인스턴스 생성 / 필드값을 채워주기 위한 역할)
	public Board() {
		
	}
	public Board(int boardNo, String title, String content, String writer, Date writeDate) { // 6~11줄과 타입이 동일해야 한다 
		this.boardNo = boardNo; // 첫번째 매개값은 boardNo의 필드를 채워주기 위한 매개값
		this.title = title;
		this.content = content;
		this.writer = writer; 
		this.writeDate = writeDate;
	}
	// getter, setter 메소드 (규칙 : 필드이름 앞에 get 또는 set)
	// boardNo를 채우는 메소드 public의 리턴타입은 void
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoardNo() {//int 타입을 리턴해야 한다
		return boardNo; // boardNo가 가진 값 리턴 (그래서 int)
	}
	public void setTitle(String title) {
		this.title = title; 
	}
	public String getTitle() { // title 필드 => 문자열 / getTitle은 title을 받아옴 
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String showInfo() {//목록 보여줄 메소드
		String yyyymmdd = (writeDate.getYear()+1900) + "년" + (writeDate.getMonth()+1) + "월" + writeDate.getDate() + "일";
		return " " + boardNo + "  " + title + "  " + writer + "  " + yyyymmdd;
	}
	
}
