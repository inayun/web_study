package com.example.spring.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.controller.sample.SampleController;
import com.example.spring.service.board.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	
	@RequestMapping(value="/boardInsert.do")
	public @ResponseBody HashMap<String,String> boardInsert(HttpServletRequest request){
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("boardTitle", request.getParameter("boardTitle"));
		map.put("boardContent", request.getParameter("boardContent"));
		map.put("createWriter", request.getParameter("createWriter"));
		map.put("updateWriter", request.getParameter("createWriter"));
		
		int cnt = boardService.boardInsert(map);
		
		map.put("result", "글 작성 실패!");
		
		if(cnt > 0) {
			map.put("result", "글 작성 완료!");
		}
		return map;
	}
	
	

	@RequestMapping(value="/boardList.do")
	public @ResponseBody ModelAndView boardList(HttpServletRequest request){
		
		List<HashMap<String,Object>> list = boardService.boardList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	
	@RequestMapping(value="/boardSearch.do")
	public @ResponseBody List<HashMap<String,Object>> boardSearch(HttpServletRequest request){
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String searchInput = '%' + request.getParameter("searchInput") + '%';
		map.put("searchInput", searchInput);
		map.put("searchScope", request.getParameter("searchScope"));
		
		List<HashMap<String,Object>> list = boardService.boardSearch(map);
		
		return list;
	}
	
	@RequestMapping(value="/boardDetail.do")
	public @ResponseBody ModelAndView boardDetail(HttpServletRequest request){
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("boardNum", request.getParameter("boardNum"));
		
		int cnt = boardService.boardUpdateClick(map);
		
		List<HashMap<String,Object>> list = boardService.boardDetail(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", list);
		mv.setViewName("board/boardDetail");
		
		return mv;
	}
	

	@RequestMapping(value="/boardUpdate.do")
	public @ResponseBody HashMap<String,String> boardUpdate(HttpServletRequest request){
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("boardNum", request.getParameter("boardNum"));
		map.put("boardTitle", request.getParameter("boardTitle"));
		map.put("boardContent", request.getParameter("boardContent"));
		map.put("updateWriter", request.getParameter("updateWriter"));
		
		int cnt = boardService.boardUpdate(map);
		
		map.put("result", "글 수정 실패!");
		
		if(cnt > 0) {
			map.put("result", "글 수정 완료!");
		}
		return map;
	}
	
	
	@RequestMapping(value="/boardDelete.do")
	public @ResponseBody HashMap<String,String> boardDelete(HttpServletRequest request){
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("boardNum", request.getParameter("boardNum"));
		
		int cnt = boardService.boardDelete(map);
		
		map.put("result", "글 삭제 실패!");
		
		if(cnt > 0) {
			map.put("result", "글 삭제 완료!");
		}
		return map;
	}
	
}
