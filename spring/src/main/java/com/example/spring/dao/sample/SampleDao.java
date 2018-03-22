package com.example.spring.dao.sample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SampleDao {

	private static final Logger logger = LoggerFactory.getLogger(SampleDao.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public List<HashMap<String,Object>> sampleList(HashMap<String,String> map){
		
		List<HashMap<String,Object>> list = this.sqlSession.selectList("test.testList",map);
		
		return list;
	}
}
