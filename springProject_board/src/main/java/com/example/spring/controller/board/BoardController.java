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

import com.example.spring.service.board.BoardService;
import com.example.spring.service.board.PagingService;
import com.google.gson.Gson;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	PagingService pagingService;
	
	static int pagepageCount = 5; //한페이지에 보이는 페이징 수
	static int pageboardCount = 10; //한 페이지에 보이는 게시글 수
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
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
	
	
	/*
	 *  리스트에 페이징 처리 추가!!
	 */
		
	@RequestMapping(value="/boardList.do")
	public @ResponseBody ModelAndView boardList(HttpServletRequest request){
		
		
		List<HashMap<String,Object>> list = boardService.boardList();
		Gson gson = new Gson();
		String listJson = gson.toJson(list);
		String curPage = request.getParameter("curPage");
		
		if(curPage==null) {
			curPage = "1";
		}
		ModelAndView mv = new ModelAndView();
		
		
		
		mv.addObject("list", listJson);
		mv.addObject("curPage", curPage);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	
	@RequestMapping(value="/boardSearch.do")
	public @ResponseBody ModelAndView boardSearch(HttpServletRequest request){
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		String searchInput = '%' + request.getParameter("searchInput") + '%';
		map.put("searchInput", searchInput);
		map.put("searchScope", request.getParameter("searchScope"));
		
		List<HashMap<String,Object>> list = boardService.boardSearch(map);
		
		Gson gson = new Gson();
		String listJson = gson.toJson(list);
		String curPage = request.getParameter("curPage");
		
		if(curPage==null) {
			curPage = "1";
		}
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", listJson);
		mv.addObject("curPage", curPage);
		mv.setViewName("board/boardList");

		
		return mv;
	}
	
	@RequestMapping(value="/boardDetail.do")
	public @ResponseBody ModelAndView boardDetail(HttpServletRequest request){
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("boardNum", request.getParameter("boardNum"));
		
		int cnt = boardService.boardUpdateClick(map);
		
		List<HashMap<String,Object>> list = boardService.boardDetail(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", list);
		mv.addObject("curPage", request.getParameter("curPage"));
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
