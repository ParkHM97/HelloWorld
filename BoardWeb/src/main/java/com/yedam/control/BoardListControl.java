package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page"); // 페이지정보
		page = page == null ? "1" : page; // 값이 없으면 1
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword"); // 검색창 parameter
		
		// @AllArgsConstructor
		// 페이지, 검색조건, 키워드 => 게시글 목록 출력 
		SearchDTO search = new SearchDTO(Integer.parseInt(page), sc, kw);
		System.out.println(search);
		
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList(search); 
		// 실행 메소드. 여기서 또 정의할 필요는 없다(boardDAO에서 SearchDAO로 정의됨), 실제 값을 넣어야 한다 
		// argument(매개값)
		int totalCnt = bdao.selectCount(search);
		PageDTO pageDto = new PageDTO(Integer.parseInt(page), totalCnt);
		
		req.setAttribute("list", list);
		req.setAttribute("paging", pageDto);
		req.setAttribute("searchCondition", sc); // 검색후 아래의 쪽수를 누르면 검색한 것만큼 나오게 
		req.setAttribute("keyword", kw); // boardList로 보내는중

		req.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(req, resp);

	}// implements : 인터페이스 상속

}
