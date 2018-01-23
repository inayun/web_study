package bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/visitList")
public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			out.println("<html>");
			out.println("<head><title>방명록 리스트</title></head>");
			out.println("<body>");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select no,writer,memo,regDate from visit order by no desc");
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user="scott";
			String password="tiger";
			
			
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
			pstmt = con.prepareStatement(sql.toString());
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				int no = rset.getInt("no");
				String writer = rset.getString("writer");
				String memo = rset.getString("memo");
				java.sql.Date regdate = rset.getDate("regDate");
				
				out.println("<table align=center width=500 border=1>");
				
				out.println("<tr>");
				out.println("<th width=50>번호</th>");
				out.println("<td width=50 align=center>"+no+"</td>");

				out.println("<th width=70>작성자</th>");
				out.println("<td width=180 align=center>"+writer+"</td>");
				
				out.println("<th width=50>날짜</th>");
				out.println("<td width=100 align=center>"+regdate+"</td>");
				out.println("</tr>");
				

				out.println("<tr>");
				out.println("<th width=50>내용</th>");
				out.println("<td colspan=5> &nbsp;<textarea>"+memo+"</textarea></td>");
				out.println("</tr>");
				
				out.println("</table>");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
		
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		out.println("<p align=center><a href=/Visit/bbs/write.html>글쓰기</a></p>");
		out.println("</body>");
		out.println("</html>");
		
		}finally {
			out.close();
		}
		
	}
}
