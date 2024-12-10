<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.jdbc.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 자바 영역 -->
 <% 
  String msg = "Hello";
  System.out.println(msg);
 %>  
<!-- 자바 영역 -->
 <p>변수에 담긴 값은 <%=msg%></p> <!-- 자바의 값을 불러올 때는 < %= 사용 -->
 
 <%
 BoardDAO bdao = new BoardDAO(); // 끝에 ctrl+space => import
 List<BoardVO> list = bdao.boardList(); 
 
 for (BoardVO board : list){
 %>
 <p>글번호: <%=board.getBoardNo() %> 제목: <%=board.getTitle()%> 글내용: <%=board.getContent()%> 작성자: <%=board.getWriter()%></p>
 <%	} %>
 
</body>
</html>