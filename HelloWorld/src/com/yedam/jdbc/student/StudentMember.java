package com.yedam.jdbc.student;

public class StudentMember {
	private String memberId;
	private String password;
	private String memberName;
	
	public StudentMember() {
		
	}
	
	public StudentMember(String memberId, String password, String memberName) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	
	
	
}
