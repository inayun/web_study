package board.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.model.BoardVO;
import board.model.ConnUtil;

//ConnUtil에서 실제 데이터베이스에 쿼리 작업을 해줄 클래스
public class BoardDAO {

	private static BoardDAO instance = null;
	
	//생성자는 private로 처리?!
	private BoardDAO() {
	}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	} //getInstance
	
	//전체 글의 개수를 알아내는 메소드 추가
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
				x = rs.getInt(1);
			} 
			
			
		} catch(Exception e) {
				e.printStackTrace();
		} finally {
				if(rs!=null) try {rs.close();}catch(SQLException e) {e.printStackTrace();}
				if(pstmt!=null) try {rs.close();}catch(SQLException e) {e.printStackTrace();}
				if(con!=null) try {rs.close();}catch(SQLException e) {e.printStackTrace();}
		
		}
		
		return x;
	} //getArticleCount
	
	
	//글 목록을 얻어와서 List 형태로 리턴해줄 메소드 구현
	public List<BoardVO> getArticles(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select * from (select rownum ,num,writer,email,subject,password,regdate,readcount,ref,step,depth,content,ip from (select * from board order by ref desc,step asc)) where rownum >= ? and rownum <= ?");
	
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				articleList = new ArrayList<BoardVO>(end-start+1);
				
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("password"));
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {e.printStackTrace();}
			if(pstmt!=null) try {rs.close();}catch(SQLException e) {e.printStackTrace();}
			if(con!=null) try {rs.close();}catch(SQLException e) {e.printStackTrace();}
	}
		return articleList;
	} //getArticles()
	
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
				 	sql = "update board set step=step+1 where ref=? and step > ?";
				 	pstmt = con.prepareStatement(sql);
				 	
				 	pstmt.setInt(1, ref);
				 	pstmt.setInt(2, step);
				 	pstmt.executeUpdate();
				 	step = step+1;
				 	depth = depth+1;
			}else {
				// 새 글일 경우
				ref = number;
				step = 0;
				depth = 0;
			}
			sql = "insert into board(num, writer, email, subject, password, regdate, ref, step, depth, content, ip)"
					+"values(board_seq.nextval, ?,?,?,?,?,?,?,?,?,?)";
		 	
		 	pstmt = con.prepareStatement(sql);
		 	pstmt.setString(1, article.getWriter());
		 	pstmt.setString(2, article.getEmail());
		 	pstmt.setString(3, article.getSubject());
		 	pstmt.setString(4, article.getPass());
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
				try { pstmt.close();}catch(SQLException e) {}
			}
			if(con != null) {
				try { con.close();}catch(SQLException e) {}
			}
		}
		

	} //insertArticle()
	
	
	//데이터베이스에서 실제로 글 내용을 가져올 메소드 구현 
	
 public BoardVO getArticle(int num) {
		 
		 /*
		  * 글의 넘버를 매개변수로 하여 하나의 글에 대한 세부 정보를 디비에서 가져옴 
		  */
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 BoardVO article = null;
		 
		 try {
			 con = ConnUtil.getConnection();
			 pstmt = con.prepareStatement("update board set readcount = readcount+1 where num =?");
			 pstmt.setInt(1, num);
			 pstmt.executeUpdate();
			 
			 pstmt = con.prepareStatement("select * from board where num = ?");
			 pstmt.setInt(1, num);
			 
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 
				 article = new BoardVO();
				 	article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("password"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
			 } 
		 
		 } catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(rs != null) {
					try { rs.close();}catch(SQLException e) {}
				}
				if(pstmt != null) {
					try { pstmt.close();}catch(SQLException e) {}
				}
				if(con != null) {
					try { con.close();}catch(SQLException e) {}
				}
			}
		 
		 return article;
	 } //getArticle()

}
