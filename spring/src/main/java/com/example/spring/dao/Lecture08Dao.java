package com.example.spring.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.SampleEntity;


//디비로 접근하는 곳
@Repository
public class Lecture08Dao {

	@Autowired
	private SqlSession sqlSession;
	
	private String MAPPER = "lecture08.";
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture08Dao.class);
	
	
	public int lecture08Insert (HashMap<String,String> paramMap){
		
		int cnt = this.sqlSession.insert(this.MAPPER + "lecture08Insert", paramMap);
		return cnt;
	}
	

}
