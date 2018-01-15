<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	/* 
	
	EL ( Expression Language ) :  JSP에서 사용하는 표현식을 '조금 더 간결하게' 사용할 수 있도록 해주는 표현
	EL 표현식을 사용하려면 4개 영역중 어떤 영역에서 사용하고자 하는 지를 명시해줘야함

	1) page 영역 : 웹 브라우저의 요청이 들어오면 현재 페이지에서만 대응
	2) request 영역 :(가장 많이 사용하는 영역) : 같은 request 영역이라면 두개의 페이지가
 		하나의 요청을 공유할 수 있음
	3) session 영역 (두번째로 많이 사용하는 영역) : 전역 개념으로 페이지가 닫혀도 남아있음
		톰캣이 실행될 때 자동으로 만들어지는 영역
	4) application 영역 : 같은 웹 애플리케이션에서 요청되는 페이지들이 같은 객체를 공유

	EL표현식의 접근 형식
	${영역.변수명}
*/

	String msg = "안녕하세요";

	//pateScope 영역에 값을 저장
	pageContext.setAttribute("msg",msg);
	
	request.setAttribute("msg", "requestScope 영역의 값");
	
	session.setAttribute("msg2", "sessionScope 영역의 값");
%>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	일반 jsp 표현식 : <%= msg %> <br>
	pageScope : ${pageScope.msg} <br>
	requestScope : ${requestScope.msg} <br>
	sessionScope : ${sessionScope.msg2} <br>
	영역 생략 : ${msg} <br>
	
	<!-- 영역을 생략할 경우 참조 순서
		pageScore > requestScope > sessionScope > applicationScope
	 -->
	 
	 파라미터 : ${param.my_msg} <br>
</body>
</html>