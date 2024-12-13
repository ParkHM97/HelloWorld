<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
String logId = (String) session.getAttribute("logId");
%>

<h3>게시글 등록화면(boardForm.jsp)</h3>
<form action="board.do" method="post" enctype="multipart/form-data"> <!--enctype : 파일 업로드하면서 추가 (바이너리) -->
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="25" rows="3" name="content"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" readonly value="${logId}"></td>
		</tr>
		<!-- 1213 이미지 추가 -->
		<tr>
			<th>이미지</th>
			<td><input type="file" name="img"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="게시글등록"></td>

		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>