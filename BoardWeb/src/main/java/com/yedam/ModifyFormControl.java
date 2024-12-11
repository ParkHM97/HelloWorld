package com.yedam;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//상세보기 > 수정 > 저장 
		//게시글 15번에 대한 조회결과 html/modifyForm.jsp 출력
		//수정항목은 제목, 내용으로 제한
		String bno = req.getParameter("board_no"); // 현재 내가 수정하려고 누른 글의 번호가 넘어옴 
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 한 건 조회 (BoardDAO)
		
		// 조회한 board정보를 JSP 페이지에 전달 
		req.setAttribute("board", bvo);
		req.getRequestDispatcher("html/modifyForm.jsp").forward(req, resp);
	}

}
