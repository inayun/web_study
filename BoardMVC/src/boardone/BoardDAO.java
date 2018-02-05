package boardone;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	
	private static BoardDAO instance = null;
	
	public BoardDAO() {
		
	}

	public static BoardDAO getInstance() {
		
		if(instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	//여기서부터 게시판 작업 위한 메소드 하나하나 추기
	
	public void insertArticle( BoardVO article) {
		//실제 데이터베이스에 데이터를 넣어줄 메소드 추가
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = article.getNum();
		int ref = article.getRef();
		int step =article.getStep();
		int depth = article.getDepth();
		int number = 0;
		String sql = "";
		
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				number = rs.getInt(1)+1;
			}else {
				number = 1;
			}
			if(num != 0) {
				// 답변 글일 경우 
				 	sql = "update board set step+1 where ref=? and step > ?";
				 	pstmt = con.prepareStatement(sql);
				 	
				 	pstmt.setInt(1, ref);
				 	pstmt.setInt(2, step);
				 	pstmt.executeUpdate();
				 	step = step+1;
				 	depth = depth+1;
			}else {
				// 새 글일 경우
				ref = 0;
				step = 0;
				depth = 0;
			}
			sql = "insert into board(num, writer, email, subject, password, regdate, ref, step, depth, content, ip)"
					+"values(board_seq.nextval, ?,?,?,?,?,?,?,?,?,?)";
		 	
		 	pstmt = con.prepareStatement(sql);
		 	pstmt.setString(1, article.getWriter());
		 	pstmt.setString(2, article.getEmail());
		 	pstmt.setString(3, article.getSubject());
		 	pstmt.setString(4, article.getPassword());
		 	pstmt.setTimestamp(5, article.getRegdate());
		 	pstmt.setInt(6, ref);
		 	pstmt.setInt(7, step);
		 	pstmt.setInt(8, depth);
		 	pstmt.setString(9, article.getContent());
		 	pstmt.setString(10, article.getIp());
		 	
		 	pstmt.executeUpdate();
		 	
		 	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}finally {
			
			if(rs != null) {
				try { rs.close();}catch(SQLException e) {}
			}
			if(pstmt != null) {
				try { rs.close();}catch(SQLException e) {}
			}
			if(con != null) {
				try { rs.close();}catch(SQLException e) {}
			}
		}
		

	}
	
	// 첫 번째 전체 글의 개술ㄹ 가져올 메소드 추가
	
	public int getArticleCount() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x= rs.getInt(1);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try { rs.close();}catch(SQLException e) {}
			}
			if(pstmt != null) {
				try { rs.close();}catch(SQLException e) {}
			}
			if(con != null) {
				try { rs.close();}catch(SQLException e) {}
			}
		}
		return x;
	} //getArticleCount()
	
	public List<BoardVO> getArticles(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from board order by num desc");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				articleList = new ArrayList<BoardVO>();
				
				do {
					
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPassword(rs.getString("password"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					articleList.add(article);
					
				} while(rs.next());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try { rs.close();}catch(SQLException e) {}
			}
			if(pstmt != null) {
				try { rs.close();}catch(SQLException e) {}
			}
			if(con != null) {
				try { rs.close();}catch(SQLException e) {}
			}
		}
		
		return articleList;
	} //getArticles()
	
}
