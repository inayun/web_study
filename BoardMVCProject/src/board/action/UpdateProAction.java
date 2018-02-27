package board.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		request.setCharacterEncoding("utf-8");
	
		String pageNum = request.getParameter("pageNum");
		
		//데이터 처리 빈
			BoardVO article = new BoardVO();
			article.setNum(Integer.parseInt(request.getParameter("num")));
			article.setWriter(request.getParameter("writer"));
			article.setEmail(request.getParameter("email"));
			article.setSubject(request.getParameter("subject"));
			article.setPass(request.getParameter("password"));
			article.setRegdate(new Timestamp(System.currentTimeMillis()));
			article.setRef(Integer.parseInt(request.getParameter("ref")));
			article.setStep(Integer.parseInt(request.getParameter("step")));
			article.setDepth(Integer.parseInt(request.getParameter("depth")));
			article.setContent(request.getParameter("content"));
			article.setIp(request.getRemoteAddr());
			
			//데이터 처리
			BoardDAO dbPro = BoardDAO.getInstance();
			int check = dbPro.updateArticle(article);

			request.setAttribute("pageNum", pageNum);
			request.setAttribute("check", check);	
			
			return "/board/updatePro.jsp";
			
	}

}
