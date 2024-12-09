package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {

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

	// 목록
	public List<BoardVO> boardList() {
		getConn();
		String sql = "SELECT * " + "  FROM tb1_board " + "ORDER BY board_no  ";
		List<BoardVO> result = new ArrayList<>(); // 반환값

		try {
			psmt = conn.prepareStatement(sql);
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
