package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.AddEventControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.CalendarDataControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartDataControl;
import com.yedam.control.FullCalendarControl;
import com.yedam.control.GetReplyCountControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.RemoveDataControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.addReplyControl;

/*
 * url pattern에서 ??.do => FrontControl을 실행 (.do요청이 들어오면 FrontControl)
 * 
 */
//서블릿
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
		//게시글 수정화면
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		//로그인 화면
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		// 로그아웃
		map.put("/logout.do", new LogoutControl());
		
		// 댓글 
		map.put("/replyList.do", new ReplyListControl()); // 댓글목록
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓글 한 건 삭제 
		map.put("/addReply.do", new addReplyControl()); // 댓글 등록
		map.put("/getCount.do", new GetReplyCountControl());
		
		// 구글 차트 
		map.put("/chart.do", new ChartControl());
		map.put("/chartData.do", new ChartDataControl());
		
		// fullcalendar
		map.put("/full.do", new FullCalendarControl());
		map.put("/fullData.do" , new CalendarDataControl()); // 목록
		map.put("/addEvent.do", new AddEventControl()); // 일정 등록
		map.put("/removeData.do", new RemoveDataControl());
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
