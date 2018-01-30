package study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcEx8 {

	public static void main(String[] args) {

	
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into department values(?,?,?,?)");
		
		StringBuffer sql2 = new StringBuffer();
		sql2.append("update department set dname=?, loc=? where deptno=?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			/////////transaction 시작///////////
			
			//하나의 논리적인 작업 단위 시작
			con = ConnUtil.getConnection();
			
			//autoCommit 기능 비활성화 시킴
			con.setAutoCommit(false);
			
			// --------------1 start--------------
			pstmt = con.prepareStatement(sql1.toString());
			pstmt.setInt(1, 255);
			pstmt.setString(2, "오징어잘말리기학과");
			pstmt.setInt(3, 500);
			pstmt.setString(4, "오징어들끓는대");
			
			pstmt.executeUpdate();
			// --------------1 end--------------

			// --------------2 start--------------
			pstmt = con.prepareStatement(sql2.toString());
			pstmt.setString(1, "영문학과");
			pstmt.setString(2, "국문대");
			pstmt.setInt(3, 208);
			pstmt.executeUpdate();
			// --------------2 end--------------

			//쿼리가 정상적으로 실행된 경우 db에 반영
			con.commit();
			System.out.println("db에 반영");
			
			
		} catch (Exception e) {
			
			try {
				con.rollback();
				System.out.println("db에 반영을 취소");
			} catch(SQLException s) {
				s.printStackTrace();
			}
			
		} finally  {

			try {
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException s){
				s.printStackTrace();
			}

			try {
				if(con!=null)
					con.close();
			} catch (SQLException s){
				s.printStackTrace();
			}

		}
		
	}

}
