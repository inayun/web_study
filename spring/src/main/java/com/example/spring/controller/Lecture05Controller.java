package com.example.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Lecture05Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture05Controller.class);
	
	@RequestMapping(value = "/requestParam.do")
	public String home(
			@RequestParam(value="id", defaultValue = "hong") String id,
			@RequestParam(value="name") String name,
			Model model) {
		
		
		logger.info("id is {}.", id);
		logger.info("name is {}.", name);
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		
		return "/lecture05/lecture05";
		
	}

}

