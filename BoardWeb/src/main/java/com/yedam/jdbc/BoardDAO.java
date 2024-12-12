package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {

	// 회원정보 로그인 진행
	public String login(String id, String pw) {// 회원 이름 반영
		getConn();
		String sql = "SELECT * " //
				+ "  FROM tb1_member " //
				+ " WHERE member_id = ? " //
				+ "   AND password = ? "; //
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			// 결과조회
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_name"); // 아이디 비밀번호 있으면 멤버 이름 반환
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null; // 조회결과 없음
	}

	// 실제건수
	public int selectCount(SearchDTO search) { // 실제 게시글 만큼
		getConn();
		String sql = "SELECT COUNT(1) " //
				   + "  FROM tb1_board";
		if(search.getSearchCondition() !=null && search.getKeyword()!=null) {

			if (search.getSearchCondition().equals("T")) { // 검색 조건
				sql += "            WHERE title like '%'||?||'%'";
			} else if (search.getSearchCondition().equals("W")) {
				sql += "            WHERE writer like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("TW")) {
				sql += "            WHERE title like '%'||?||'%' "
				    + "                OR writer like '%'||?||'%' ";
				
			 } 
			}
		
		try {
			psmt = conn.prepareStatement(sql);
			int cnt = 1;
				if(search.getSearchCondition() !=null && search.getKeyword()!=null) {
				if (search.getSearchCondition().equals("T")) {
					psmt.setString(cnt++, search.getKeyword()); // 첫번째 파라미터 
				} else if (search.getSearchCondition().equals("W")) {
					psmt.setString(cnt++, search.getKeyword()); 
				} else if (search.getSearchCondition().equals("TW")) {// 첫번째, 두번째 파라미터 
					psmt.setString(cnt++, search.getKeyword());
					psmt.setString(cnt++, search.getKeyword());
				}
				} 

				System.out.println(sql);
				
				rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); // 아래 쪽수에 숫자 나오게 ...
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}

	// 수정기능 (글 내용, 제목) 잘 수정됐는지 확인하기 위해 리턴 타입은 boolean
	public boolean updateBoard(BoardVO board) { // 받아야 할 값이 많기 때문에 BoardVO, insert와 유사
		getConn();
		String sql = "UPDATE tb1_board " //
				   + "   SET title = ?, " //
				   + "       content = ? " //
				   + " WHERE board_no = ? "; //
		try {
			psmt = conn.prepareStatement(sql);
			// ?에 들어갈 값
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
			int r = psmt.executeUpdate(); // 쿼리 실행
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false; // firstServlet에서 호출
	}

	// 상세 조회 파라미터(int boardNo) selectBoard 반환값: BoardVO
	public BoardVO selectBoard(int boardNo) {
		getConn();
		String sql = "SELECT * FROM tb1_board WHERE board_no = ?  ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery(); // 조회했는데 있으면 while 안으로, 없으면 null 반환

			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getDate("creation_date"));
				brd.setUpdateDate(rs.getDate("update_date"));
				return brd;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 반드시 실행해야 할 거
			disConnect();
		}
		return null;
	}

	// BoardVO 파라미터 => 등록
	public boolean insertBoard(BoardVO board) {
		getConn();
		String sql = "INSERT INTO tb1_board " + "(board_no, title, content, writer) "
				+ "VALUES(board_seq.nextval, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			// ?에 들어갈 값
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate(); // 쿼리 실행
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false; // firstServlet에서 호출
	}

	// 목록 (parameter 매개변수)
	public List<BoardVO> boardList(SearchDTO search) { // ? 에 들어갈 값
		getConn();
		String sql = "SELECT b.* " //
				+ "     FROM (SELECT rownum rn, a.* " //
				+ "           FROM (SELECT * " //
				+ "                 FROM tb1_board "; //
		// Title 검색조건 => title 컬럼에서 값을 조회
		
		if(search.getSearchCondition() !=null && search.getKeyword()!=null) {

		if (search.getSearchCondition().equals("T")) { // 검색 조건
			sql += "            WHERE title like '%'||?||'%'";
		} else if (search.getSearchCondition().equals("W")) {
			sql += "            WHERE writer like '%'||?||'%' ";
		} else if (search.getSearchCondition().equals("TW")) {
			sql += "            WHERE title like '%'||?||'%' "
			    + "                OR writer like '%'||?||'%' ";
			
		 } 
		}
		    sql += "            ORDER BY board_no desc) a) b " //
				+  "    WHERE b.rn > (? - 1) * 5 " //
				+  "      AND b.rn <= ? * 5 "; // ? 는 페이지 번호를 의미

		List<BoardVO> result = new ArrayList<>(); // 반환값
		int cnt = 1; // parameter 순서를 지정하는 변수 선언
		try {
			psmt = conn.prepareStatement(sql);
			if(search.getSearchCondition() !=null && search.getKeyword()!=null) {
			if (search.getSearchCondition().equals("T")) {
				psmt.setString(cnt++, search.getKeyword()); // 첫번째 파라미터 
			} else if (search.getSearchCondition().equals("W")) {
				psmt.setString(cnt++, search.getKeyword()); 
			} else if (search.getSearchCondition().equals("TW")) {// 첫번째, 두번째 파라미터 
				psmt.setString(cnt++, search.getKeyword());
				psmt.setString(cnt++, search.getKeyword());
			}
			} 
			psmt.setInt(cnt++, search.getPage());
			psmt.setInt(cnt++, search.getPage());
			System.out.println(sql);
			
			rs = psmt.executeQuery(); // 쿼리 조회
			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getDate("creation_date"));
				brd.setUpdateDate(rs.getDate("update_date"));
				result.add(brd); // result에 추가
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 반드시 실행해야 할 거
			disConnect();
		}
		return result;
	}
}
