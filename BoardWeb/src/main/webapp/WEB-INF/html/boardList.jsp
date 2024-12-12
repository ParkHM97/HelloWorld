<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- EL 사용 -->
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록(boardList.jsp)</h3>


<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<!-- 4는 너비 / 검색창-->
			<select name="searchCondition" class="form-control">
				<option value="">선택하세요</option>
				<!-- ne => not equals / eq => equals -->
				<option value="T"
					${!empty searchCondition and searchCondition eq 'T' ? 'selected' : ''}>제목</option>
				<option value="W"
					${searchCondition ne null && searchCondition == 'W' ? 'selected' : ''}>작성자</option>
				<option value="TW"
					${!empty searchCondition and searchCondition eq 'TW' ? 'selected' : ''}>제목
					& 작성자</option>
			</select>
		</div>
		<div class="col-sm-6">
			<input type="text" name="keyword"
				value=" ${keyword ne null ? keyword : ''} " class="form-control">
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
		<!-- 담아오는 attribute는 items -->

		<!-- empty 연산자 공백 확인 -->
		<c:forEach var="bvo" items="${list}">
			<tr>
				<td align="center"><a
					href="board.do?page=${paging.currentPage}&keyword=${empty keyword ? '': keyword}&searchCondition=${empty searchCondition ? '' : searchCondition}&board_no=${ bvo.getBoardNo()}">${ bvo.getBoardNo()}</a></td>
				<td><c:out value="${bvo.title}" /></td>
				<td><c:out value="${bvo.writer}" /></td>
				<td>${bvo.creationDate}</td>
			</tr>
		</c:forEach>
		<!--이 부분이 반복문으로 존재하는 글 만큼 나와야 함-->

	</tbody>

</table>
<!-- paging -->
<!-- 위에 선언된 sc와 kw -->

<nav aria-label="...">
	<ul class="pagination">

		<c:choose>
			<c:when test="${paging.prev}">
				<li class="page-item"><a class="page-link"
					href="boardList.do?page=${paging.getCurrentPage()}&keyword=${empty keyword ? '': keyword}&searchCondition=${empty searchCondition ? '' : searchCondition}&page=${paging.getStartPage() - 1}">이전</a></li>
				<!-- ?로 parameter 가져옴, &로 구분 -->
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">이전</span>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
			<c:choose>
				<c:when test="${paging.currentPage == p}">
					<li class="page-item active" aria-current="page"><span class="page-link">${p}</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="boardList.do?keyword=${empty keyword ? '': keyword}&searchCondition=${empty searchCondition ? '' : searchCondition}&page=${p}">${p}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<li class="page-item"><a class="page-link"
			href="boardList.do?keyword=${empty keyword ? '': keyword}&searchCondition=${empty searchCondition ? '' : searchCondition}&page=${paging.getEndPage() + 1}">다음</a></li>
	</ul>
</nav>
<!-- paging -->
<jsp:include page="../includes/footer.jsp"></jsp:include>