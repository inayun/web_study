<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="com.oreilly.servlet.MultipartRequest" %>
    <!-- 파일 중복처리인 경우 이름 재정의-->
    <%@page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
    <%@page import = "java.util.*" %>
    <%@page import = "java.util.Enumeration" %>
    
    <%
    //업로드 될 경로를 의미함
    String uploadPath = request.getRealPath("upload"); //폴더명을 적은거임
     
    //파일의 크기를 지정함
    int size = 10*1024*1024; //10Mbyte
    
    String subject = "";
    String name = "";
    String fileName1 = "";
    String fileName2 = "";
    String origfilename1 = ""; //filename1의 원본파일
    String origfilename2 = ""; //filename2의 원본파일


 /*    
    MultipartRequest(javax.servlet.http.HttpServletRequest request,
			java.lang.String saveDirectory,
			int maxPostSize,
			java.lang.String encoding,
			FileRenamePolicy policy)

	request : MultipartRequest와 연결할 request 객체를 의미함
	saveDirectory : 서버 측에 저장될 경로를 의미함
	maxPostSize : 최대 파일의 크기를 의미함
	encoding : 파일의 인코딩 방식을 의미함
	policy : 파일 중복처리를 위한 인자를 의미함 (파일 중복해서 다운받을때 이름바껴서 받아지는 처리)
    
     */
    
    try {
    	
    	MultipartRequest multi = 
    			new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
    	
    	
    	name = multi.getParameter("name");
    	subject = multi.getParameter("subject");
    	
    	Enumeration files = multi.getFileNames();
    	
    	//첫번째 파일
		//file1이 Enumeration에 저장되어 있다가 nextElement()에 의해서 
		//파일을 꺼내 file1에 저장
    	String file1 = (String)files.nextElement(); //파일들 중 '첫번째' 파일!
    	fileName1 = multi.getFilesystemName(file1);
    	origfilename1 = multi.getOriginalFileName(file1);

    			
    			
    	String file2 = (String)files.nextElement(); //파일들 중 '두번째' 파일!
    	fileName2 = multi.getFilesystemName(file2);
    	origfilename2 = multi.getOriginalFileName(file1);
    	
    } catch (Exception e){
    	e.printStackTrace();
    }
    %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

	<form name="filecheck" action="fileCheck.jsp" method="post">
		<input type="hidden" name ="name" value="<%= name %>">
		<input type="hidden" name ="subject" value="<%= subject %>">
		<input type="hidden" name ="fileName1" value="<%= fileName1 %>">
		<input type="hidden" name ="origfilename1" value="<%= origfilename1 %>">
		<input type="hidden" name ="fileName2" value="<%= fileName2 %>">
		<input type="hidden" name ="origfilename2" value="<%= origfilename2 %>">
	</form> 

	<a href="#" onclick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지로 이동</a>
	
</body>
</html>