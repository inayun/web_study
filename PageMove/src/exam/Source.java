package exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Source")
public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Source Start");
		
		//페이지 이동
		//1. forward 방식으로 페이지 이동(url 유지. '요청'객체 소속) 
		/*RequestDispatcher view = request.getRequestDispatcher("Destination");
		view.forward(request, response);
		*/
		
		//2. Redirect 방식으로 페이지 이동(url 유지안됨 바뀜. '응답'객체 소속)
		response.sendRedirect("Destination");
		
	}
}
