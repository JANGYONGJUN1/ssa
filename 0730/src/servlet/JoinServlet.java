package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 요청 인코딩 설정
	        request.setCharacterEncoding("UTF-8");

	        // 폼 데이터 받기
	        String id = request.getParameter("id");
	        String pw = request.getParameter("pw");
	        String name = request.getParameter("name");

	        MemberDao dao = new MemberDao();
	        
	        try {
	            dao.registerMember(id, pw, name);  // MemberDao의 메서드 호출
	            // 성공 시 알림 창을 띄우고 페이지를 리디렉션하는 응답을 보냄
	            response.setContentType("text/html; charset=UTF-8");
	            response.getWriter().println("<html><body><script>alert('회원가입이 완료되었습니다.'); window.location.href='LoginPage.jsp';</script></body></html>");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
