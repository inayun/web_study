package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet("/calc.do")
public class calculation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//public , ServletRequest, ServletResponse
	public void service(ServletRequest request, ServletResponse response)
	throws ServletException, IOException{
		
		int su1 = Integer.valueOf( request.getParameter("su1")  );
		int su2 = Integer.valueOf( request.getParameter("su2")  );
		String msg = "";
		
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		
		sb.append("		<p>");
		sb.append("+결과 :");
		sb.append(su1+su2);
		sb.append("<br>");
		sb.append("-결과 :");
		sb.append(su1-su2);
		sb.append("<br>");
		sb.append("*결과 :");
		sb.append(su1*su2);
		sb.append("<br>");
		sb.append("/결과 :");
		sb.append(su1/su2);
		sb.append("<br>");
		sb.append("		</p>");
		out.print(sb.toString());
		
	}
	
}
