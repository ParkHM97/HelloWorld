package com.yedam.variable;

public class IntExe4 {
	public static void main(String[] args) {
		String msg = new String("Hello, World"); // 문자열 클래스에 
		//msg => 주소값에 문자객체의 주소를 참조함 (참조)
		int age = 10; // age 주소값에 10의 값

		int myAge = age;
		System.out.println(myAge == age); // 같다
		// 숫자값은 == 로 비교할 수 있지만 문자값을 비교할 때는 equals을 붙여야 한다
		// 실제 문자값이 아닌 주소를 비교하기 때문에...
		
		myAge = 20;

		System.out.println("age=>" + age + ", myAge=> " + myAge);
		System.out.println(msg == "Hello, World"); // 같지 않다 
		System.out.println(msg.equals("Hello, World")); // 같다 equals 을 사용해야 함
	}
}
