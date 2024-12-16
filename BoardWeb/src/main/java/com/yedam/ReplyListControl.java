package com.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글 -> 자바스크립트 object -> 문자열 : json
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
//		let obj = { name: "홍길동", age:20 } // 자바 스크립트의 객체 (obj)
//		-> 문자열로 ~~ JSON.stringify()
//		-> {"name":"홍길동", "age": 20} //데이터 타입 : JSON

		ReplyDAO rdao = new ReplyDAO();
		List<ReplyVO> list = rdao.selectList(Integer.parseInt(bno), Integer.parseInt(page));
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list); // 자바 객체 > json 문자열 반환


//		String json = "[{ \"name\":\"홍길동\", \"age\":20 }, "
//					+ "{ \"name\":\"홍길동\", \"age\":20 }, "
//					+ "{ \"name\":\"홍길동\", \"age\":20 }, "
//					+ "{ \"name\":\"홍길동\", \"age\":20 } ]";

		resp.getWriter().print(json);
	}

}
