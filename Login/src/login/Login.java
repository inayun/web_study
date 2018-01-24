package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		try {

			HttpSession session = request.getSession(false);
			//세션객체가 만들어지면서 아이디가 부여됨
			if(session != null) {
				//사용자가 있을 경우 아이디를 가져와서 확인
				String sessionId = session.getId();
				System.out.println("세션Id : " + sessionId);

				String user = (String)session.getAttribute("user");

				out.println("<html>");
				out.println("<body>");
				out.println("<table border=1 width=300>");

				out.println("<tr>");
				out.println("<td width=300 align=center>" + user + "님이 로그인 되었습니다. </td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td align=center>");
				out.println("<a href=#>회원정보</a>");
				out.println("<a href='Logout'>로그아웃</a>");
				out.println("</td>");
				out.println("</tr>");


				out.println("</table>");
				out.println("</body>");
				out.println("</html>");

			} else {
				//접속한 회원이 없을경우
				out.println("<html>");
				out.println("<body>");
				out.println("<form method='post' action='LoginCheck' >");

				out.println("<table width=300 border=1>");

				out.println("<tr>");
				out.println("<th width=100>아이디</th>");
				out.println("<td width=200>&nbsp;");
				out.println("<input type=text name=id >");
				out.println("</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<th width=100>비밀번호</th>");
				out.println("<td width=200>&nbsp;");
				out.println("<input type=text name=pwd >");
				out.println("</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td colspan=2 align=center >");
				out.println("<input type=submit value=로그인>");
				out.println("<input type=button value=회원가입>");
				out.println("</td>");
				out.println("</tr>");
				
				out.println("</table>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
			}

		} finally {
			out.close();
		}

	}

}
