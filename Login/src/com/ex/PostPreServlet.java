package com.ex;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostPre")
//어노테이션을 이용하여 서블릿 매핑값을 지정

public class PostPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostPreServlet() {
        super();
    }

    //서블릿 객체가 생성될때 호출되는 메소드
	public void init() throws ServletException {
		System.out.println("init");
	}

	//서블릿의 인스턴스(객체)가 제거 될때 호출되는 메서드
	public void destroy() {
		System.out.println("destroy");
	}

	 //init 메소드가 호출되기 전에 수행됨
	@PostConstruct//선처리
	public void initMethod() {
		System.out.println("initMethod");
	}
	
	//객체가 소멸된 이후 마지막에 작업
	@PreDestroy //후작업
	public void clean() {
		System.out.println("clean");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두겟!");
	
	}

}
