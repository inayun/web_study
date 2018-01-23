package bbs;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



@WebServlet("/VisitInsert")
public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8"); //한글,영어 다 지원
		
		//client가 http 요청으로 전송한 값 읽기
		
		String writer = request.getParameter("writer");
		String memo = request.getParameter("memo");
		
		System.out.println("작성자 :" + writer);
		System.out.println("메모 :" + memo);
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into visit(no, writer, memo, regdate) ");
		sql.append("values(visit_seq.nextVal,?,?,sysdate)");

		//디비연결
		Connection con = null;
		PreparedStatement pstmt = null;
		String url="";
		String user="";
		String password="";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			pstmt.executeUpdate();
			
		} catch(){
			
		} catch(){
			
		} finally {
			
		}
		
	
	}
	
	

}
