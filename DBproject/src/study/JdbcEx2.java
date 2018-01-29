package study;
import java.sql.*;

public class JdbcEx2 {

	public static void main(String[] args) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("update department set dname='소프트웨어학과' where deptno=203");
		
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
			
			stmt.executeUpdate(sql.toString());
			System.out.println("디비 업데이트 성공!");
			
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

