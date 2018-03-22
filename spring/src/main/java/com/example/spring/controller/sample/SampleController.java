package com.example.spring.controller.sample;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.service.sample.SampleService;

@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	SampleService sampleService;
	
	@RequestMapping(value="/sampleList.do")
	public ModelAndView sampleList(HttpServletRequest request) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("deptNo",request.getParameter("deptNo"));
		
		return sampleService.sampleList(map);
	}
	
	
}
