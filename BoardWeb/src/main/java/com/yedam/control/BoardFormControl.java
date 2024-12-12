package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class BoardFormControl implements Control { // 등록하는 화면만 열어준다 
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//등록하면 호출
		req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);
	
	}
}
