package com.example.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.service.Lecture08Service;

@Controller
public class Lecture08Controller {
	
	@Autowired
	Lecture08Service lecture08Service;
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture08Controller.class);
	
	@RequestMapping(value="/lecture08Insert.do")
	public String lecture06(HttpServletRequest request, Model model) {
	
		
		logger.info("Lecture08Controller 진입");
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String,String>>();
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("deptNo", "90");
		map1.put("dName", "90dName");
		map1.put("loc", "90loc");
		arrayList.add(map1);
		
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("deptNo", "90");
		map2.put("dName", "91dName");
		map2.put("loc", "91loc");
		arrayList.add(map2);
		
		HashMap<String,String> map3 = new HashMap<String,String>();
		map3.put("deptNo", "92");
		map3.put("dName", "92dName");
		map3.put("loc", "92loc");
		arrayList.add(map3);

		lecture08Service.lecture08Insert(arrayList);
		
		
		return "/lecture08/lecture08";
		
	}
	
	
}