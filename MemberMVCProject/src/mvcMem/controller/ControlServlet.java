package mvcMem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcMem.action.Action;


@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("uft-8");
		response.setContentType("utf-8");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd != null) {
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(cmd);
			
			ActionForward af = action.execute(request, response);
			
					
			if(af.isRedirect()) {
				response.sendRedirect(af.getUrl());
				
			} else {
				RequestDispatcher rd = 
						request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response);
			}
		}
		
		else {
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h3>올바른 요청이 아닙니다. </h3>");
			out.println("<h4>http://localhost:9090/MemberMvcProject/mvcMem/member.do?cmd=요청키워드 형식으로 요청바람</h4>");
			out.println("</body>");
			out.println("</html>");
			
			
			
		}
	
	}

	

}
