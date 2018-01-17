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
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		//파라미터로 받은 정보를 가지고 VO객체를 생성
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setAddr(addr);
		vo.setEmail(email);
		
		//DB에 값 추가하기
		MemberDAO.getInstance().insert(vo);
		//갱신된 데이터 로드
		response.sendRedirect("member_list.do");
	}
}
