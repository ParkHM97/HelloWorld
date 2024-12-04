package com.yedam.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * hashCode() 메소드의 오버라이딩
 */
public class SetExe {
	public static void main(String[] args) {
		
	// Map 컬렉션 / 키 & 값을 저장
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김길동");
		map.put(300, "최길동");

		String result = map.get(100); 
		System.out.println(result);// 100이라는 키 값 입력 > 해당하는 값 반환 ("홍길동")
		
		Set<Integer> kset = map.keySet(); // 맵컬렉션에 있는 키 값만 가져와서 set 컬렉션에 넣어준다
		for(Integer key : kset) {
			System.out.printf("key %d, value: %s\n", key, map.get(key));
		}
		System.out.println("끝");
	}

	
	public void set() { // hash
		// Set => 중복값은 저장 안 함
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student(1001, "홍길동", 80));
		students.add(new Student(1002, "김민동", 70));
		students.add(new Student(1003, "최우동", 60));
		students.add(new Student(1004, "박길돈", 50));
		students.add(new Student(1001, "홍길동", 80));

		for(Student str : students) {
			
			System.out.println(str);
		}
		
		HashSet<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		set.add("Hello"); // 중복값 저장X

		for (String str : set) { // set은 인덱스값이 없어서 인덱스값을 기준으로 하는 걸 할 수 없음
			System.out.println(str);
		}
	}
	
	public void list() {
		// Collection -> List(인덱스 저장), Set(집합), Map(키, 값)
		ArrayList<String> list = new ArrayList<String>(); // <String> : 문자열만 넣겠다는 의미
		list.add("peach"); // [0]
		list.add("lemon"); // [1]
		// list.add(10); // [2]
//				String v1 = (String) list.get(0); // get 타입은 object 타입을 반환함, 그래서 String (peach)
		String v1 = list.get(0); // get 타입은 object 타입을 반환함, 그래서 String (peach)
		// int v2 = (Integer) list.get(2); // object 타입 > Integer (10)

		// 컴파일 시점에 에러 발생
		// 실행에러보다는 컴파일시점 에러가 디버깅에 유리함
		for (int i = 0; i < list.size(); i++) { // object의 크기 > size
			// String result = (String) list.get(i);
			String result = list.get(i); // <String> 선언했기 때문에 안 해도 ok / collection > null값이 없고 계속 크기 확대할 수 잇음
		}
		ArrayList<Student> students = new ArrayList<Student>();

//		students.add("Hello"); // 타입이 다름

		students.add(new Student(1001, "홍길동", 80));
		students.add(new Student(1002, "김민동", 70));
		students.add(new Student(1003, "최우동", 60));
		students.add(new Student(1004, "박길돈", 50));
		students.add(new Student(1001, "홍길동", 80));

		for (Student std : students) {// students 길이만큼 반복
			if (std.getScore() > 50) {
				System.out.println(std);
			}
		}

		ArrayList<String>strList = new ArrayList<String>();
		// 추가
		strList.add("Hello"); // 첫번째 위치에 Hello
		strList.add("World");
		strList.add(0, "Nice"); // 첫번째 위치에 Nice를 담겠습니다 < 그럼 Hello와 World는 하나씩 뒤로 밀린다 (각 인덱스 1/ 2)

		// 삭제
		strList.remove(1); // 인덱스 1번값 삭제

		System.out.println("strList의 크기 " + strList.size());
		// 조회
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));

		}
		// 배열 > strList[0]

	}
}
