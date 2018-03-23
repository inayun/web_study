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
	//비즈니스 로직 처리하는 곳
	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

	@Autowired
	SampleDao sampleDao;
	
	
	public List sampleList(HashMap<String,String> map) {
		
		List<HashMap<String,Object>> list = sampleDao.sampleList(map); 
		
		return list;
	}
	
	public int sampleCount(HashMap<String,String> map) {
		
		int cnt = sampleDao.sampleCount(map); 
		
		return cnt;
	}
}
