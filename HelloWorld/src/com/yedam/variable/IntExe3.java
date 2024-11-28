package com.yedam.variable;

public class IntExe3 {
	public static void main(String[] args) {
		boolean b1 = true; // 참 거짓 타입
		b1 = 10 > 20;
		
		char c1 = 0; // unicode 코드값을 매핑 
		c1 = 65; // 'A'; (char 65 = 'A') / 'Z'는 90
		System.out.println(c1);
		
		char c3 = 0;
		c3 = 90;
		System.out.println(c3);
		
//		for(int i = 1; i < 100; i++) {			
//			System.out.println(c1++);
//		}
		char c2 = '궵';  // "Hello" ("" > 문자열 / '' > 캐릭터 타입)
		System.out.println((int)c2); //44032에 '가'
		
		//
		int n1 = 1;
		int n2 = 2; 
		double result4 = n1 / n2; // 예상 : 0.5
	
		
		System.out.println("n1 나누기 n2의 값 :" + result4); // 0.0
		
		
		int n1 = 1;
		int n2 = 2; // 1을 2로 나누면 0.5일 것 같지만 0.0이 나온다... 0.5라는 값이 0으로 처리가 됨 > 그리고 그 0을 double 타입에 넣어서 0.0이 된다
		double result4 = n1 * 1.0 / n2; // 자바에서는 같은 타입끼리만 계산함 
		// n1은 4바이트 / 1.0은 8바이트 > 그래서 n1을 8바이트(double로 바꿈) / 
		// n1은 double 타입으로 형변환됨 (내부적 형변환 / 자동 형변환)
		// n1의 타입 > double / n2도 n1으로 인해 double타입이 된다.
		// 작은 값은 큰 값으로 자동 형변환이 되지만 반대는 안 됨
		
		System.out.println("n1 나누기 n2의 값 :" + result4); // 근데 결과는 0.0이 나온다
		// byte < short < int < long < float < double 
		
	}
}
