package study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

public class JdbcEx9 {

	public static void main(String[] args) throws IOException {

		//keyboard 와 연결된 스트림 얻기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Sql input : ");
		String sql = br.readLine();
		
		try {
		Connection con = ConnUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		// 쿼리 수행결과 집합의 부가정보를 가지고 있는 ResultSetMetaData 객체 얻기
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("컬럼 개수 : " + rsmd.getColumnCount());

		/*
		  
		 for(int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		System.out.println();
		
		for(int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnTypeName(i)+"\t");
		}
		System.out.println();
		
		*/
		
		int columnCount = rsmd.getColumnCount();
		
		while(rs.next()) {
			
			for(int colNum=1; colNum <= columnCount; colNum++) {
				
				int colType = rsmd.getColumnType(colNum);
				
				switch(colType) {
				
				
				case Types.NUMERIC :
					System.out.println(rs.getInt(colNum) + "\t");
					break;
					
				case Types.VARCHAR :
					System.out.println(rs.getString(colNum) + "\t");
					break;
					
				case Types.DATE :
					System.out.println(rs.getInt(colNum) + "\t");
					break;
				
				}
			}
			System.out.println();
		}
		
		br.close();
		rs.close();
		pstmt.close();
		con.close();
		
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
