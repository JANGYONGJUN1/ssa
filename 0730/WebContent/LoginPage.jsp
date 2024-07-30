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
				location.href="JoinPage.jsp";
			});
		});
	</script>
</head>
<body>
<form action="LoginCheckServlet0730" method="post">
	<div class="login-container">
	    <h2>로그인</h2>
	    <div class="input-group">
		      ID:  <input type="text" id="id" name="id">
		      PW: <input type="password" id="pw" name="pw">
		    <button type="submit" > 로그인</button>
		    <button type="button" id="join">회원가입</button>
	    </div>
	</div>
</form>
</body>
</html>