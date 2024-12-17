package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class RemoveDataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("a");
		String sd = req.getParameter("b");
		String ed = req.getParameter("c");
		ReplyDAO rdao = new ReplyDAO();
		Map <String, String> deleteVal = new HashMap<>();
		deleteVal.put("title", title);
		deleteVal.put("start", sd);
		deleteVal.put("end", ed);
		
		if (rdao.removeData(deleteVal)) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		} else {
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
	}

}
