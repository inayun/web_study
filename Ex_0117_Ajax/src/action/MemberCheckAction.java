package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberCheckAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//check_id.do?id=hong
		String id = request.getParameter("id");
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		
		String res = "no";
		if(vo==null) {
			//디비 검색결과가 없을때
			res = "yes";
		}
		
		//JSON타입으로 전송할때 한글이 섞여있으면 인코딩 오류가 나므로 '한글'텍스트도 전송 가능하도록 인코딩 해줘야함
		response.setContentType("text/plain:charset=UTF-8");
		
		//res를 JSON타입으로 돌려보냄
		String resultStr = String.format("[{'result':'%s'},{'mid':'%s'}]",res,id);
		
		//resultStr 을 전송
		response.getWriter().println(resultStr);
	}

}
