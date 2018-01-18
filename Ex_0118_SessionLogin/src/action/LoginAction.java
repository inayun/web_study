package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/jsp/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		String result = "";
		String param = "";
		response.setContentType("text/plain;charset=UTF-8");

		if(vo==null) {
			param ="no_id";
			result = String.format("[{'param':'%s'}]",param);
			response.getWriter().println(result);
			return;
			
		}
		
		if(!vo.getPwd().equals(pwd)) {
			param = "no_pwd";
			result = String.format("[{'param':'%s'}]",param);
			response.getWriter().println(result);
			return;
		}
		
		//아이디와 비번이 모두 일치한다면, vo객체를 세션에 담음
		//세션은 서버의 메모리를 사용하기 때문에, 많을 수록 브라우저를 느리게 만들 수 있으므로 꼭 필요한 곳에서만 사용할 것
		
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*30); //3분동안 세션유지
		session.setAttribute("user", vo);
		
		param = "clear";
		result = String.format("[{'param':'%s'}]",param);
		response.getWriter().println(result);
	}
}
