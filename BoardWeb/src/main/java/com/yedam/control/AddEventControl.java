package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("a"); // 휴가 ? 와 &를 사용해 url로 입력...
		String sd = req.getParameter("b"); // 2024-12-11
		String ed = req.getParameter("c"); // 2024-12-14
		
		ReplyDAO rdao = new ReplyDAO();
		Map<String, String> inputVal = new HashMap<>();
		inputVal.put("title", title);
		inputVal.put("start", sd);
		inputVal.put("end", ed);	
	
		if (rdao.insertEvent(inputVal)) {
			// {"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		} else {
			// {"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}
}
