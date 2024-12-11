<%@page import="com.yedam.common.PageDTO"%>
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
<form action="boardList.do">
<div class="row">
	<div class="col-sm-4">
		<!-- 4는 너비 -->
		<select name="searchCondition" class="form-control">
			<option value="">선택하세요</option>
			<option value="T">제목</option>
			<option value="W">작성자</option>
			<option value="TW">제목 & 작성자</option>
		</select>
	</div>
	<div class="col-sm-6">
		<input type="text" name="keyword" class="form-control">
	</div>
	<div class="col">
		<input type="submit" value="검색" class="form-control">
	</div>
</div>
</form>


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
		for (BoardVO bvo : list) { // list에 들어있는 개수만큼 반복하겠습니다
		%>
		<tr>
			<td align="center"><a
				href="board.do?board_no=<%=bvo.getBoardNo()%>"><%=bvo.getBoardNo()%></a></td>
			<td><%=bvo.getTitle()%></td>
			<td><%=bvo.getWriter()%></td>
			<td><%=bvo.getCreationDate()%></td>
		</tr>
		<!--이 부분이 반복문으로 존재하는 글 만큼 나와야 함-->
		<%
		} // for문 종료
		%>
	</tbody>

</table>
<!-- paging -->
<%
PageDTO paging = (PageDTO) request.getAttribute("paging");
%>
<p><%=paging%></p>
<nav aria-label="...">
	<ul class="pagination">
		<%
		if (paging.isPrev()) {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=paging.getStartPage() - 1%>">이전</a></li>
		<%
		} else {
		%>
		<li class="page-item disabled"><span class="page-link">이전</span>
		</li>
		<%
		}
		for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
		if (paging.getCurrentPage() == p) {
		%>
		<li class="page-item active" aria-current="page"><span
			class="page-link"><%=p%></span></li>
		<%
		} else {
		%>
		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=p%>"><%=p%></a></li>

		<%
		} // end of if 

		} // end of for
		%>

		<li class="page-item"><a class="page-link"
			href="boardList.do?page=<%=paging.getEndPage() + 1%>">다음</a></li>
	</ul>
</nav>
<!-- paging -->
<jsp:include page="../includes/footer.jsp"></jsp:include>