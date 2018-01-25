<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="/error/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

	name 파라미터 값:
	<%= request.getParameter("name").toLowerCase() %>
	
</body>
</html>