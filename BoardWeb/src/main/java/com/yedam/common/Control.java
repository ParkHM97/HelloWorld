package com.yedam.common;
/*
 * 인터페이스는 구현클래스를 통해 실제 기능이 정의된다. 
 * 인터페이스는 규칙만 제시함 
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp) // 리턴타입 void / 메소드의
			throws ServletException, IOException;
}
