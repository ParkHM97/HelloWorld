<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글수정화면(modifyform.jsp)</h3>
<%
BoardVO bvo = (BoardVO) request.getAttribute("board");
%>
<form action="modifyForm.do">
<input type="hidden" name="board_no" value="<%=bvo.getBoardNo()%>"> 
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=bvo.getBoardNo()%></td>
			<th>작성자</th>
			<td><%=bvo.getWriter()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title" value="<%=bvo.getTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea rows="5" class="form-control" name="content"><%=bvo.getContent()%></textarea>
			</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=bvo.getCreationDate()%></td>
			<th>조회수</th>
			<td><%=bvo.getViewCnt()%>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit"
				class="btn btn-warning" value="저장"></td>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>
