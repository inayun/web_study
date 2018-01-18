package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberListAction
 */

@WebServlet("/member/member_list.do")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		List<MemberVO> list = MemberDAO.getInstance().selectList();
		request.setAttribute("list", list);
		
		//member_list.jsp 에서 현재 list를 받을 수 있도록 정보를 넘겨줌
		request.getRequestDispatcher("member_list.jsp").forward(request, response);
	}

	

}
