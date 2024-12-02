package com.yedam.reference;

import java.util.Scanner;

/*
 * 친구정보 저장기능
 * 1. 추가 2. 목록 3. 조회 (숙제) 9. 종료
 * 3번 => 이름을 입력하면 이름과 비교해서 연락처와 생년월일 출력
 */
public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10];
//		storage[0] = "홍길동"; // X 
//		storage[0] = new Friend(); O (타입이 동일해야 한다)
		// System.out.println(storage[0].friendName); // null값이기 때문에 오류가 발생한다.
//		storage[0] = new Friend();
//		storage[0].friendName = "홍길동";
//		storage[0].friendPhone = "010-1111-1111";
//		storage[0].friendBirth = "1999-01-01";
		
//		C(reate) R(ead) U(pdate) D(elete)

//		System.out.println(storage[0].friendName);

		while (run) {
			System.out.println("1. 추가 2. 목록 3. 조회(숙제) 4. 수정(연락처) 5. 삭제 9. 종료");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가
				System.out.println("친구 이름을 입력 >> ");
				String name = scn.nextLine();
				System.out.println("친구 연락처 입력 >> ");
				String phone = scn.nextLine();
				System.out.println("친구 생일 입력 >> ");
				String birth = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
//					System.out.println(storage[i]);
					if (storage[i] == null) { // 배열의 비어있는 위치에 저장
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						System.out.println("등록완료");
						break; // for 종료
					}
				}
				break; // switch 종료
			case 2:
				System.out.println("이름                전화번호");
				System.out.println("-------------------------");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%4s %14s \n", storage[i].friendName, storage[i].friendPhone);
					}
				}
				break; // case2 종료
			case 3: // 조회
				boolean isExists = false;
				System.out.println("이름을 입력하세요 >> ");
				name = scn.nextLine();
				int idx = 0;
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닐 때 비교
						isExists = storage[i].friendName.equals(name);
						if (isExists) {
							idx = i;
							break; // for 반복문에 대한 break
						}
					}
				}
				if (isExists) {
					System.out.printf("%4s %14s \n", storage[idx].friendPhone, storage[idx].friendBirth);
				} else {
					System.out.println("동일한 이름이 존재하지 않습니다.");
				}
			case 4 : // 수정 (연락처) 입력 받는 값이 2개 필요, 누구의 연락처를 바꿀지, 바꿀 연락처는 무엇인지 
//				System.out.println("이름을 입력하세요 >> ");
//				name = scn.nextLine();
//				System.out.println("변경할 연락처를 입력하세요 >> ");
//				phone = scn.nextLine();
//					// 배열 길이만큼 반복 총 길이가 10이더라도 5개에만 들어가 있을 수 있기 때문에 
//					// NULL에 대해 체크해야 한다. 
//				for(int i = 0; i < storage.length; i++) {
//					if(storage[i] != null) { // NULL 값이 아닌 요소 대상 
//						if(storage[i].friendName.equals(name)) {
//							storage[i].friendPhone = phone; 
//							break; // 해당 이름의 전화번호를 찾고 변경했으면 for 반복문 종료 
//						} 
//					} 
//				} System.out.println("정상처리 되었습니다.");
//				break; // switch 문 종료. 
				isExists = false; 
				idx = 0; 
				System.out.println("이름을 입력하세요 >> ");
				name = scn.nextLine();

					// 배열 길이만큼 반복 총 길이가 10이더라도 5개에만 들어가 있을 수 있기 때문에 
					// NULL에 대해 체크해야 한다. 
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) { // NULL 값이 아닌 요소 대상 
						isExists = storage[i].friendName.equals(name);
						if(isExists) {
							idx = i;   
							break; 
						} 
					} 
				} 
				if(isExists) {
					System.out.println("변경할 연락처를 입력하세요 >> ");
					phone = scn.nextLine();
					storage[idx].friendPhone = phone; 
					System.out.println(name + "의 연락처가 " + phone + " 으로 수정되었습니다.");
				} else {
					System.out.println("동일한 이름이 존재하지 않습니다.");
				}
				
			case 5: // 삭제 > null 값으로 바꿔주면 삭제가 된다
				isExists = false; 
				idx = 0;
				System.out.println("삭제할 이름을 입력하세요.");
				name = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if(storage[i]!= null && storage[i].friendName.equals(name)) {
						storage[i] = null;
						System.out.println(name + "이(가) 정상삭제 되었습니다.");
					}
				}
				break; // switch 문 종료 

			case 9: // 종료
				run = false;
				break; // switch 종료
			default:
				System.out.println("메뉴를 다시 선택하세요");
			} // end of switch
		} // end of while
		System.out.println(" ~~~ 프로그램 끝 ~~~ ");
	} // end of main
} // end of class
