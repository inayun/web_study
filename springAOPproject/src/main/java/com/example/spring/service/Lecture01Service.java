package com.example.spring.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Lecture01Service {

	private static final Logger logger = LoggerFactory.getLogger(Lecture01Service.class);
	
	
	public void lecture01Sample(HashMap<String,String> map) {
		
		logger.info("lecture01Sample 함수실행");
	}
	
	
}
