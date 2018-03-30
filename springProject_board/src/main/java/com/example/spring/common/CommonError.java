package com.example.spring.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//에러가 떨어졌을 때 들어오는 어노테이션
//@ControllerAdvice


public class CommonError {

	private final String VIEW_PATH = "/error/";
	
	
	@ExceptionHandler( {RuntimeException.class}  )
	public String runtimeException(RuntimeException re, HttpServletRequest request, Model model) {
		
		
		model.addAttribute("content","런타임 에러가 발생하였습니다.");
		
		/* 에러 던질때 보내는 메세지 받음 re.getMessage()
		model.addAttribute("content",re.getMessage());

		*/
		
		
		return VIEW_PATH + "error"; //   views/error/error.jsp 로 감
	}
}
