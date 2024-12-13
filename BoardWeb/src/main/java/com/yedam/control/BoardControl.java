package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// GET 방식: 조회 & POST 방식: 등록
		// board.do를 조회와 등록으로 두 군데서 호출하고 있음
		BoardDAO bdao = new BoardDAO();
		if (req.getMethod().equals("GET")) {
			// 파라미터(board_no) + page + searchCondition + keyword
			String bno = req.getParameter("board_no"); // String 타입으로 들어옴 (3번), 몇 번 글에 대한 상세조회
			String page = req.getParameter("page");
			String sc = req.getParameter("searchCondition");
			String kw = req.getParameter("keyword");
	
			BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건 조회 (상세조회)

			req.setAttribute("board", bvo); // board에 조회된 결과값 전달함 (bvo)에 ?...
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			req.setAttribute("page", page);
			req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) { // 게시글 등록
			String savePath = req.getServletContext().getRealPath("images"); // webapp 아래에 images 폴더 생성 (여기에 올린 이미지 저장) 
			int maxSize = 1024 * 1024 * 5; // 총 5MB
			// multipart 요청
			MultipartRequest mr = new MultipartRequest(
					// 정보를 5가지 넘겨줘야 함 
					req,  // 요청 정보
					savePath, // 저장경로 
					maxSize, // 업로드 파일의 최대 크기 
					"utf-8", // 인코딩 방식
					new DefaultFileRenamePolicy() // 리네임정책 (같은 파일이 들어오면 원래 파일 삭제하면 안 됨)
					); 
			
			req.setCharacterEncoding("utf-8"); // 톰캣 9 / 한글 인코딩
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			String writer = mr.getParameter("writer");
			String img = mr.getFilesystemName("img"); // 중복 이름의 파일이 들어와서 바뀐 이룸이 들어오면 > getFilesystemName (리네임 정책으로 생성된 파일이름)
			
			BoardVO board = new BoardVO();
			board.setTitle(title); //초기값 없으면 에러
			board.setContent(content);
			board.setWriter(writer);
			board.setImg(img);
			
			if(bdao.insertBoard(board)) {
				//등록되면 목록 이동
				resp.sendRedirect("boardList.do");
			} else {
				//등록화면으로 이동
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);
			}
		}

	}

}
