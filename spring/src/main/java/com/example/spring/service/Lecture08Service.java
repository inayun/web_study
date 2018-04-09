package com.example.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring.dao.Lecture08Dao;


@Service //비즈니스 로직
public class Lecture08Service {
	private static final Logger logger = LoggerFactory.getLogger(Lecture08Service.class);

	@Autowired
	Lecture08Dao lecture08Dao;
	

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class} )  
	//propagation = Propagation.REQUIRED 트랜잭션이 없으면 새롭게 만들어서 써라
	//rollbackFor={Exception.class} exception 에러가 일어났을경우 롤백시켜라
	//일반적으로는 구체적인 에러보다 최상위 에러가 나면 롤백되도록 함..
	
	public void lecture08Insert(ArrayList<HashMap<String,String>> arrayList){
		
		logger.info("Lecture08Service : lecture08Insert 실행");
		
		
		for(int i = 0; i < arrayList.size(); i++) {
			lecture08Dao.lecture08Insert(  (HashMap<String,String>)arrayList.get(i)  );
		}
		
		
	}
}
