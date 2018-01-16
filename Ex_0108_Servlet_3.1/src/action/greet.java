package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

//@WebServlet("/greet.do")
public class greet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		
		
		String nation = request.getParameter("nation");
		String msg = "";
		
		if(nation == null || nation.isEmpty() ) {
			//default = korean
			nation = "kor";
		}
		
		if(nation.equals("kor")) {
			msg = "an nyong";
		} else if(nation.equals("eng")) {
			msg = "hello";
		} else if(nation.equals("jpn")) {
			msg = "こんにちは";
		} else if(nation.equals("chn")) {
			msg = "你好";
		}
		
		
		response.setContentType("text/html; chatset=utf-8; ");
		
		PrintWriter out = response.getWriter();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>");
		sb.append("	<head>");
		sb.append("		<title>");
		sb.append("		</title>");
		sb.append("		<style> h1{color:red;}");
		sb.append("		</style>");
		sb.append("	</head>");
		sb.append("	<body>");
		sb.append("		<h1>");
		sb.append(msg);
		sb.append("		</h1>");
		sb.append("	</body>");
		sb.append("</html>");

		out.print(sb.toString());
		
	}
	
	
}
