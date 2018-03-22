package com.example.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring.controller.service.Lecture05Service;
import com.example.spring.entity.Member;


@Controller
public class Lecture05Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Lecture05Controller.class);
	
	@Autowired
	Lecture05Service lecture05Service;
	
	
	//-----------------------------------------------------------
	@RequestMapping(value = "/requestParam.do")
	public String home(
			@RequestParam(value="id", defaultValue = "hong") String id,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			Model model) {
		
		logger.info("id is {}.", id);
		logger.info("name is {}.", name);
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("hobby",hobby);
		return "/lecture05/lecture05";
	}
	
	@RequestMapping(value="/lecture05/02.do")
	public String command(Member mem, Model model) {
		
		logger.info("mem is {}.", mem);
		
		model.addAttribute("mem",mem);
		return "/lecture05/lecture0502";
	}
	
	
	@RequestMapping(value="/lecture05/03.do")
	public String commandForm(Member mem, Model model) {
		
		logger.info("mem is {}.", mem);
		
		model.addAttribute("mem",mem);
		return "/lecture05/lecture0503";
	}
	
	//컨트롤러에서 공통적으로 항상 실행되어야 하는 코드 
	//위에서 암거나 호출될때 항상 무조건 실행됨. 
	@ModelAttribute("animalMap")
	// 출력페이지에서    items="${animalMap}" 로 받음
	public Map<String,String> getAnimalMap(){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("dog","개");
		map.put("cat","고양이");
		map.put("cow","소");
		map.put("pig","돼지");
		
		return map;
	}
	

	@RequestMapping(value="/lecture05/04.do")
	public String commandForm2(Member mem, Model model) {
		
		logger.info("mem is {}.", mem);
		
		model.addAttribute("mem",mem);
		return "/lecture05/lecture0504";
	}
	
	@ModelAttribute("animal")
	public ArrayList<String> getAnimalList(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("개");
		list.add("고양이");
		list.add("소");
		list.add("돼지");
		
		return list;
	}
	
	@RequestMapping(value="/lecture05/05.do")
	public String commandForm3(
			//자동으로 hashmap형태로 들어감 bean 파일 필요없음
			@RequestParam HashMap<String,String> params,
			@RequestParam(value="hobby") List<String> hobbyList,
			Model model) {
		
		model.addAttribute("params",params);
		model.addAttribute("hobbyList",hobbyList);
		
		return "/lecture05/lecture0505";
	}
	
	@RequestMapping(value="/lecture05/06.do")
	public String commandForm4(
			//자동으로 hashmap형태로 들어감 bean 파일 필요없음
			//그냥 hashmap<string,object> 를 쓰면, 
			//checkbox같이 name이 동일한 여러값들은 key값이 중복되기 때문에  다 담을 수가 없음
			//MultiValueMap 은 'List' 형태로 들어가서 key가 중복되도 사용 가능 
			@RequestParam MultiValueMap<String,Object> params,
			Model model) {
		
		List<Object> hobbyList = params.get("hobby");
		
		for(int i = 0; i < hobbyList.size(); i++) {
			logger.info("취미:" + hobbyList.get(i));
		}
		
		model.addAttribute("params",params);
		
		return "/lecture05/lecture0506";
	}
	
	
	@RequestMapping(value="/lecture05/ajax.do")
	public @ResponseBody HashMap<String,String> ajax(
			//메시지 컨버터 (message converter)
			// 내가 갖고있는 데이터를 사용자가 원하는 타입으로 변환해줌
			@RequestParam MultiValueMap<String,Object> params,
			Model model) {
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("success", "false"); //성공여부체크값
		
		
		
		List<Object> hobbyList = params.get("hobby");
		
		if(hobbyList != null) {
		for(int i = 0; i < hobbyList.size(); i++) {
			logger.info("취미:" + hobbyList.get(i));
			if(hobbyList.get(i).equals("baseball")) {
				map.put("success", "true");
			}
		}
		}
		
		model.addAttribute("params",params);
		
		return map; //{"success","true"} 형식으로 보내짐
	}


	@RequestMapping(value="/lecture05/ajaxFileUpload.do")
	public @ResponseBody HashMap<String,String> ajaxFileUpload(
			@RequestParam HashMap<String,String> params,
			//required 의 초기값은 true인데  false = 서버에서 파일이 안넘어와도 상관없다고 지정
			@RequestParam(value="file_test", required=false) List<MultipartFile> fileList,
			Model model) {
		

		return lecture05Service.ajaxFileUpload(fileList);
		
	}
}

