package com.example.spring.service.board;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dao.board.BoardDao;
import com.example.spring.service.sample.SampleService;

@Service
public class BoardService {
	
	@Autowired
	BoardDao boardDao;

	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

	
	/*
	 * 게시판 글 삽입
	 */
	public int boardInsert(HashMap<String,String> map) {
		return boardDao.boardInsert(map);
	}
	
	/*
	 * 게시글 전체 가져오기
	 */
	public  List<HashMap<String,Object>> boardList(){
		return boardDao.boardList();
	}

	
	/*
	 * 검색영역에 따른 검색결과
	 */
	public  List<HashMap<String,Object>> boardSearch(HashMap<String,String> map){
		return boardDao.boardSearch(map);
	}
	
	/*
	 * 글 상세 보기
	 */
	public  List<HashMap<String,Object>> boardDetail(HashMap<String,String> map){
		return boardDao.boardDetail(map);
	}
	
	/*
	 * 글 수정하기
	 */
	public int boardUpdate(HashMap<String,String> map){
		return boardDao.boardUpdate(map);
	}
	
	/*
	 * 조회수 업뎃하기
	 */
	public int boardUpdateClick(HashMap<String,String> map){
		return boardDao.boardUpdateClick(map);
	}
	

	/*
	 * 글 삭제하기
	 */
	public int boardDelete(HashMap<String,String> map){
		return boardDao.boardDelete(map);
	}
	
}

