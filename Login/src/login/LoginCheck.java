package login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		/*
		 * DB에서 저장되어있는  id와 pwd를 가져와서 비교해야함
		 */

		String dbID = "admin";
		String dbPWD = "1234";
		
		if(dbID.equals(id)&& dbPWD.equals(pwd)) {
			//HttpSession 객체 생성
			HttpSession session = request.getSession();
			//클라이언트 정보를 HttpSession 객체에 저장
			session.setAttribute("user", id);
		}
		response.sendRedirect("Login");
	}
}
