package study;

import java.sql.*;
import java.io.*;
import java.util.*;

public class JdbcEx10 {

	public static void main(String[] args) throws SQLException, IOException {

		Properties pro = new Properties();
		
		/*
		//EditPlus
		pro.load(new FileInputStream("department.properties"));
		*/
		
		
		//Eclipse
		pro.load(new FileInputStream("src/department.properties"));

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement( pro.getProperty("department_insert"));
			
			
			pstmt.setInt(1,100);
			pstmt.setString(2, "문화인류학과");
			pstmt.setInt(3,200);
			pstmt.setString(4,"궁문대");
			pstmt.executeUpdate();
			System.out.println("디비 인서트 성공");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally   {

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
