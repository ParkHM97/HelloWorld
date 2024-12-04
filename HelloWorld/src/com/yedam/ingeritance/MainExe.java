package com.yedam.ingeritance;

public class MainExe {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.field1 = "부모필드";
		p1.method1();
	//	p1.method2(); 자식 클래스의 멤버는 사용 불가
		System.out.println(p1.toString()); // com.yedam.ingeritance.Parent@7960847b
	//	p1 부모 => object
		
		Child c1 = new Child(); // Parent 클래스의 필드 메소드 생성자 등을 물려받음
		c1.field1 = "자식필드";
		c1.method1();
		c1.field2 = "자식필드2";
		c1.method2();
		System.out.println(c1.toString()); // com.yedam.ingeritance.Child@5c8da962
	// c1 부모 => p1
	}
}
