package com.example.spring.controller.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service //비즈니스 로직
public class Lecture05Service {

	public HashMap<String,String> ajaxFileUpload(List<MultipartFile> fileList){
		
		//---------------파일 업로드 관련 로직--------------------
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("success","false");

		//파일리스트가 null이 아니거나 0보다 큰 경우
		if(fileList != null && fileList.size()>0) {
			
			String fileName = ""; //원본파일명
			long fileSize = 0; //파일사이즈
			String sysFileName = ""; //시스템파일명
			File uploadFile = null; //업로드한 파일
			int i = 0;
			
			//넘어온 파일 정보를 순환하면서 서버에 저장하는 로직
			for(MultipartFile file : fileList) {
				
				if(!file.isEmpty()) { 	//넘어온 파일이 정상적일 경우에만 실행
				
					fileName = file.getOriginalFilename(); //원본파일 이름
					fileSize = file.getSize();
					
					sysFileName = ""+System.currentTimeMillis()+fileName;	
					
					//separator
					uploadFile = new File("c:"+File.separator+"upload"+File.separator+sysFileName);
					
					try {
						file.transferTo(uploadFile);
						map.put("success","true");
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else { //넘어온 파일이 정상적이지 않을경우
					break;
				}
				
			}//for
			
		}
		
		
		return map;
	}
}
