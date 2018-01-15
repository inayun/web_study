package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url mapping
@WebServlet("/Hello2.do")
public class HiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
	
	System.out.println("---HiServlet : service()---");
	}
}
