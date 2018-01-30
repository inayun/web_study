package study;
import java.sql.*;

// 정적 PreparedStatement
public class JdbcEx5 {

	public static void main(String[] args) {

		StringBuffer sql = new StringBuffer();
		sql.append("insert into professor values(?,?,?,?,?,sysdate,?,?)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 1000);
			pstmt.setString(2,"홍길똥");
			pstmt.setString(3, "길똥");
			pstmt.setString(4, "전임");
			pstmt.setInt(5, 500);
			pstmt.setInt(6, 45);
			pstmt.setInt(7, 203);

			pstmt.executeUpdate();
			System.err.println("디비 삽입 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
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
