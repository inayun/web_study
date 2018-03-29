package com.example.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lecture06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture06Controller.class);
	
	
	@RequestMapping(value="/lecture06.do")
	public String lecture06(HttpServletRequest request, Model model) {
		
		logger.info("lecture06.do controller 들옴");
		String id = request.getParameter("id");
		model.addAttribute("id",id);
		model.addAttribute(request.getAttribute("interceptorSendValue"));
		
		
		if(1 != 2) {
			throw new RuntimeException("에러 메시지 내용 ~~~~~~");
		}
		
		return "/lecture06/lecture06";
		
	}
	
	
}