<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ajax.jsp -->
	<script>
 // Asynchronous Javascript And xml // fetch 함수 
 	//fetch('replyList.do')
 	//.then(function(result){
 	//	console.log(result);
 	//	return result.json();
 //	})
 //	.then(function(result){ 		
 //		console.log(result); // {name:'홍길동', age:20}
 //		let p = document.createElement("p");
 //		p.innerText = '이름' + result.name + ', 나이' + result.age;
 //		document.querySelector('body').appendChild(p);
 //	})
 //	.catch(function(err){ // 에러 발생
 //		console.log(err);
 	//})
//;
 console.log('1');
 fetch('fullData.do')
 .then(result => result.json())
 .then(result => {
 console.log('2');
 })
 .catch(err => console.log(err));
 console.log('3');
 // 처리된 결과 > 1 > 3 > 2 
 
 </script>
</body>
</html>