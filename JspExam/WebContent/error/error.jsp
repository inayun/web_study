<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>

<!-- 
isErrorPage=true로 설정했을 경우 현재 JSP페이지의 exception 객체를 사용할 수 있고
false 면 사용할 수 없음
 -->
 
 <!-- ok = 200 -->
<% response.setStatus(HttpServletResponse.SC_OK); %>

<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
빨리 처리하겠습니다.죄송죄송

에러 타입 : <%= exception.getClass().getName() %>
에러 메시지 : <b><%= exception.getMessage() %></b>
</body>
</html>