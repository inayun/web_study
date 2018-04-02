package com.example.spring.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.service.Lecture01Service;

@Controller
public class Lecture01Controller {
	
	@Autowired
	Lecture01Service lecture01Service;
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture01Controller.class);
	
	
	@RequestMapping(value="/lecture01.do")
	public String lecture06(HttpServletRequest request, Model model) {
		
		logger.info("lecture01.do controller 들옴");

		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id", "id value");
		map.put("password", "password value");
	
		lecture01Service.lecture01Sample(map);
		
		model.addAttribute("id","id values");

		return "/lecture01/lecture01";
		
	}
	
	
}