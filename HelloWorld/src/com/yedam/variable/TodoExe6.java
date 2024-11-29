package com.yedam.variable;

public class TodoExe6 {
	public static void main(String[] args) {
		int four = 4;
		int five = 5;

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {

				if (four * x + five * y == 60) {

					System.out.printf("(%1d, %1d)", x, y);

				} 

			}
		}
	}
}
