package com.yedam;

// 대소문자 구분 (A - a 서로 다름/ 클래스 이름은 대문자로 
// 자바 : 객체 지향 언어 (Object Oriented Language)
public class Hello { // 객체 안에 기능을 만듦
	// 메인 메소드 함수(function > 기능) main 메소드 < 클래스가 실행되면 메인 메소드를 찾아서 실행함
	// 메소드 여러 개 선언 - start(), main();
	// 메소드 안에 다른 메소드 X

	public static void start() { // start 메소드
		System.out.println("시작합니다"); // 이건 실행이 안 됨
		// (메인은 가장 먼저 실행되기 때문에 start를 실행하려면 main에서 호출해야 함)
	}

	public static void main(String[] args) {
		// 콘솔에 Hello, World 출력
		System.out.println("Hello, world"); // 세미콜론 반드시 (System = 클래스명)
		start(); // start 메소드 호출

		// 클래스 선언 (exe라는 이름으로)
		OperationExe exe = new OperationExe(); // let result = "Hello"; < 처럼 클래스일 때는 new를 사용해야 함
		exe.sum(10, 20); // sum > 정수형 2개를 가져와 더해서 출력하는 기능

		// Hello.java -> Hello.class(실행파일)
		// 컴파일(저장시 자동 컴파일) 컴파일 된 클래스 파일이 실행됨
		// HelloWorld 프로젝트 - HelloWorld repository (git과 연결) - team > share project

	}
} // Hello 클래스 끝
