package study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcEx7 {

	public static void main(String[] args) {

		StringBuffer sql = new StringBuffer();
		sql.append("select a.name, a.profno, a.position, b.dname from professor a, department b where a.deptno = b.deptno and a.deptno=?");
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,203);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString(1);
				int profno = rs.getInt(2);
				String position = rs.getString(3);
				String dname = rs.getString(4);
				
				System.out.println("name : " + name);
				System.out.println("profno : " + profno);
				System.out.println("position : " + position);
				System.out.println("dname : " + dname);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally  {
			
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException s){
				s.printStackTrace();
			}
			
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
