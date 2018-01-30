package study;
import java.sql.*;

public class ConnUtil {

	static {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException{
		
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String user = "scott";
		String password = "tiger";
		
		return DriverManager.getConnection(url,user,password);
	}
	
}
