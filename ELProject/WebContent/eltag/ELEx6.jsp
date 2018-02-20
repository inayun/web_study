<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page session = "true" %>
    <%@ taglib prefix="elfunc" uri="/WEB-INF/tlds/el-functions.tld" %>
    
    <%
    
    java.util.Date today = new java.util.Date();
    request.setAttribute("today", today);
    
    
    request.setAttribute("price", 12345);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<title>EL 함수 호출</title>
</head>
<body>

	오늘은 <strong>${elfunc:dateFormat(today)} </strong><br>
	
	가격은 ${elfunc:formatNumber(price, '##,##0')} <br>
</body>
</html>