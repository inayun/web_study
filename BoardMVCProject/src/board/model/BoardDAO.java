package board.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.model.BoardVO;

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
			con = ConnUtil.getConnetion();
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
			con = ConnUtil.getConnetion();
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
	
}
