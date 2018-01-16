<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    Map<String, String> map = new HashMap();
	map.put("id","hong1234");
	map.put("pwd","1234");
	map.put("age","30");
	
	request.setAttribute("map1", map);
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= map.get("id") %> <br>
	
	id : ${ requestScope.map1.get("id") } <br>
	id : ${map1.get("id") } <br>
	pwd : ${map1['pwd']} <br>
	age : ${map1.age} <br>
	
</body>
</html>