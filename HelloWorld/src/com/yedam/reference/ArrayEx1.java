package com.yedam.reference;

public class ArrayEx1 {
	public static void main(String[] args) { // int[] intAry intAry라는 int 타입 배열 선언
		int[] intAry = new int[5]; // 참조 타입은 new가 붙어야 한다. / 크기가 5인 배열
		// 위치 => 인덱스(0부터 시작)
		intAry[0] = 10; // 0번에 10번 대입 (타입이 달라서 intAry(정수를 담을 배열) = 10(정수)으로 대입 X
		intAry[1] = 20;

		// 배열의 크기 (length)
		System.out.println(intAry.length); // 5
		// 정수배열에서, 값을 담지 않은 곳에는 기본값으로 0이 들어간다 (실수배열 : 0.0)
		for (int i = 0; i < intAry.length; i++) {
			System.out.println("i의 값: " + i + ", 변수값: " + intAry[i]);
		}
		// 배열의 크기가 정해져 있는데 초과된 6번째 값을 입력하면 에러 발생
		// intAry [5] = 70;

		intAry[4] = 70;

		double[] dblAry = { 2.5, 1.2, 4, 5.6, 8 }; // 초기값 지정해 배열 선언 가능 (타입이 동일한 값만 입력해야 함, 문자값 X)

//		for(double i = 0; i < dblAry.length; i++) { // 실수 타입이니까 변수 double i로 선언
//			System.out.println("i의 값: " + i + ", 변수값: " + dblAry[i]);
//		} 
		// 값 변경
		dblAry[1] = 9.9;

		// dblAry = {2.3, 6.7}; // 이미 변수가 있는 상태에서 이렇게 재배열하면 오류가 난다
		// 재선언
		dblAry = new double[] { 2.3, 6.7 }; // 변수 선언 후 값을 할당

		for (int i = 0; i < dblAry.length; i++) { 
			System.out.println("i의 값: " + i + ", 변수값: " + dblAry[i]);
		}
		// 문자열 배열
		String[] strAry = { "홍길동", "김민섭", "박창규" };
		// enhanced for 
		for(String str : strAry) { // 배열에 있는 개수만큼만 반복
			System.out.println(str);
		}
	}

}
