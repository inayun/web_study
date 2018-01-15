package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//request : 요청처리 객체
		//response : 응답처리 객체
		
		System.out.println("---hello servlet : service() ---");
		
		// 주소창에 url 입력 
		// http://ip:port/ptoject명/경로/파일명
		// http://localhost:9090/Ex_0108_Servlet_2.5/hello.do
		// web.xml 에 있는 <url-pattern>/hello.do</url-pattern>
		
		/*
		 
		 서블릿 (server + let)
		 
		 - 서버에서 실행되는 서비스(사용자의 요구사항을 제공해주는) 객체
		 - 웹 응용프로그램을 만드는 자바 기술
		 - 실행 결과값은 html로 돌려줌
		 - html의 정적인 문제를 해결할 수 있는 동적인 특징
		 - 자바 언어로 작성되어 자바의 일반적인 특징을 모두 가짐
		 - 객체 지향적
		 - 스레드로 처리함 (동시다발적인 사용자의 요청에 대한 응답이 용이)
		 
		 */
		
	}

}
