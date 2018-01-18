<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  
  	//세션 :
  	//웹페이지간의 클라이언트 상태 유지를 위해 사용하는 공간
  	//서로 관련이 없는 페이지들 간 연관성을 설정하는 방법

  	//쿠키:
  	//인터넷 사용자가 웹사이트를 방문할 경우 그 사이트가 사용하고 있는 서버에서 
  	//사용자의 컴퓨터에 설치하는 작은 기록정보 파일
  	
  	//현재 페이지의 방문 정보를 쿠키에 기록
  	
  	Cookie cookie = new Cookie("A","A.jsp");
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
	<a href="B.jsp">B 페이지로 이동하기</a>
</body>
</html>