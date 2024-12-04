package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance(); // 인스턴스 생성
		cal.set(2024, 9, 1); // 년 월 일
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "요일");
		System.out.println(cal.getActualMaximum(Calendar.DATE) + "막날");
		createCalendar(6, 30); // 1일이 금요일
	}

	// 달력 > 1일과 마지막날을 알면 만들 수 있다
//	static void createCalendar(int positionOfDay, int lastDate) {
	static void createCalendar(int year, int month) {
		int positionOfDay = 0;
		int lastDate = 0;
		
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		// 1일의 위치 지정
//		for (int i = 1; i < positionOfDay; i++) {
		for (int i = 1; i < positionOfDay; i++) {
			System.out.printf("%4s", " "); // 1일이 일요일이 아닐수도 있으니까...공란만큼 밀어줌
		}
		// 날짜출력
		for (int d = 1; d <= lastDate; d++) {
			System.out.printf("%4d", d);
			if ((d + positionOfDay - 1) % 7 == 0) { // 7개마다 줄바꿈
				System.out.println();
			}
		}
	}
}
