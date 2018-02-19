<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page session="true" %>

<%
	request.setAttribute("name", "홍길동");
%>    
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

	요청 URI : ${pageContext.request.requestURI}; 
	
	request의 name 속성 : ${requestScope.name} <br> <!-- 홍길동 -->
	
	code 파라미터 : ${param.code} <br>  <!--  test  -->
	<!-- http://localhost:9090/ELProject/actiontag/ELEx4.jsp?code=test  -->

</body>
</html>