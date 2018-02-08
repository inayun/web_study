<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    Cookie cookie = new Cookie("hour","1time");
  	cookie.setMaxAge(60); // 60초 (1분)
  	response.addCookie(cookie);
    
    %>
<!DOCTYPE html>
<html>
<head>
<title>쿠키의 유효시간 설정</title>
</head>
<body>

	유효시간이 설정된 쿠키가 생성됨
</body>
</html>