package com.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Part;

@WebServlet("/Upload")
@MultipartConfig(maxFileSize=1024*1024*2, location="c://Upload")
public class UploadServlet extends HttpServlet {
	
	private String getFilename(Part part) {
		//Part의 헤더 정보로부터 업로드 파일명을 파싱하여 리턴하는 부분
		String fileName = null;
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] elements = contentDispositionHeader.split(";");
		
		for(String element : elements) {
			
			if(element.trim().startsWith("filename")) { //첫글자가 filename으로 시작하는 경우
				fileName = element.substring(element.indexOf("=")+1);
				fileName= fileName.trim().replace("\"", "");
			}
		}
		return fileName;
	}
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		Part part = request.getPart("theFile");
		//업로드 폼에서 넘어온 파일이름을 part 객체로 리턴함
		
		String fileName = getFilename(part);
		//part 정보를 이용하여 업로드 파일명을 리턴함
		
		if(fileName != null && !fileName.isEmpty()) {
			part.write(fileName);
			
		}
	
		//multipart 형식의 폼 데이터는 getBytes()를 사용하여 인코딩 처리함
		String author = request.getParameter("theAuthor");
		author = new String(author.getBytes("utf-8"),"utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
/*		out.print("작성자" + author + "<br>");
		out.print("파일명 : " + fileName + "<br>");
		out.print("파일크기 : " + part.getSize() + "<br>");*/
		
		
		
		out.print("작성자" + author + "<br>");
		out.print("파일명 : <a href='FileDown?file_name=" + fileName + "'>" + fileName + "</a><br>");
		out.print("파일크기 : " + part.getSize() + "<br>");

	}
	

}
