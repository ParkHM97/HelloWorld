package com.yedam.board;
/*
 * 회원 ID, 회원 PW, 이름, 연락처 
 */

public class Member { // 위의 4가지 정보 담을 필드 생성
	private String memberId;
	private String password;
	private String memberName;
	private String phoneNumber;
	
	// 생성자 (안의 내용은 매개값)
	public Member(String memberId, String password, String memberName, String phoneNumber) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
	}
	
	// 메소드 (회원 아이디, 이름, 전화번호 보여주는 메소드, 회원목록 때 사용)
	public String showInfo() {
		return " " + memberId + "  " + memberName + "  " + phoneNumber; 
	}
	// 아이디 반환 메소드 
	public String getMemberId() {
		return memberId;
	}
	public String getPassword() {
		return password;
	}
}
