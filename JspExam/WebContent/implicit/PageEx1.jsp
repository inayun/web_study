<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP File</title>
</head>
<body>

	<h2>JSP Script</h2>

	<%!
	//변수 및 메소드 선언
	String hh = "hi";
	
	public String declareEx(){
		return "헬로월드";
	}
	%>
	
	<%
	
	%>
	
	<%= declareEx() %>
	
</body>
</html>