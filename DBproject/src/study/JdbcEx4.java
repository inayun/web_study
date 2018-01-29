package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx4 {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from department");
		String Driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			
			Class.forName(Driver);
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();

			//실행하고자 하는 sql이 select 쿼리 인경우 쿼리 실행의 집합결과를 리턴 받을 수 있는 execuryQuery() 사용
			rs = stmt.executeQuery(sql.toString());
			//resultSet 객체로부터 데이터 추출하기
			
			while(rs.next()) {
				
				int depno = rs.getInt(1);
				String dname = rs.getString(2);
				int college = rs.getInt(3);
				String loc = rs.getString(4);

				System.out.println(depno + "\t" + dname + "\t" + college +"\t" + loc);
			}
			
			System.out.println("디비 조회 성공!");
			
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
				
				try {
					if(rs !=null)
						con.close();
				} catch (SQLException s){
					s.printStackTrace();
				}
			}
			
		}
	}


