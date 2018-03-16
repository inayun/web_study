package com.example.spring.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Handles requests for the application home page.
 */

public class Lecture01Controller extends AbstractController {
	private String me;

	public void setMe(String me) {
		this.me = me;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("lecture01/lecture01"); //이동할 페이지에 대한 정보  WEB-INF/views/lecture01/lecture01.jsp
		mav.addObject("greeting", getGreeting());
		mav.addObject("me", me);
		return mav;
	}
	
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <= 10) {
			return "아침입니다.";
		} else if (hour >= 12 && hour <= 15) {
			return "오후입니다.";
		} else if (hour >= 18 && hour <= 22) {
			return "저녁입니다.";
		}
		return "안녕하세요";
	}

}

