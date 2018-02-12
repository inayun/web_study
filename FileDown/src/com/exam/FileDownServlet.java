package com.exam;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;

@WebServlet("/FileDown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("file_name");
		String sDownloadPath = "c:\\upload\\";
		String sFilePath = sDownloadPath + fileName;
		
		byte b[] = new byte[4096];
		// 4kbyte를 byte 배열을 이용하여 저장할 공간을 만듦
		
		FileInputStream in = new FileInputStream(sFilePath);
		String sMimeType = getServletContext().getMimeType(sFilePath);
		if(sMimeType == null) {
			// application/octet-stream : 
			//아카이브 문서(인코딩된 다중 파일),
			//모든 종류의 이진 데이터를 나타냄
			sMimeType = "application/octet-stream";
		}	
		
			response.setContentType(sMimeType);
			
			//한글처리
			String sEncoding = URLEncoder.encode(new String(fileName.getBytes("UTF-8"),"UTF-8"), "UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename="  + sEncoding);
			ServletOutputStream out = response.getOutputStream();
			
			int numRead;
			//읽어들인 문서의 용량
			
			while( (numRead = in.read(b, 0, b.length)) != -1 ) {
				//byte 배열을 이용하여 인덱스 0 을 기준으로 하여 마지막 인덱스까지 읽어옴. 파일의 마지막은 -1로 처리됨
				out.write(b, 0, numRead); //write는 byte 배열로 했을때 autoFlush 기능을 지원함
				
			}
			
			out.flush();
			out.close();
			in.close();
		
	}

}
