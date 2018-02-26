package board.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//데이터베이스 커넥션을 얻어오는 클래스
public class ConnUtil {

	private static DataSource ds;
	
	static {
		
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnetion() throws SQLException{
		return ds.getConnection();
	}
}
