package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

@WebServlet("/second2") // 또는 web.xml에 추가
public class SecondServlet extends HttpServlet {

	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출"); // 2
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 호출"); // 3
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp); // 매개변수 
		System.out.println("service 호출"); // 4
		// html charset => 지정
		resp.setContentType("text/html;charset=utf-8"); // 아래에서 태그 사용 가능
		PrintWriter out = resp.getWriter();

		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList();

		out.print("<h3> 게시글 목록 </h3>");
		out.print("<table border='2'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr></thead>");
		out.print("<tbody>");
		for (BoardVO brd : list) {
			out.print("<tr><td><a href='FirstServlet?board_no="+brd.getBoardNo()+"'>" + brd.getBoardNo() + "</a></td><td>" + brd.getTitle() 
			        + "</td><td>" + brd.getWriter() + "</td><td>" + brd.getViewCnt() + "</td></tr>");
		}
		out.print("</tbody>");
		out.print("</table>");
	}
}
