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
			
		} else {
			param = "yes_id";
		}
		result = String.format("[{'param':'%s'}]",param);
		response.getWriter().println(result);
	}
}
