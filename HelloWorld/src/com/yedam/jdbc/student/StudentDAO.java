package com.yedam.jdbc.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * DAO: Data Access Object
 * 입력, 수정, 삭제, 조회(목록 조회, 단건 조회) 기능
 */
public class StudentDAO extends DAO { // DAO를 상속받음
	
	// 상세조회
	// 반환: Student 클래스, 매개: 학생번호, 메소드: selectStudent 
	
	
	// 로그인 login() => 반환: boolean, 매개값: id, password (있으면 true 없으면 false)
	
	public String login(String id, String pw) {
		getConn();
		String sql = "SElECT *"//
				+ "     FROM tb1_member"//
				+ "    WHERE member_id = ?"//
				+ "      AND password = ?";//
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getString("member_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		} return null;// 조회된 결과가 없을 경우 null 반환			
		}

	public Student selectStudent(String sno) {
		getConn();
		String sql = "SELECT * FROM tb1_student WHERE std_no= ?";
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, sno);
			rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
				Student std = new Student();
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				std.setStdPhone(rs.getString("std_phone"));
				std.setEngScore(rs.getInt("eng_score)"));
				std.setMathScore(rs.getInt("std_name"));
				return std;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
	
	// 점수등록
	//반환값:boolean, 매개값: Student, 메소드명:updateStudent
	
	public boolean updateStudent(Student std) {
		getConn();
		String sql = "UPDATE tb1_student" // 
				+    "   SET eng_score = ?," // 
				+    "       math_score = ?" // 
				+    "WHERE std_no = ?"; // 
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, std.getEngScore()); //  std_name 
			psmt.setInt(2, std.getMathScore()); 
			psmt.setString(3, std.getStdNo()); // std_no에 값 추가
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	
	
	// 등록(MainExe) 반환값:boolean, 매개값: Student, 메소드명:insertStudent
	public boolean insertStudent(Student std) {
		getConn(); // 연결
		String sql = "insert into tb1_student(std_no" // 
				+ "                          ,std_name" // 
				+ "                          ,std_phone)" // 
				+ "   values(?, ?, ?)"; // 실행할 쿼리 입력
		
		try { // 예외처리 
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo()); // std_no에 값 추가
			psmt.setString(2, std.getStdName()); //  std_name 
			psmt.setString(3, std.getStdPhone()); //  std_phone
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true; // 정상등록
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return false;
	}
	
	// 학생 목록 반환
	// 검색조건 (학생이름, 연락처, 영어, 수학 검색조건 + 정렬기준) // 1206
	public ArrayList<Student> studentList(Search search) {
		getConn();
		// 조회 결과 반환
		ArrayList<Student> studList = new ArrayList<Student>();
		String sql = "SELECT std_no, " // 
				+ "          std_name, " // 
				+ "          std_phone," // 
				+ "          eng_score, " // 
				+ "          math_score, " //
//				+ "          TO_CHAR(creation_date, 'yyyy-mm-dd hh24:mi:ss') creation_date"
				+ "          creation_date" // 
				+ "     FROM tb1_student" // 
				+ "    WHERE std_name LIKE '%'||?||'%'" // 
				+ "      AND std_phone LIKE '%'||?||'%'" // 
				+ "      AND eng_score >= ?"; // 
				if (search.getOrderBy().equals("std_no")) { // 정렬방식은 if 조건문을 사용해야 한다
					sql += "ORDER BY std_no";
				} else if (search.getOrderBy().equals("std_name")) {
					sql += "ORDER BY std_name";
				}
		
//		+ "      AND std_phone LIKE '%'||?||'%'"
		try {// 정상실행
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환
			psmt.setString(1, search.getName()); // 이름으로 조건 
			psmt.setString(2, search.getPhone());
			psmt.setInt(3, search.getEngScore());
			rs = psmt.executeQuery();

			while (rs.next()) {// next라는 메소드가 ResultSet에 들어있는 만큼 반복시킴
				Student stud = new Student();
				stud.setStdNo(rs.getString("std_no"));
				stud.setStdName(rs.getString("std_name"));
				stud.setStdPhone(rs.getString("std_phone"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setMathScore(rs.getInt("math_score"));
				stud.setCreationDate(rs.getDate("creation_date"));
				studList.add(stud); // ArrayList에 추가
			}
		} catch (SQLException e) {// 예외발생시 실행
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect(); // 연결해제
		}
		return studList;
	}
}
