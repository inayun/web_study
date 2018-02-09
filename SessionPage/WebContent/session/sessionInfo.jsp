<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 세션 생성 -->
    <%@ page session="true" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>

<%
	Date time = new Date();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<%
		//세션을 이용한 타임 아웃 설정
		//setMaxInactiveInterval() 메소드를 이용하여 설정
		
		//10분동안 아무런 액션이 없으면 자동으로 끊어짐
		session.setMaxInactiveInterval(2*60); 
%>
<!DOCTYPE html>
<html>
<head>
<title>세션 정보</title>
</head>
<body>

<%
	/*세션 속성 저장*/
	session.setAttribute("MEMBERID","test");
	session.setAttribute("NAME", "홍길동");
	session.setAttribute("number", 1234);
	
	//저장된 세션을 불러옴
	//반환활때 값을 타입으로 '캐스팅' 해줘야함
	String memberId = (String)session.getAttribute("MEMBERID");
	String name = (String)session.getAttribute("NAME");
	int number = (int)session.getAttribute("number");
	
	
%>


	세션 ID : <%= session.getId() %> <br>
	
	<%
		//세션이 생성된 시간
		time.setTime(session.getCreationTime());
	%>

	세션 생성시간 : <%= sdf.format(time) %> <br>
	
	<%
		//세션이 마지막으로 생성된 시간
		time.setTime(session.getLastAccessedTime());
	%>

	가장 최근 접근 시간 : <%= sdf.format(time) %>
	
	세션에 정보를 저장하였습니다. <br>
	
	<!-- 세션의 정보를 불러옴 -->
	<%= memberId %>
	<%= session.getAttribute("MEMBERID") %>

</body>
</html>