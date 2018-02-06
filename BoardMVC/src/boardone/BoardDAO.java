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
				try { pstmt.close();}catch(SQLException e) {}
			}
			if(con != null) {
				try { con.close();}catch(SQLException e) {}
			}
		}
		

	} //insertArticle()
	
	// 첫 번째 전체 글의 개수를 가져올 메소드 추가
	
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
				try { pstmt.close();}catch(SQLException e) {}
			}
			if(con != null) {
				try { con.close();}catch(SQLException e) {}
			}
		}
		return x;
	} //getArticleCount()
	
	public List<BoardVO> getArticles(int start, int end){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> articleList = null;
		
		
		try {
			con = ConnUtil.getConnection();
		/*	pstmt = con.prepareStatement("select * from board order by num desc");*/
			
			pstmt = con.prepareStatement("select * from (select rownum ,num,writer,email,subject,password,regdate,readcount,ref,step,depth,content,ip from (select * from board order by ref desc,step asc)) where rownum >= ? and rownum <= ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);		
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("query success" + start + end);
				articleList = new ArrayList<BoardVO>(end-start+1);
				
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
				try { pstmt.close();}catch(SQLException e) {}
			}
			if(con != null) {
				try { con.close();}catch(SQLException e) {}
			}
		}
		
		return articleList;
	} //getArticles()
	
	
	//데이터베이스에서 글 하나의 정보를 가져오는 메소드 구현
	
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
					article.setPassword(rs.getString("password"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
			 } 
		 
		 } catch (Exception e) {
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
		 
		 return article;
	 } //getArticle()


	 //글 수정 시에 글 목록 보기와 다르게 조회 수를 증가할 필요 없음
	 //따라서 조회수 증가하는 부분을 제외시키고 단순히 num에 해당하는 게시물만 가져오는 메소드 추가
	 

	 public BoardVO updateGetArticle(int num) {
		 
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 BoardVO article = null;
		 
		 try {
			 con = ConnUtil.getConnection();
			 pstmt = con.prepareStatement("select * from board where num = ?");
			 pstmt.setInt(1,num);
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 
				 article = new BoardVO();
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
			 } 
		 } catch (Exception e) {
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
		 return article;
	 } //updateGetArticle()


	 //실제 디비에 있는 글을 수정 처리 할 메소드
	public int updateArticle(BoardVO article) {
		
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 String dbpasswd = "";
		 int result = -1; //결과값
		 
		 try {
			 con = ConnUtil.getConnection();
			 pstmt = con.prepareStatement("select password from board where num=?");
			 pstmt.setInt(1, article.getNum());
			 rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 dbpasswd = rs.getString("password");
				 if(dbpasswd.equals(article.getPassword())) {
					 //비밀번호 일치하는 경우 수정작업이 이루어짐
					 
					 pstmt= con.prepareStatement("update board set writer=?,email=?,subject=?,content=? where num=?");
					 pstmt.setString(1, article.getWriter());
					 pstmt.setString(2, article.getEmail());
					 pstmt.setString(3, article.getEmail());
					 pstmt.setString(4, article.getContent());
					 pstmt.setInt(5, article.getNum());
					 
					 pstmt.executeUpdate();
					 
					 result = 1;
				 } else {
					 //비밀번호가 일치하지 않는 경우 0 return
					 result = 0;
				 }
			 }
			 
		 }  catch (Exception e) {
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
		 return result;
	} //updateArticle
	
	
	//비밀번호를 입력하고 삭제를 수행할 것이며 이 때 데이터베이스에 저장된 비밀번호와 비교해서 삭제를 처리함
	public int deleteArticle (int num, String password) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbPasswd = "";
		int result = -1;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement("select password from board where num = ? ");
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPasswd = rs.getString("password");
				
				if(password.equals(dbPasswd)) {
					pstmt = con.prepareStatement("delete from board where num = ?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					
					result = 1; //삭제 성공
				} else {
					result = 0;
				}
			}
			
		}  catch (Exception e) {
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
	 return result;
		
	}


}
