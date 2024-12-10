package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * url pattern에서 ??.do => FrontControl을 실행 (.do요청이 들어오면 FrontControl)
 * 
 */

public class FrontControl extends HttpServlet{
	
	Map<String, Control> map; //com.yedam.common의 interface
	
	public FrontControl() { // 생성자
		map = new HashMap<>(); // 필드 (클래스 안에 선언된), 필드값 초기화
	}
	@Override
	public void init(ServletConfig config) throws ServletException { //init
		map.put("/boardList.do", new BoardListControl()); // control 패키지 이후 추가함//목록, url에 / 필수
		map.put("/board.do", new BoardControl()); // 키와 value //상세
		//게시글 등록화면
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/board.do", new BoardControl());
		//
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http://localhost:80/BoardWeb/hello.do
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);
		//요청 url === 실행할 control (매칭)  ~ map
		Control control = map.get(path); //boardList.do < control에 담김 > exec라는 메소드가 반드시 있다 
		control.exec(req, resp);
		
	}//service
}
