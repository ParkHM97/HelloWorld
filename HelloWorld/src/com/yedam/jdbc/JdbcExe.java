package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// SQL Developer 작업 

public class JdbcExe {
	public static void main(String[] args) {
//		insert(); //insert는 한번만 (두번 하면 오류남 / employee_id는 고유키라서 
//		insert("Park", "2024-02-03", "IT_PROG", "Changsik@email2");
//		update(210, "Changsik", "010-1111-1111", 7700);
		select();
		delete(211);
		System.out.println("프로그램 끝");
	}


	// DB 연결
	public static Connection getConn() { // 반환값이 없으면 error
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // Connection 객체 반환
																									// (2 매개값 : 접속자)
		} catch (Exception e) {
			System.out.println("연결 중 에러 발생");
			e.printStackTrace(); //
		}
		return conn; // 정상 연결시 conn 반환
	}
	
	// 삭제기능
	public static void delete(int empId) {
		Connection conn = getConn();
		String query = "delete from employees where employee_id = " + empId ;
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + " 건 처리됨"); // sql developer 에도 추가된 걸 확인할 수 있다.
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 수정기능
	public static void update(int empId, String fname, String pno, int sal) {
		Connection conn = getConn();
		String query = "update employees"
				+ "        set first_name = '" + fname + "'" // 쿼리가 길어질 때
				+ "          , phone_number = '" + pno + "'"
				+ "          , salary= '" + sal + "'"
				+ "     where  employee_id = " + empId + "";
				
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + " 건 처리됨"); // sql developer 에도 추가된 걸 확인할 수 있다.
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 입력 기능
	public static void insert(String lastName, String hdate, String job, String email) {
		Connection conn = getConn();
		String query = "insert into employees (employee_id"
				+ "               , last_name"
				+ "               , email"
				+ "               , hire_date"
				+ "               , job_id) "
				+ " values(employees_seq.nextval"
				+ "      , '" + lastName + "'" //last_name
				+ "      , '" + email + "'" //email
				+ "      , '" + hdate + "'" // hire_date
				+ "      , '" + job + "')"; // job_id
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + " 건 처리됨"); // sql developer 에도 추가된 걸 확인할 수 있다. employees_seq.nextval : 고유키를 자동으로 다음 값으로 지정함
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


// sql developer 조회 기능
	public static void select() {
		Connection conn = getConn(); // 메소드로 connection 객체

//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // Connection 객체 반환 (2 매개값 : 접속자)
//			// sql 작성 Statement 객체 
		try { // 예외 구문
			Statement stmt = conn.createStatement();
			// 조회
			ResultSet rs = stmt.executeQuery("select * from employees order by employee_id desc"); // 조회하는 쿼리 (내림차순) (sql developer)
			// 결과출력

			while (rs.next()) { // 가져온 데이터 만큼 반복
				System.out.println(rs.getInt("employee_id") + ", " + rs.getString("first_name") + ", " //
						+ rs.getString("email"));
			}
			conn.close(); // 연결 해제
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("== end of data ==");
//		} catch (Exception e) {
//			// 예외 발생시 실행할 명령 
//			System.out.println("드라이버 로드 중 에러 발생");
//		}
	}
}
