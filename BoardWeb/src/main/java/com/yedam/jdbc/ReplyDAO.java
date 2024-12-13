package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.ReplyVO;

// 댓글 (댓글 목록, 댓글 등록, 댓글 삭제, 댓글 수정)
public class ReplyDAO extends DAO {
	String query = "SELECT * " //
			+ "  FROM tb1_reply " //
			+ " WHERE board_no = ? " + " ORDER BY reply_no "; //
	String insertQuery = "INSERT INTO tb1_reply (reply_no, "//
			+ "                       reply, "//
			+ "                       replyer, "//
			+ "                       board_no ) " //
			+ "           VALUES (?, ?, ?, ?) ";//

	String deleteQuery = "DELETE FROM tb1_reply " //
					   + " WHERE reply_no = ? ";//

	
	// 댓삭
	public boolean deleteReply(int replyNo) { // 삭제 기능 만들기
//		ReplyDAO rdao = new ReplyDAO();
		getConn();
		try {
			psmt = conn.prepareStatement(deleteQuery);
			psmt.setInt(1, replyNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}
	// 댓글 등록
	public boolean insertReply(ReplyVO rvo) {
		getConn();
		try {
			psmt = conn.prepareStatement("SELECT reply_seq.nextval FROM dual");
			rs = psmt.executeQuery();
			int rno = 0; // sequence 생성해 rvo에 저장
			if(rs.next()) {
				rno = rs.getInt(1); System.out.println(rno);
				rvo.setReplyNo(rno);
			}
			
			psmt = conn.prepareStatement(insertQuery);
			
			psmt.setInt(1, rno);
			psmt.setString(2, rvo.getReply());
			psmt.setString(3, rvo.getReplyer());
			psmt.setInt(4, rvo.getBoardNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}



	public List<ReplyVO> selectList(int boardNo) {
		getConn();
		List<ReplyVO> rlist = new ArrayList<>(); // 반환될 컬렉션
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, boardNo);

			// 조회쿼리
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setReplyNo(rs.getInt("reply_no"));
				rvo.setReply(rs.getString("reply"));
				rvo.setReplyer(rs.getString("replyer"));
				rvo.setReplyDate(rs.getDate("reply_date"));
				rvo.setBoardNo(rs.getInt("board_no"));
				rlist.add(rvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return rlist;
	}
}
