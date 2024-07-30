package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.MemberDao;

@WebServlet("/LoginCheckServlet0730")
public class LoginCheckServlet0730 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        MemberDao dao = new MemberDao();
        boolean result = false;

        try {
            result = dao.loginCheck(id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == true && "admin".equals(id)) {
        	// 관리자 계정이면 관리자 페이지로 이동
            HttpSession session = request.getSession();
            session.setAttribute("loginId", id);
            session.setAttribute("loggedIn", true);
	        RequestDispatcher rd = request.getRequestDispatcher("/adminPage.jsp");
	        rd.forward(request, response);
	    } else {
	        // 일반 사용자 계정이면 메인 페이지로 이동
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginId", id);
	    	session.setAttribute("loggedIn", true);
	        RequestDispatcher rd = request.getRequestDispatcher("/MainPage0730.jsp");
	        rd.forward(request, response);
	    }
    }
}
