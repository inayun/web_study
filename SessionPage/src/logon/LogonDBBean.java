package logon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LogonDBBean {

	private static LogonDBBean instance = new LogonDBBean();

	
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	public LogonDBBean() {}
		
	public Connection getConnection() throws Exception {
		
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/mydb");

		return ds.getConnection();
	}
	
	public int userCheck(String id, String password) throws Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbPassword = null;
		int x = -1; //로그인 성공시 : 1, 비밀번호가 일치하지 않을때 : 0, 해당 아이디가 존재하지 않을때 : -1
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select password from tempmember where id = ?");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPassword = rs.getString("password");
				
				if(dbPassword.equals(password)) {
					x = 1; //로그인 성공
				} else {
					x = 0; //비밀번호 불일치
				}
			} else {
				x = -1; //해당 아이디가 존재하지 않을때
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close();} catch(Exception e) {}
			if(con!=null) try { con.close();} catch(Exception e) {}
		}
		return x;
	} 
	
	
}
