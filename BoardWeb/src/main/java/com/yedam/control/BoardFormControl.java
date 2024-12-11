package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardFormControl implements Control { // 등록하는 화면만 열어준다 
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//등록하면 호출
		req.getRequestDispatcher("html/boardForm.jsp").forward(req, resp);
	
	}
}
