package com.example.spring.common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

public class CommonFilter extends GenericFilterBean {

	private static final Logger logger = LoggerFactory.getLogger(CommonFilter.class);
	

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain FilterChain)
			throws IOException, ServletException {
		
		logger.info("Filter 진입");
		HttpServletRequest req = (HttpServletRequest)request;
		
		String url = req.getRequestURL().toString();
		
		
		/*인터셉터에서 exclude 개념. 직접 인위적으로 코딩해주기*/
		
		if(url.indexOf("/login/") == -1) {
			
		/*	로그인 경로에 해당될 경우는 셋 안해줌*/
			
		} else {
			/*로그인에 해당되는 경로가 아닐때만
			 * 로그인에 해당 되는 경로 '인위적으로' 제외해주기
			 * 
			  */
			request.setAttribute("filterInputValue", "필터에서 입력한 값");
		}
		
		
		
		
		/*
		 * 필터에서는 주로 '한글 인코딩'에 대한 설정을 해놓음
		 * 
		 */
		
		
		//doFilter를 통해 필터가 연동됨...
		FilterChain.doFilter(request,response);
		
		
		
	}
	
}
