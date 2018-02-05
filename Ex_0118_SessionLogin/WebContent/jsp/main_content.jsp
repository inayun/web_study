<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--로그인을 안하면 body로 못 넘어가고 check_login.jsp로 먼저 넘어감 --%>
<%@include file="check_login.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	:::HttpSession 객체
	- HTTP 프로토콜은 연결 프로토콜
	- 클라이언트가 서버와 연결하고 요청을 보낸뒤 서버가 요청을 처리한 후 
	응답을 보내면 클라이언트와 서버의 연결이 끊어짐
	- 서버와 클라이언트의 유지를 위하여 HttpSession 객체를 사용함

	:::동작원리
	1. 클라이언트 요청접수(Request)
	2. 클라이언트가 정보를 저장할 HttpSession 객체를 생성하여 id를 부여
	3. HttpSession 객체내에 클라이언트 정보를 저장
	4. 부여받은 id값을 응답에 넣어서 클라이언트에게 보냄
	5. 클라이언트는 다음 번 요청부터를 id 값으로 전송함

	:::HttpSession 에서 사용하는 주요 메소드()
	
	1. setAttribute(String name, Object object)
	2. getAttribute(String name)
	3. removeAttribute()
	4. setMaxInactiveInterval(int second)
	5. invalidate()
	6. getId()


	여기는 로그인을 해야 볼 수 있는 메인 페이지 입니다.
	<br>
	${sessionScope.user.name} 님 환영합니다. <br>
	
	<input type="button" value="로그아웃" onclick="location.href='logout.do'">
	
</body>
</html>