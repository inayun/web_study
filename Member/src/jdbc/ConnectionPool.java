package jdbc;
import java.sql.*;
import java.util.*;


public final class ConnectionPool {

	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//사용하지 '않는' 커넥션 즉, 초기 커넥션을 저장하는 변수 선언
	private ArrayList<Connection> free;
	//사용 '중인' 커넥션
	private ArrayList<Connection> used;

	private String url = "jdbc:oracle:thin:@localhost:1522:orcl";
	private String user="scott";
	private String password="tiger";
	
	private int initialCons = 10; //최초 초기 커넥션 수
	private int maxCons = 20; //최대 커넥션 수
	private int numCons = 0; //총 커넥션 수

	public int getMaxCons() {
		return maxCons;
	}

	public int getNumCons() {
		return numCons;
	}

	private static ConnectionPool cp;
	
	public static ConnectionPool getInstance() {
		
		try {
			if(cp == null) {
				
				synchronized (ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return cp;
	}
	
	private ConnectionPool() throws SQLException {
		
		//초기 커넥션 개수를 각각의 ArrayList에 저장할 수 있도록 커넥션 수 만큼 ArrayList 생성
		free = new ArrayList<Connection>(initialCons);
		used = new ArrayList<Connection>(initialCons); 
		
		while(numCons < initialCons) {
			addConnection();
		}
	}
	
	private void addConnection() throws SQLException {
		
		//free에 커넥션 객체를 저장함
		free.add(getNewConnection());
	}
	
	private Connection getNewConnection() throws SQLException {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch(SQLException s) {
			s.printStackTrace();
		}
		
		System.out.println(con + "에 연결");
		++numCons; //커넥션이 생성될때 마다 숫자 증가
		
		return con;
	}
	
	//free에 있는 커넥션을 used로 옮기는 작업
	public synchronized Connection getConnection() throws SQLException{
		
		//free에 Connection이 없으면 maxCons만큼 컨넥션 수를 생성함
		if(free.isEmpty()) {
			
			while(numCons < maxCons) {
				addConnection();
			}
		}
		Connection _con;
		_con = free.get(free.size()-1);
		free.remove(_con);
		used.add(_con);
		return _con;
		
	}
	
	//used에 있는 커넥션을 free로 반납
	public synchronized void releaseConnection(Connection _con) throws SQLException{
		
		boolean flag = false;
		
		if(used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag = true;
		} else {
			throw new SQLException("ConnectionPool에 있지 않음");
		}
		
		try {
			if(flag) {
				free.add(_con);
				numCons++;
			} else {
				_con.close();
			}
		} catch(SQLException e ) {
			try {
				_con.close();
			} catch(SQLException ee) {
				ee.printStackTrace();
			}
		}
	}
	
	//모든 컨넥션을 반납함
	public void closeAll() {
		//used에 있는 커넥션을 모두 삭제해 버림
		
		for(int i = 0; i < used.size(); i++) {
			
			Connection _con = (Connection)used.get(i);
			used.remove(i--);
			
			try {
				_con.close();
			} catch(SQLException ss) {
				ss.printStackTrace();
			}
		}
		
		for(int i = 0; i < free.size(); i++) {
			
			Connection _con = (Connection)free.get(i);
			free.remove(i--);
			
			try {
				_con.close();
			} catch(SQLException ss) {
				ss.printStackTrace();
			}
		}
	}
	
}
