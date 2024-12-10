package com.yedam;

import java.io.IOException;
import java.util.List;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardList.action") //boardList.action 실행시 이쪽으로 이동 
public class BoardListServ extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 목록 가져오는 기능
		BoardDAO bdao = new BoardDAO();
		//요청 재지정(BoardList를 JSP에 전달하고 전달값을 HTML 에 그려줌)
		List<BoardVO> boardList = bdao.boardList();
		//요청 객체에 boardList의 정보를 담아서 JSP 페이지로 전달
		req.setAttribute("list", boardList);
		
		req.getRequestDispatcher("html/boardList.jsp").forward(req, resp);
		// 보여줄 page : HTML 폴더 아래 boardList / URL 에 boardList.action를 입력하면 JSP 안의 글목록이 반환됨
		
	} //service 메소드 종료 
}
