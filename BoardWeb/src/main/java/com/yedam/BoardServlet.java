package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

/*
 * HttpServlet 상속
 * service() 재정의(override)
 * parameter(board_no)값을 받아서 상세조회
 * attribute(board)를 담아서 board.jsp에 전달하고 
 * board.jsp에서는 전달받은 값을 출력하기 
 */

@WebServlet("/board.action")
public class BoardServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String bno = req.getParameter("board_no"); // String 타입으로 들어옴 (3번), 몇 번 글에 대한 상세조회 
	 BoardDAO bdao = new BoardDAO();
	 BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건 조회 (상세조회)
	 
	 req.setAttribute("board", bvo); //board에 조회된 결과값 전달함 (bvo)에 ?...
	 req.getRequestDispatcher("html/board.jsp").forward(req, resp);
	}
}
