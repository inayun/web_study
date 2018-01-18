<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 
 	Cookie cookie = new Cookie("B","B.jsp");
 
 	//쿠키에 지속성 추가
 	//특정 시간동안은 영구적으로 보관되는 쿠키
 	
 	cookie.setMaxAge(60*2); //2분동안 유효한 쿠키
 	response.addCookie(cookie);
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	B.jsp에 방문해 주셔서 감사합니다.
	<br>
	<a href="C.jsp">C 페이지로 이동하기</a>
</body>
</html>