package board.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;


public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String pageNum = request.getParameter("pageNumConfig");
		
		if(pageNum == null){
			pageNum = "1";
			
		}
		//현재 페이지의 게시글 수
		int pageSize = 5;
		
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage -1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		
		int count = 0;
		int number = 0;
		
		List<BoardVO> articleList = null;
		BoardDAO dbPro = BoardDAO.getInstance();
		//전체 글의 수
		count = dbPro.getArticleCount();
		
		if(count > 0) {
			 //현재 페이지에 해당하는 글 목록
			articleList = dbPro.getArticles(startRow,endRow);
		} else {
			articleList= Collections.emptyList();
		}
		
		number = count - (currentPage -1) * pageSize;
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("articleList", articleList);
		request.setAttribute("count", count);

		//해당하는 목록 페이지로 리턴함
		
		
		return "/board/list.jsp";
	}

}
