<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    Cookie cookie = new Cookie("C","C.jsp");
    response.addCookie(cookie);
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	A.jsp에 방문해 주셔서 감사합니다.
	<br>
	<a href="A.jsp">A 페이지로 이동하기</a>

</body>
</html>