<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>글목록(boardList.jsp)</h3>
	<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
	// request.getAttribute("list") 가 반환하는 데이터 타입 : object (가장 상위)
	// 그래서 List<BoardVO>로 데이터 타입을 변경
	%>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(BoardVO bvo : list) { // list에 들어있는 개수만큼 반복하겠습니다
			%>
			<tr>
				<td align="center"><a href="board.do?board_no=<%=bvo.getBoardNo()%>"><%=bvo.getBoardNo() %></a></td>
				<td><%=bvo.getTitle() %></td>
				<td><%=bvo.getWriter() %></td>
				<td><%=bvo.getCreationDate() %></td>
			</tr>
			<!--이 부분이 반복문으로 존재하는 글 만큼 나와야 함-->
			<%
			} // for문 종료 
			%>
		</tbody>
		
	</table>

	<jsp:include page="../includes/footer.jsp"></jsp:include>