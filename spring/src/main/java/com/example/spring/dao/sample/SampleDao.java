package com.example.spring.dao.sample;

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
public class SampleDao {

	
	private static final Logger logger = LoggerFactory.getLogger(SampleDao.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public List<HashMap<String,Object>> sampleList(HashMap<String,String> map){
		
		List<HashMap<String,Object>> list = this.sqlSession.selectList("test.testList",map);
		
		return list;
	}
	
	/*
	VO객체를 사용
	*/
	public SampleEntity sampleVOList(SampleEntity sampleEntity){
		
		return this.sqlSession.selectOne("test.testVOList",sampleEntity);
	}
	
	
	/**
	 * 샘플리스트에서 카운트 조회
	 * @param map 조회조건
	 * @return
	 */
	public int sampleCount(HashMap<String,String> map){
		
		int cnt = this.sqlSession.selectOne("test.testCount",map);
		
		return cnt;
	}
	
	
	/*
	데이터 삽입
	
	*/
	public int sampleInsert(HashMap<String,String> map){
	
	/*	insert 하면 삽입된 개수가 반환됨*/
		int cnt = this.sqlSession.insert("test.testInsert",map);
		
		return cnt;
	}
	
	/*
	데이터 수정
	
	*/
	public int sampleUpdate(HashMap<String,String> map){
	
	/*	insert 하면 삽입된 개수가 반환됨*/
		int cnt = this.sqlSession.update("test.testUpdate",map);
		
		return cnt;
	}
	
	
	/*
	데이터 삭제
	
	*/
	public int sampleDelete(HashMap<String,String> map){
	
	/*	insert 하면 삽입된 개수가 반환됨*/
		int cnt = this.sqlSession.delete("test.testDelete",map);
		
		return cnt;
	}
}
