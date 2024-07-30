<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
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
			$(".logout-btn").click(function(){
				alert("로그아웃 되었습니다.");
				location.href="LoginPage.jsp";
			});
			$(".img2,.img3").click(function(){
				alert("포인트가 부족합니다. 광고를 클릭하세요.")
			});
			$(".img1").click(function(){
				alert("컨텐츠(intro)를 구입하였습니다.")
			});
			$("#footer").click(function(){
				alert("점이 적립되었습니다");
			});
		});
	</script>
	
	<%
		MemberDao dao = new MemberDao();
		ArrayList<MemberDto> dto = new ArrayList<MemberDto>();
	
	%>
</head>
<body>
	<div id="main-page" class="border">
		<div id="header">
			<div id="header-inner">
				<h1 class="main-text">메인페이지</h1>
			</div>
			<div class="right-header">
				<h3 class="users">김(ma)님 안녕하세요.</h3>
				<button class="logout-btn">로그아웃</button>
			</div>
		</div>
		<h3 class="point">포인트 : 126019점</h3>
		<div style="clear:both;"></div>
		<h2 id="title">구입할 컨텐츠를 선택하세요.</h2>
		<div id="content-box">
			<div class="text-center">
				<img class="img1" style="width:420px;" src="img/Intro_350_408.png"/> 
				<span>100,000포인트</span>
			</div>
			<div class="text-center">
				<img class="img2" style="width:420px;" src="img/Java_350_408.png"/>
				<span>500,000포인트</span>
			</div>
			<div class="text-center">
				<img class="img3" style="width:420px;" src="img/Cpp_350_408.png"/>
				<span>300,000포인트</span>
			</div>
		</div>
		<div id="footer" class="border">
			<span> <광고> </span>
			<img src="img/korea_it.png"/>
		</div>
	</div>
</body>
</html>