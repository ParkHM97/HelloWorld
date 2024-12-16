
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글상세(board.jsp)</h3>

<form action="modifyForm.do">
	<input type="hidden" name="board_no" value="${board.boardNo}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}"> <input
		type="hidden" name="page" value="${page}">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo}</td>
			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
			<th>이미지</th>
			<td><img src="images/${board.img}" width="100px"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="5" readonly class="form-control">${board.content}</textarea>
			</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${board.creationDate}</td>
			<th>조회수</th>
			<td>${board.viewCnt}</td>
		</tr>
		<tr>
			<!-- // 로그인 상태라면 권한에 따라 활성화/비활성화 -->
			<!--로그인 상태가 아니면 권한 없음-->
			<c:choose>
				<c:when test="${logId ne null and board.writer == logId }">
					<td colspan="4" align="center"><input type="submit"
						class="btn btn-warning" value="수정화면"></td>
				</c:when>
				<c:otherwise>
					<td colspan="4" align="center"><input type="submit"
						class="btn btn-warning" value="수정화면" disabled></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</form>

<!-- 댓글 시작 -->
<style>
div.reply .content ul{
	list-style-type: none;
}
div.reply .content span{
	display:inline-block;
}
</style>
<div class="reply">
	<div class="header"></div> <!-- 댓글 등록 -->
	댓글내용 : <input type="text" id = "reply" class="col-sm-8" >
	<button id="addBtn" class="col-sm-2 btn btn-primary">댓글등록</button>
	<div class="content">	<!-- 댓글 목록 -->
		<ul>
			<li>
				<span class="col-sm-2">글번호</span>
				<span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-2">삭제</span>
			</li>
		</ul>
		<ul class="list"></ul>
	</div>
	<div class="footer"><nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>	<!-- 댓글 paging -->
</div>
<!-- 댓글 끝 -->
<script> 
	let bno = "${board.boardNo}"; // 원본글 번호
	let logId = "${logId}"; // 작성자
</script>
<script src="js/board.js"></script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
