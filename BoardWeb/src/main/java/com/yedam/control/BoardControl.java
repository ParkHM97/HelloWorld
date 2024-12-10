package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// GET 방식: 조회 & POST 방식: 등록
		// board.do를 조회와 등록으로 두 군데서 호출하고 있음
		BoardDAO bdao = new BoardDAO();
		if (req.getMethod().equals("GET")) {
			String bno = req.getParameter("board_no"); // String 타입으로 들어옴 (3번), 몇 번 글에 대한 상세조회
			BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건 조회 (상세조회)

			req.setAttribute("board", bvo); // board에 조회된 결과값 전달함 (bvo)에 ?...
			req.getRequestDispatcher("html/board.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			
			BoardVO board = new BoardVO();
			board.setTitle(title); //초기값 없으면 에러
			board.setContent(content);
			board.setWriter(writer);
			
			if(bdao.insertBoard(board)) {
				//등록되면 목록 이동
				resp.sendRedirect("boardList.do");
			} else {
				//등록화면으로 이동
				req.getRequestDispatcher("html/boardForm.jsp").forward(req, resp);
			}
		}

	}

}
