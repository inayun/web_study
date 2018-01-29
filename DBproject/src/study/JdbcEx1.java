package study;

import java.sql.*;


//insert
public class JdbcEx1 {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		
		String Driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			
			Class.forName(Driver);
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into department values(206, '매력학과', 201, '예쁜대')");
			stmt.executeUpdate(sql.toString());
			System.out.println("디비 연동 성공");
			
		}catch(ClassNotFoundException e) {
		e.printStackTrace();
		}catch(SQLException e){
		e.printStackTrace();
		}finally {
			
			try {
				if(stmt!=null)
					stmt.close();
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
