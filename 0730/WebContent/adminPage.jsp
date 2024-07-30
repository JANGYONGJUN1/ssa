<%@page import="dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDao dao = new MemberDao();
    ArrayList<MemberDto> list = dao.getAllMembers();
    
    String id = request.getParameter("loginId");
    session.getAttribute(id);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<link rel="stylesheet" href="0730test.css"/>
</head>

<body>
<div class="admin-container">
    <h2>회원관리</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>PW</th>
                <th>Name</th>
                <th>Point</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
        <%for (MemberDto dto : list) {%>
	        <form action ="UserUpdate0730.jsp" method="post">
	            <tr>
	                <td><%=dto.getId() %></td>
	                <td><%=dto.getPw()%></td>
	                <td><%=dto.getName() %></td>
	                <td><%=dto.getPoint() %></td>
	                <td><button id="update" type="submit">수정</button></td>
	                <td><button class="delete-btn">삭제</button></td>
	            </tr>
	         </form>
         <%} %>
        </tbody>
    </table>

    <div class="scheduler">
        <h2>스케줄러관리</h2>
        <form action="StartSchedulerServlet" method="post">
            <button class="admin-button" type="submit">스케줄러(20초마다 포인트 1 증가) 실행 시작</button>
        </form>
        <form action="StopSchedulerServlet" method="post">
            <button class="admin-button" type="submit">스케줄러 실행 종료</button>
        </form>
    </div>
</div>
</body>
</html>