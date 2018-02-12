<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import ="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@page import ="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@page import ="org.apache.commons.fileupload.FileItem" %>

<%@ page import = "java.io.File" %>
<%@ page import = "java.io.IOException" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 업로드</title>
</head>
<body>

<%

//업로드된 파일이 저장되는 폴더
String strSaveDir = getServletContext().getRealPath("/Upload");
File saveDir = new File(strSaveDir);
out.println("업로드되는 파일이 저장될 폴더 :<br>" + saveDir.getPath() + "<p>");


//업로드에 필요한 임시 폴더
String strTempDir = getServletContext().getRealPath("temp");
File tempDir = new File(strTempDir);

if(!tempDir.exists()) { //폴더가 존재하지 않는경우
	tempDir.mkdirs(); //폴더 생성
}

out.println("업로드를 위한 임시폴더 : <br>" + tempDir.getPath()+"<p>");

if(ServletFileUpload.isMultipartContent(request)){
	//임시폴더에 저장할 파일 크기를 설정함
	
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setSizeThreshold(1024*10);//10kbyte (파일 크기 저장)
	//기본 단위는 byte. 기본 크기는 무제한
	
	//저장소를 설정함
	factory.setRepository(tempDir);
	
	//파일 업로드 처리기
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	//파일 크기 제약 설정 (해도되고 안해도 되지만, 파일 업로드시 특정사이즈내에서만 하게할때)
	//업로드되는 파일을 크기를 1Mbyte로 설정
	upload.setSizeMax(1024*1024);
	
	//request를 분석해서 각 항목별로 처리함
	List<FileItem> items = upload.parseRequest(request);
	out.println("<h3> 업로드 처리 결과 </h3><p><hr>");

	for(FileItem fileItem : items){
		
		//일반인자와 파일 업로드 인자를 구분하여 처리
		if(fileItem.isFormField()){
			//파일 이외의 파라미터 내용 출력
			out.println(fileItem.getFieldName() + ":" + fileItem.getString("utf-8")+"<hr>");
		} else {
			//업로드된 파일이 존재한다면
			if(fileItem.getSize() > 0){
				
				//파일이름만 추출하여 fileName에 저장
				String fileName = new File(fileItem.getName()).getName();
				//업로드 파일 저장할 폴더 생성
				
				if(!saveDir.exists()){
					saveDir.mkdirs();
				}
				
				try{
					File uploadedFile = new File(saveDir,fileName);
					
				
					//같은 이름이 이미 있으면, '현재시간 정보'를 뒤에 붙인 파일 이름으로 저장
					if(uploadedFile.exists()){
						java.util.Date now = new java.util.Date();
						
						String newFileName = fileName + "-" + now.getTime();
						uploadedFile = new File(saveDir,newFileName);
						
						out.println("이름이 같은 파일이 있어 다음 파일 이름을 수정함");
						out.println("이전 파일 이름 :" + fileName);
						out.println("수정된 파일 이름 : " + newFileName);
						
					}
				
					//업로드 파일 저장
					 fileItem.write(uploadedFile);
					out.println("업로드 폴더 위치 : " + saveDir.getPath() + "<br>");
					out.println("업로드 파일 이름 : " + uploadedFile.getName()+"<br>");
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
}


%>


</body>
</html>