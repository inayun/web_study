package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

/**
 * Servlet implementation class MemberDeleteAction
 */
@WebServlet("/member/member_del.do")
public class MemberDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = MemberDAO.getInstance().delete(idx);
		
		System.out.println("디비 거쳐옴");
		String param = "no";
		if(res > 0) {
			//삭제 성공시
			param = "yes";
		}
		//실행결과를 JSON 타입으로 묶음
		String result = String.format("[{'param':'%s'}]",param);
		
		//응답하기
		response.getWriter().println(result);
	}


}
