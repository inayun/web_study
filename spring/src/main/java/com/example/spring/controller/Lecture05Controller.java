package com.example.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.entity.Member;


@Controller
public class Lecture05Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture05Controller.class);
	
	
	
	@RequestMapping(value = "/requestParam.do")
	public String home(
			@RequestParam(value="id", defaultValue = "hong") String id,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			Model model) {
		
		logger.info("id is {}.", id);
		logger.info("name is {}.", name);
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("hobby",hobby);
		return "/lecture05/lecture05";
	}
	
	@RequestMapping(value="/lecture05/02.do")
	public String command(Member mem, Model model) {
		
		logger.info("mem is {}.", mem);
		
		model.addAttribute("mem",mem);
		return "/lecture05/lecture0502";
	}
	
	
	
	
	
	

}

