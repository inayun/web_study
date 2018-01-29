package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//delete
public class jdbcEx3 {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("delete department where dname='소프트웨어학과'");
		String Driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			
			Class.forName(Driver);
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			
			stmt.executeUpdate(sql.toString());
			System.out.println("디비 삭제 성공!");
			
		} catch(ClassNotFoundException e) {
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

