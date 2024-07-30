<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<link rel="stylesheet" href="0730test.css"/>
	<script>
		$(function(){
			$("#join").click(function(){
				alert("가입되었습니다. 로그인 해주세요.")	
			});
		});
	</script>
</head>
<body>
<form action="JoinServlet" method="post">
	<div class="register-container">
	    <h2>회원가입</h2>
	    <div class="input-group-join">
	       ID: <input type="text" id="id" name="id">
	       PW:  <input type="password" id="pw" name="pw">
	       Name: <input type="text" id="name" name="name">
	    </div>
	    <button type="submit">작성완료</button>
	</div>
</form>
</body>
</html>