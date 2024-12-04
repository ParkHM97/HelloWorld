package com.yedam.ingeritance;

/*
 * Parent: 부모클래스
 */
// 모든 클래스의 가장 상위에 있는 클래스 > Object
// 모든 클래스는 Object 클래스를 상속받고 있다(생략되어 있음)


public class Parent extends Object{
	String field1; // 필드
	
	// 생성자 
	// 생성자에 대한 정의가 없으면 컴파일러가 기본 생성자를 생성한다.
	// 생성자를 따로 정의하면 기본 생성자는 없음
	public Parent(){
		
	}
	
	public Parent(String field1) { 
		super(); // 부모가 가지고 있는 생성자 중에 기본생성자를 호출하겠다는 의미 (super -> 부모)
		this.field1 = field1;
	}
	
	
	void method1() {
		System.out.println("메소드 1 호출"); 
	}
	@Override
		public String toString() {
			//return super.toString(); // Object가 가지고 있는 toString
			return "field1의 값은 " + field1;
		}
}
