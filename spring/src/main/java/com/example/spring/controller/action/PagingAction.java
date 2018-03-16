package com.example.spring.controller.action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.spring.controller.service.PagingService;
import org.springframework.web.servlet.mvc.AbstractController;


public class PagingAction extends AbstractController {
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		
		/*
	      totalCount                            // 가져온 전체글 수
	      countUnit                             // 페이지당 카운트 단위
	      unitCount                             // 카운트단위의 카운트
	      currentCount                          // 지금 사용자가 조회하고있는 페이지.
		
		*/
		
		int totalCount = Integer.parseInt(request.getParameter("totalCount"));
		int pagepageCount =  Integer.parseInt(request.getParameter("pagepageCount"));
		int pageboardCount = Integer.parseInt(request.getParameter("pageboardCount"));
		int curPage =  Integer.parseInt(request.getParameter("curPage"));
		
		String pageResult = PagingService.pageDivider(totalCount, pageboardCount, pagepageCount, curPage);
		int lastNum = pageboardCount * curPage;
		 //이동할 페이지에 대한 정보  WEB-INF/views/paging/tableboard.jsp
		mav.addObject("page", pageResult);		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagepageCount", pagepageCount);
		mav.addObject("pageboardCount", pageboardCount);
		mav.addObject("curPage", curPage);
		mav.addObject("lastNum", lastNum);
		mav.setViewName("paging/tableboard");
		
		System.out.println("curpage:" + curPage);
		return mav;
		
	}
	
}
