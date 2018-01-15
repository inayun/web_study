package action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

@WebServlet("/Life.do")
public class LifeCycle  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LifeCycle() {
		System.out.println("--- 1. LifeCycle() ---");
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("--- 2. init() ---");
	}
	
	public void destroy() {
		System.out.println("---destroy() ---");
	}
	
	public String getServletInfo() {
		return null;
	}
	
	protected void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		System.out.println("---3. service() ---");
		super.service(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		response.getWriter().append("Served ad:").append(request.getContextPath());
		System.out.println("---3-1.doGet()---");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
		doGet(request, response);
		System.out.println("---3-1.doPost()---");
		
	}
}
