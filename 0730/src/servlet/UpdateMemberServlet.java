package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 폼 데이터 받기
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        int point = Integer.parseInt(request.getParameter("point"));

        MemberDao dao = new MemberDao();
        
        try {
            dao.updateMember(id, pw, name, point);
            response.sendRedirect("adminPage.jsp"); 
        } catch (Exception e) {
            e.printStackTrace();
	        }
	  }
}
