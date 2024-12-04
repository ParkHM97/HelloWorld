package com.yedam.ingeritance;
/*
 * Child: Parent 상속 클래스
 */
public class Child extends Parent { // 생성자에 대한 정의가 없음 > Child 라는 생성자 생성
	String field2;
	
	// 생성자: 기본 생성자를 생성함 Child() => 부모가 가지고 있는 기본 생성자를 호출하고 (super();) 자기자신의 생성자를 만든다
	public Child() { // 생성자 생성 (부모 클래스에는 이런 생성자가 없다)
		super("");
	}
	
	@Override // 부모의 메소드 정의(반환값, 메소드이름, 매개값)
	// Override가 없으면 method1(int a) 등 으로 사용 가능(override가 붙으면 X)
	void method1() {
		// 부모가 가지고 있는 메소드를 자식이 재정의 > 메소드오버라이드 
		System.out.println("자식 메소드 1 호출"); // sysout의 출력값이 변경됨 (메소드 1 호출 > 자식 메소드 1 호출)
	}
	
	void method2() {
		System.out.println("메소드 2 호출");
	}
	// toString() 오버라이딩

	@Override
	public String toString() {
		return "Child [field2=" + field2 + "]";
	}
	
}
