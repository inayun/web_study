package com.example.spring.controller;

import java.util.Calendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.beantest.SmsSender;

@Controller
public class Lecture04Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture03Controller.class);
	
	@Autowired
	SmsSender smsSender;
	
	@RequestMapping(value = "/lecture04", method = RequestMethod.GET)
	public String home(Locale locale,Model model) {
		
		logger.info("smsSender :" + smsSender.isValue());
		
		model.addAttribute("smsSender", smsSender.isValue());
		
		return "/lecture04/lecture04";
		
	}

}

