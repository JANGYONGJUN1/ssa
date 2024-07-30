<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String memberId = request.getParameter("id");
    MemberDao dao = new MemberDao();
    MemberDto member = null;

    if (memberId != null && !memberId.isEmpty()) {
        try {
            member = dao.getMemberById(memberId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h2 class="update-h2">회원관리 - 수정관리자</h2>
        <form action="UpdateMemberServlet" method="post" class="update-Form">
             <label for="id">ID</label>
            <input type="text" id="id" name="id" readonly value="<%= member != null ? member.getId() : "" %>"> <br/>
            <label for="pw">PW</label>
            <input type="password" id="pw" name="pw" value="<%= member != null ? member.getPw() : "" %>"> <br/>
            <label for="name">Name</label>
            <input type="text" id="name" name="name" value="<%= member != null ? member.getName() : "" %>"> <br/>
            <label for="point">point</label>
            <input type="number" id="point" name="point" value="<%= member != null ? member.getPoint() : 0 %>"><br/>
            <input type="submit" value="제출">
        </form>
    </div>
</body>
</html>