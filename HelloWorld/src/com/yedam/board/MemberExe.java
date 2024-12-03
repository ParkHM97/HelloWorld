package com.yedam.board;
/*
 * 회원가입(등록), 회원정보수정(등록된 정보에서 수정), 목록(등록된 데이터 열람)
 */

public class MemberExe { // 필드 생성
	private Member[] storage; // member데이터를 담는 storage 배열(필드)

	public MemberExe() {// 생성자
		storage = new Member[10]; // 10명의 데이터를 담아둠
		storage[0] = new Member("user01", "1111", "홍길동", "010-1111-1111");
		storage[1] = new Member("user02", "2222", "박민석", "010-2222-2222");
		storage[2] = new Member("user03", "3333", "최주찬", "010-3333-3333");
	}

	// 등록 메소드
	public boolean addMember(Member member) { // 멤버 클래스 타입
		// 비어있는 위치에 값을 채워줌
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {// 비어있으면 채워준다
				storage[i] = member;
				return true; // 기본 배열은 모두 비어있기 때문에 1개만 등록, boolean 타입이므로 true (등록 O)
				// addMember는 메소드 이름
			}
		}
		return false; // 새로운 값을 받아내지 못함 (저장X)
	} // 등록메소드 종료

	// 2. 목록 반환(MainExe에서 사용) 회원정보가 담긴 배열(storage) 반환
	public Member[] memberList() {
		return storage; // 위쪽에 선언한 storage 반환
	}

	// 3. 아이디 & 비밀번호 => 존재여부 반환
	public boolean login(String id, String pw) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {

				if (storage[i].getMemberId().equals(id) && storage[i].getPassword().equals(pw)) {
					return true;
				}
			}
		}
		return false;
	} // end of login().
}
