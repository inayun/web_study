package jdbc;
import java.sql.*;
import java.util.*;

public class TempMemberDAO {

	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1522:orcl";
	private final String USER = "scott";
	private final String PASSWORD = "tiger";

			
	public TempMemberDAO() {
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch(Exception e) {
			System.out.println("Driver loading 실패");
		}
	}
	
	public Vector<TempMemberVO> getMemberList() {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		 
		Vector<TempMemberVO> vecList = new Vector<TempMemberVO>();
		
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			
			String strQuery = "select * from tempmember";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(strQuery);
			
			while(rs.next()) {
				TempMemberVO vo = new TempMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setMem_num1(rs.getString("mem_num1"));
				vo.setMem_num2(rs.getString("mem_num2"));
				vo.setEmail(rs.getString("e_mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setJob(rs.getString("job"));

				
				vecList.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally 
		
		{
			
			if(rs != null) 	try {rs.close();} catch(SQLException e) {}
			
			if(stmt != null) try {stmt.close();	} catch(SQLException e) {}
			
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
			
		return vecList;
	
		}
	}
	
