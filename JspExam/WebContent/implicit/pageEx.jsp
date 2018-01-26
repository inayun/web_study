<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>


<% 
	HttpServletRequest httpRequest = 
	(HttpServletRequest)pageContext.getRequest();
%>

request 기본 객체와 pageContext.getRequest()가 같을까
<%= request == httpRequest %>

pageContext.getOut() 메소드 사용해서 데이터 출력
<% pageContext.getOut().println("Let's have a break!"); %>

</body>
</html>