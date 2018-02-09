<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	request.setCharacterEncoding("utf-8");
    
    String name = request.getParameter("name");
    String subject = request.getParameter("subject");
    String fileName1 = request.getParameter("fileName1");
    String fileName2 = request.getParameter("fileName2");
    String origfilename1 = request.getParameter("origfilename1");
    String origfilename2 = request.getParameter("origfilename2");
    	
    %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

	제목 : <%= subject %><br>
	올린사람 : <%= name %><br>
	파일명1: <a href="/FileUpDown/upload/<%=fileName1 %>"> <%= origfilename1 %></a><br>
	
	파일1 : <%= fileName1 %><br>
	오리지널파일1 : <%= origfilename1 %><br>
	
	파일명2: <a href="/FileUpDown/upload/<%=fileName2 %>"> <%= origfilename2 %></a><br>
	파일2 : <%= fileName2 %><br>
	오리지널파일2 : <%= origfilename2 %><br>

</body>
</html>