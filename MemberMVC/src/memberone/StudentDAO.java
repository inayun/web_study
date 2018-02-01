package memberone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {

	private Connection getConnection() {
		
		Connection con = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mydb");
			con = ds.getConnection();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("접근 실패");
		}
		return con;
	}
	
	public boolean idCheck(String id) {
		
		boolean result = true;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select * from student where id=?");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				result = false;
			} 
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (SQLException ss) {}
			if(pstmt != null) try {pstmt.close();} catch (SQLException ss) {}
			if(con != null) try {con.close();} catch (SQLException ss) {}
		}
		
		return result;
	}

	public Vector<ZipcodeVO> zipcodeRead(String dong){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ZipcodeVO> vecList = null;
		
		
		try {
			
			con = getConnection();
			String strQuery = "select * from zipcode where dong like '" + dong + "%'";
			pstmt = con.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			vecList = new Vector<ZipcodeVO>();
			
			while(rs.next()) {
				
				ZipcodeVO tempZipcode = new ZipcodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));

				vecList.addElement(tempZipcode);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (SQLException ss) {}
			if(pstmt != null) try {pstmt.close();} catch (SQLException ss) {}
			if(con != null) try {con.close();} catch (SQLException ss) {}
		}
		
		return vecList;
		
	}
}
