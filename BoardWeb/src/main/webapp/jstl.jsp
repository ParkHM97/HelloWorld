<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL연습</title>
</head>
<body>
	<!-- 1. JSTL 라이브러리 -->
	<!-- 2. JSTL 태그 지시자 선언 -->
	<c:set var="myName" value="Hong"></c:set>
	<!-- 변수선언, prefix에 지정한 문자와 동일해야 함-->
	<c:out value="${myName}"></c:out>
	<!-- 출력, 교재 12장 p415 -->

	<!-- myAge 변수에 20 값을 저장 -->
	<c:set var="myAge" value="20"></c:set>
	<br>
	<!-- h3 태그로 myAge 출력 -->
	<h3>
		<c:out value="${myAge}"></c:out>
	</h3>

	<!-- 조건문 -->

	<c:if test="${myAge >= 20}">
		<p>성인</p>
	</c:if>
	<!-- if else 구문 -->

	<c:choose>
		<c:when test="${myAge >= 20}">
			<p>성인입니다</p>
		</c:when>
		<c:otherwise>
			<p>미성년입니다</p>
		</c:otherwise>
	</c:choose>

	<!--  score에 85저장 -->
	<!-- score가 90이상이면 A, 80이상이면 B, 70이상이면 C, 그외 D -->
	<c:set var="score" value="85"></c:set>
	<c:choose>
		<c:when test="${score>=90}">
			<h3>
				<c:out value="A"></c:out>
			</h3>
		</c:when>
		<c:when test="${score>=80}">
			<h3>
				<c:out value="B"></c:out>
			</h3>
		</c:when>
		<c:when test="${score>=70}">
			<h3>
				<c:out value="C"></c:out>
			</h3>
		</c:when>
		<c:otherwise>
			<h3>
				<c:out value="D"></c:out>
			</h3>
		</c:otherwise>
	</c:choose>

	<!-- for if 반복문 -->
	<!-- 반복문 for(int i = 1; i <= 10; i++){}-->
	<!-- 태그 끝에 / 를 넣으면 끝나는 태그 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:if test="${i % 2==0}">
		<p>
			<c:out value="8 * ${i} = ${8 * i}" />
		</p>
		</c:if>
	</c:forEach>

</body>
</html>