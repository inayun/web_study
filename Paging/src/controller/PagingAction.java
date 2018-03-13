package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.PagingService;

//@WebServlet("/PagingAction")
public class PagingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
		request.setAttribute("page", pageResult);
		
		int lastNum = pageboardCount * curPage;
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("pagepageCount", pagepageCount);
		request.setAttribute("pageboardCount", pageboardCount);
		request.setAttribute("curPage", curPage);
		request.setAttribute("lastNum", lastNum);
		
		request.getRequestDispatcher("tableboard.jsp").forward(request, response);
	}
	
}
