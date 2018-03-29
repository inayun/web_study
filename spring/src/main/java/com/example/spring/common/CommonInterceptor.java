package com.example.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		/* 컨트롤러 실행전에 실행되는 함수
		 * 사용자가 요청한 내용을 컨트롤러에 전달하기 전에 호출
		 * 리턴값이 false인 경우는 컨트롤러를 호출하지 않고 요청이 종료
		*/
		logger.info("인터셉터의 preHandler 요청");
		request.setAttribute("interceptorSendValue", "interceptor");
		
		return super.preHandle(request, response, handler);
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	/*	jsp (view)로 호출되기 전에 수행		
	 * 컨트롤러가 수행되고 난 후에 수행
	 * 컨트롤러가 에러가 발생을 하면 수행이 안됨
	 * */
		
		logger.info("인터셉터의 postHandler 요청");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		/*
		 * view까지 다 수행되고 나서 마지막에 수행
		 * 
		 */
		
		
		logger.info("인터셉터의 afterCompletion 요청");
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
