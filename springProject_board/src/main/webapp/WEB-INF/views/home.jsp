<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

DispatcherServlet : 사용자의 웹 요청에 따른 정보를 공유하는 객체
HandlerMapping : 사용자의 웹 요청에 따른 해당 컨트롤러 결정 처리
Controller : 사용자의 웹 요청을 처리하는 컨트롤러
ModelAndView : 전달한 데이터와 이동페이지를 관리
ViewResolver : 사용자에게 결과를 보여줄 View를 결정하는 객체
View : 사용자에게 보여줄 페이지


</body>
</html>
