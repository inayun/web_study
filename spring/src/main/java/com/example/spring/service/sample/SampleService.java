package com.example.spring.service.sample;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.controller.sample.SampleController;
import com.example.spring.dao.sample.SampleDao;

@Service
public class SampleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

	@Autowired
	SampleDao sampleDao;
	
	
	public ModelAndView sampleList(HashMap<String,String> map) {
		
		List<HashMap<String,Object>> list = sampleDao.sampleList(map); 
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("sample/sampleList"); //sampleList.jsp
		
		return mv;
	}
	
}
