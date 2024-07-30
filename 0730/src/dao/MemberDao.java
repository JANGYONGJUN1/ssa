package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MemberDto;



public class MemberDao {
	// get Connection() : Connection 객체를 리턴.
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId = "user0112";
		String dbPw = "user1234";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 로그인
	public boolean loginCheck(String id, String pw) throws Exception {
		Connection conn = getConnection();
		String sql = "SELECT COUNT(*) FROM member where id= ? AND pw=?";
		
		// PrepareStatement 객체 얻고. & 물음표 셋팅
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2, pw);
		
		// 실행 -> return true / false
		ResultSet rs = pstmt.executeQuery();
		int result = 0;  // 0: 초기값(사실,1 이아닌 값이면 오케이)
		
		if(rs.next()) {
			result = rs.getInt(1);   // 첫번째 컬럼의  값.
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return result==1;
	}
	
	 // 모든 사용자 정보 가져오기 메서드
    public ArrayList<MemberDto> getAllMembers() throws Exception {
        Connection conn = getConnection();
        String sql = "SELECT * FROM member";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<MemberDto> members = new ArrayList<MemberDto>();

        while (rs.next()) {
        	String id = rs.getString("id");
            String pw = rs.getString("pw");
            String name = rs.getString("name");
            int point = rs.getInt("point");
            members.add(new MemberDto(id, pw, name, point));
        }
        rs.close();
        pstmt.close();
        conn.close();

        return members;
    }
	
	
	// 회원가입
	public void registerMember(String id, String pw, String name) throws Exception{
		Connection conn = getConnection();
		String sql = "INSERT INTO member(id, pw, name) VALUES(?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setNString(1, id);
		pstmt.setNString(2, pw);
		pstmt.setNString(3, name);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	// 업데이트
	public void updateMember(String id, String pw, String name, int point) throws Exception {
        Connection conn = getConnection();
        String sql = "UPDATE member SET pw = ?, name = ?, point = ? WHERE id = ?";
        
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setNString(1, pw);
        pstmt.setNString(2, name);
        pstmt.setInt(3, point);
        pstmt.setNString(4, id);
        
        pstmt.executeUpdate();
        
        pstmt.close();
        conn.close();
    }
	
	   public MemberDto getMemberById(String id) throws Exception {
	        Connection conn = getConnection();
	        String sql = "SELECT id, pw, name, point FROM member WHERE id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setNString(1, id);
	        
	        ResultSet rs = pstmt.executeQuery();
	        
	        MemberDto member = null;
	        if (rs.next()) {
	            String memberId = rs.getString("id");
	            String pw = rs.getString("pw");
	            String name = rs.getString("name");
	            int point = rs.getInt("point");
	            member = new MemberDto(memberId, pw, name, point);
	        }
	        
	        rs.close();
	        pstmt.close();
	        conn.close();
	        
	        return member;
	    }
	
	public static void main(String[] args) throws Exception {
		MemberDao dao = new MemberDao();
		System.out.println(dao.getAllMembers());
		
		
		
		// 회원가입 테스트
	    System.out.println("== 회원가입 테스트 ==");
	    dao.registerMember("testuser", "password123", "테스트 사용자");
	    System.out.println("회원가입 성공: testuser");

	    // 로그인 테스트
	    System.out.println("== 로그인 테스트 ==");
	    boolean loginSuccess = dao.loginCheck("testuser", "password123");
	    System.out.println("로그인 성공 여부: " + loginSuccess);

	    // 회원 정보 가져오기 테스트
	    System.out.println("== 회원 정보 가져오기 테스트 ==");
	    MemberDto member = dao.getMemberById("testuser");
	    if (member != null) {
	        System.out.println("회원 정보: " + member.getId() + ", " + member.getPw() + ", " + member.getName() + ", " + member.getPoint());
	    } else {
	        System.out.println("회원 정보를 찾을 수 없습니다: testuser");
	    }

	    // 모든 회원 정보 가져오기 테스트
	    System.out.println("== 모든 회원 정보 가져오기 테스트 ==");
	    ArrayList<MemberDto> allMembers = dao.getAllMembers();
	    for (MemberDto m : allMembers) {
	        System.out.println("회원: " + m.getId() + ", " + m.getPw() + ", " + m.getName() + ", " + m.getPoint());
	    }

	    // 회원 정보 업데이트 테스트
	    System.out.println("== 회원 정보 업데이트 테스트 ==");
	    dao.updateMember("testuser", "newpassword123", "업데이트된 사용자", 1000);
	    MemberDto updatedMember = dao.getMemberById("testuser");
	    if (updatedMember != null) {
	        System.out.println("업데이트된 회원 정보: " + updatedMember.getId() + ", " + updatedMember.getPw() + ", " + updatedMember.getName() + ", " + updatedMember.getPoint());
	    } else {
	        System.out.println("회원 정보를 찾을 수 없습니다: testuser");
	    }

	  
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
