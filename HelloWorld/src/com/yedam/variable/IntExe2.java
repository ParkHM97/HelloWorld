package com.yedam.variable;

public class IntExe2 {
	public static void main(String[] args) {
		// 정수형 => byte(1바이트), short(2바이트), int(4바이트), 
		// long(8바이트), char(2바이트)
		// 1비트 * 8 => 1바이트
		byte b1 = 100;
		byte b2 = 100;
		//byte result = (int) b1 + (int) b2; // 정수 연산의 기본은 int기 때문에 + 연산시 int로 자동으로 바꿈 (형변환 casting)
		// int타입은 4바이트, byte는 1바이트이기 때문에 작은 값을 큰 값에 대입 X
		// -> int result로 사용해야 함
		int result = (int) b1 + (int) b2; 
		
		byte result2 = (byte) (b1 + b2); // 다시 byte 타입으로 변경... 200은 범위를 벗어남 (-128 ~ 127 ?? / 0포함)
		System.out.println(result2); // -56이 나온다.
		
		// 왜 -56이 나오는지 반복문 사용
		
		for(int i = 0; i < 100; i++) {
			System.out.println("b1의 값: " + ++b1);  // 127 이후 -128, -127이 된다.
		} // b1++ : 출력후 1씩 더함, ++b1 : 1씩 더한 후 출력 // 2진수 보수 > 0이면 1을, 1이면 0을 
		
		System.out.println(2147483647); // int 값의 최대 
		long l1 = 100000000000L; // 0 10개 이상 붙이려면 숫자 뒤에 L 또는 l 붙여야 함
		
		// 실수형 float(4바이트), double(8바이트)
		// 0 ~ 1사이의 모든 값
		double d1 = 0.1;
		double d2 = 0.2;
		double result3 = d1 + d2;
		System.out.println ("result3의 값: " + result3); // result3의 값: 0.30000000000000004
		System.out.println ("result3의 값: " + Math.floor(result3 * 10) / 10); // 0.3으로
		
		double[] doubleAry = { 10, 23.4, 11.7, 34.5 }; 
		// doubleAry의 합은 78.4입니다. 
		
		double sum = doubleAry[0] + doubleAry[1] + doubleAry[2] + doubleAry[3];
		System.out.println("doubleAry의 합은 " + sum + " 입니다.");
	}
}
