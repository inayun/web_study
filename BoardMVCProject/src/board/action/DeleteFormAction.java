package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		//해당 글 번호
		int num = Integer.parseInt(request.getParameter("num"));
		//해당 페이지 번호
		String pageNum = request.getParameter("pageNum");
		
		
		request.setAttribute("num", pageNum);
		request.setAttribute("pageNum", pageNum);
		
		return "/board/deleteForm.jsp";
	}

}
