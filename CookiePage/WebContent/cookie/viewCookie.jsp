<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.net.URLEncoder" %>    
    
<!DOCTYPE html>
<html>
<head>
<title>쿠키 목록</title>
</head>
<body>

쿠키목록<br>

<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null&&cookies.length>0){
		//쿠키의 값이 존재할 경우(널이 아니고 쿠키의 길이가 0보다 클경우)
		 
		for(int i =0; i<cookies.length; i++){
%>			
			
			<%= cookies[i].getName() %> = 
			<%= URLEncoder.encode(cookies[i].getValue()) %> <br>
			
	
			<%
		}
	} else { //쿠키가 존재하지 않을 경우
	%>	
		쿠키가 존재하지 않습니다.
		
	<% } %>

</body>
</html>