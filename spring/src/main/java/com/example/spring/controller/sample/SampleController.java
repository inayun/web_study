package com.example.spring.controller.sample;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.service.sample.SampleService;

@Controller
public class SampleController {

	//URL에서 넘어온 
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	SampleService sampleService;
	
	@RequestMapping(value="/sampleList.do")
	public @ResponseBody HashMap<String,List<HashMap<String,Object>>> sampleList(HttpServletRequest request) {
		
		//sql query 사용시 필요한 값   파라미터로 받아서 맵에 넣어 보내줌
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("deptNo",request.getParameter("deptNo"));
		
		
		List<HashMap<String,Object>> list = sampleService.sampleList(map);
		
		HashMap<String,List<HashMap<String,Object>>> mapList = new HashMap<String,List<HashMap<String,Object>>>();
		mapList.put("list", list);
		
		/*
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("sample/sampleList"); //sampleList.jsp
		*/
		
		return mapList; //서비스에서 mv가 리턴되서 그게 컨트롤러에서 그대로 다시 리턴됨
	}
	
	@RequestMapping(value="/sampleCount.do")
	public ModelAndView sampleCount(HttpServletRequest request) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("deptNo","10");
		
		int cnt = sampleService.sampleCount(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("cnt",cnt);
		mv.setViewName("sample/sampleList"); //sampleList.jsp
		
		return mv; //서비스에서 mv가 리턴되서 그게 컨트롤러에서 그대로 다시 리턴됨
	}
	
}
