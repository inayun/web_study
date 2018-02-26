package board.model;
//ConnUtil에서 실제 데이터베이스에 쿼리 작업을 해줄 클래스
public class BoardDAO {

	private static BoardDAO instance = null;
	
	public BoardDAO() {
	}
	
	public static BoardDAO getInstance() {
		
		if(instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	} //getInstance
	
	
	
	
}
