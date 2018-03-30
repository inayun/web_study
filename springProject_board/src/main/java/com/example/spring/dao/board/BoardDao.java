package com.example.spring.dao.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDao {

	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	@Autowired
	SqlSession sqlSession;
	
	/*
	 * 게시글 입력
	 */
	public int boardInsert(HashMap<String,String> map) {
		
		return this.sqlSession.insert("board.boardInsert",map); 
	}
	
	/*
	 * 게시글 전체 가져오기
	 */
	public List<HashMap<String,Object>> boardList(){
		
		 return this.sqlSession.selectList("board.boardList");
	}
	
	/*
	 * 게시글 전체 개수 
	 */
	public int boardCount() {

		return this.sqlSession.selectOne("board.boardCount"); 
	}
	
	
	/*
	 * 게시글 검색에 따른 개수 
	 */
	public int boardSearchCount(HashMap<String,String> map) {

		return this.sqlSession.selectOne("board.boardSearchCount",map); 
	}
	
	
	/*
	 * 검색영역에 따른 검색결과
	 */
	public List<HashMap<String,Object>> boardSearch(HashMap<String,String> map) {
		
		return this.sqlSession.selectList("board.boardSearch",map);
		
	}
	
	/*
	 * 글 상세 보기
	 */
	
	public List<HashMap<String,Object>> boardDetail(HashMap<String,String> map) {
		
		return this.sqlSession.selectList("board.boardDetail",map);
		
	}
	

	/*
	 * 글 수정하기
	 */
	public int boardUpdate(HashMap<String,String> map) {
		
		return this.sqlSession.update("board.boardUpdate",map);
		
	}
	
	/*
	 * 조회수 업뎃하기
	 */
	public int boardUpdateClick(HashMap<String,String> map) {
		
		return this.sqlSession.update("board.boardUpdateClick",map);
		
	}

	/*
	 * 글 삭제하기
	 */
	public int boardDelete(HashMap<String,String> map) {
		
		return this.sqlSession.update("board.boardDelete",map);
		
	}
	
}
