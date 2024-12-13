package com.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글 -> 자바스크립트 object -> 문자열 : json
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
//		let obj = { name: "홍길동", age:20 } // 자바 스크립트의 객체 (obj)
//		-> 문자열로 ~~ JSON.stringify()
//		-> {"name":"홍길동", "age": 20} //데이터 타입 : JSON

		ReplyDAO rdao = new ReplyDAO();
		List<ReplyVO> list = rdao.selectList(Integer.parseInt(bno));
		String json = "[";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"replyNo\": " + list.get(i).getReplyNo()//
					+ ", \"reply\":\"" + list.get(i).getReply() + "\"" //
					+ ", \"replyer\":\"" + list.get(i).getReplyer() + "\"" //
					+ ", \"replyDate\":\"" + list.get(i).getReplyDate() + "\"}"; //
			if(i + 1 != list.size()) { // 마지막이 아니면 , 추가
				json += ","; // [{}, {}, {}] 형식
			} 
		}
		json += "]";
//		String json = "[{ \"name\":\"홍길동\", \"age\":20 }, "
//					+ "{ \"name\":\"홍길동\", \"age\":20 }, "
//					+ "{ \"name\":\"홍길동\", \"age\":20 }, "
//					+ "{ \"name\":\"홍길동\", \"age\":20 } ]";

		resp.getWriter().print(json);
	}

}
