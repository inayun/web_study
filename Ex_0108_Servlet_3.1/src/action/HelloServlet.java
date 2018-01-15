package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hello.do")
public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String ip = request.getRemoteAddr();
		System.out.println(ip + "access");
		
		System.out.println("---HelloServlet:service()---");
		
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> start servlet </title>");
		out.println("<style> h1 {color:red;} </style>");
		out.println("</head>");
		
		out.println("<body>");
		out.printf("<h1>[%s] welcome! </h1>", ip);
		out.println("</body>");
		out.println("</html>");
		
	}
}
