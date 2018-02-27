package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
	//해당 글 번호
		int num = Integer.parseInt(request.getParameter("num"));
	//해당 페이지 번호
		String pageNum = request.getParameter("pageNum");
		
		BoardDAO dbPro = BoardDAO.getInstance();
		
		//해당 글번호에 대한 레코드를 가져옴
		BoardVO article = dbPro.getArticle(num);
		
		//해당 뷰에서 사용할 속성 저장
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		
		return "/board/content.jsp";
	
	}

}
