package com.servletex;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String company;
	private String manager;
	private String tel;
	private String email;
	
	@Override
	public void init() throws ServletException {

		System.out.println("초기화 메소드 수행");
		
		//ServletContext의 초기 파라미터 값 읽기
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");
		//ServletConfig의 초기 파라미터 값 읽기
		tel = getServletConfig().getInitParameter("tel");
		email = getServletConfig().getInitParameter("email");
		
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {

			out.println("<html>");
			out.println("<body>");
			out.println("<ul>");
			out.println("<li> 회사명 :"+ company +"</li>");
			out.println("<li> 담당자 :"+ manager +"</li>");
			out.println("<li> 연락처 :"+ tel +"</li>");
			out.println("<li> 이메일 :"+ email +"</li>");
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");
			
		} finally {
			out.close();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	
}
