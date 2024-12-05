package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// SQL Developer 작업 

public class JdbcExe2 {
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setLastName("park");
		emp.setEmail("park12@gmail.com");
		emp.setHireDate("2000-10-11");
		emp.setJobId("IT_PROG");
		insert(emp);
		select();
//		delete(211);
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
		String query = "delete from employees where employee_id = " + empId;
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
	public static void update(Employee emp) {
		Connection conn = getConn();
		String query = "update employees"
				+ "        set first_name = ?" // 쿼리가 길어질 때
				+ "          , phone_number = ?"
				+ "          , salary = ?"
				+ "     where  employee_id = ?";
				
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getLastName());
			stmt.setString(2, emp.getEmail());
			stmt.setString(3, emp.getHireDate());
			stmt.setString(4, emp.getJobId());
			int r = stmt.executeUpdate(query);
			System.out.println(r + " 건 처리됨"); // sql developer 에도 추가된 걸 확인할 수 있다.
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 입력 기능
	public static void insert(Employee emp) {
		Connection conn = getConn();
		String query = "insert into employees (employee_id"
				+ "               , last_name"
				+ "               , email"
				+ "               , hire_date"
				+ "               , job_id) "
				+ " values(employees_seq.nextval"
				+ "      , ?" // ? : 값이 아직 정해지지 않았다는 뜻
				+ "      , ?" //email
				+ "      , ?" // hire_date
				+ "      , ?)"; // job_id
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getLastName());
			stmt.setString(2, emp.getEmail());
			stmt.setString(3, emp.getHireDate());
			stmt.setString(4, emp.getJobId());
			int r = stmt.executeUpdate();
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
