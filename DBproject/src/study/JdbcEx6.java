package study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcEx6 {

	public static void main(String[] args) {

		StringBuffer sql = new StringBuffer();
		sql.append("update professor set sal=? where name=?");

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 600);
			pstmt.setString(2, "홍길똥");
			pstmt.executeUpdate();
			System.out.println("디비 수정 성공");

		} catch (Exception e) {
			e.printStackTrace();
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
