package com.example.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//syso는 휘발성이기 때문에 log를 사용해서 데이터를 저장해둘것
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//  value = url 주소,   method = get 과 post에 대한 구분 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	//파라미터에 대한 순서는 상관 없음 
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//request.setAttribute와 같은 개념
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //이동 view 주소 ..  "home.jsp" 같은 걸 의미...
	}
	
}
