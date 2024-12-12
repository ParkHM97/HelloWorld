package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정화면에서 submit 이벤트가 발생하면 데이터베이스의 정보를 수정
		// 정상적으로 수정이 완료되면 목록 이동
		// 수정에러가 발생하면 수정화면으로 이동
		String bno = req.getParameter("board_no");
		String title = req.getParameter("title");
		String content = req.getParameter("content"); // 수정한 값을 받아옴 
		// 20241212 추가 
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		// 위의 세 값을 아래에 담아줌
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		BoardDAO bdao = new BoardDAO();
		if(bdao.updateBoard(board)) {
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw); //페이지 재지정
		} else {
			req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);
		}
	}

}
