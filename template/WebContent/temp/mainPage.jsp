<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% request.setAttribute("PAGETITLE", "정보보기"); %>

<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<jsp:forward page="/temp/template/template.jsp">
	<jsp:param value="info_view.jsp" name="CONTENTPAGE"/>
</jsp:forward>


</body>
</html>