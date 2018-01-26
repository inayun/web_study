<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<title> 헤더 목록 정보 출력</title>
</head>
<body>

<%
//헤더의 목록을 출력
Enumeration enumData = request.getHeaderNames();

while(enumData.hasMoreElements()){
	String headerName = (String)enumData.nextElement();
	String headerValue = request.getHeader(headerName);
%>

	<%= headerName %> = <%= headerValue %>

<%
}
%>

</body>
</html>