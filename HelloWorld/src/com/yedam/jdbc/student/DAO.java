package com.yedam.jdbc.student;
/* db connect, db close
 * DAO 상속
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	// 쿼리실행 위해 필드 선언
	Connection conn = null;
	PreparedStatement psmt; // ? 에 데이터를 전달해 준다
	ResultSet rs;
	//연결 
	
	public void disConnect() { // 연결해제
		try {
			if(conn!=null)
			conn.close(); 
			if(psmt!=null)
			psmt.close();
			if(rs!=null)
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public Connection getConn() { // 반환값이 없으면 error
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj"); // Connection 객체 반환
																									// (2 매개값 : 접속자 / 3 매개값 : 비번)
		} catch (Exception e) {
			System.out.println("연결 중 에러 발생");
			e.printStackTrace(); //
		}
		return conn; // 정상 연결시 conn 반환
	}
}
