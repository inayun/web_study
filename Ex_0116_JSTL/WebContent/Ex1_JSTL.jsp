<%@page import="vo.PVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* 
	JSTL (JSP Standard Tag Library)
	연산이나 조건문, 반복문등을 jsp내에서 편하게 사용할 수 있도록 해주는 라이브러리
	 */
%>

<!-- c(Core) : if, forEach, choose와 같은 제어문 -->
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!-- fmt(format) : 출력형식 지정 (날짜 ,숫자) -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<% 
Date today= new Date();
request.setAttribute("today", today);

int money = 120000000;
request.setAttribute("m", money);

String[] array = {"apple","pear","grapes","banana"};
request.setAttribute("array", array);

ArrayList<String> sido = new ArrayList();
sido.add("seoul");
sido.add("busan");
sido.add("incheon");

request.setAttribute("sido", sido);

//List에 vo저장
ArrayList<PVO> p_list = new ArrayList();
PVO p1 = new PVO();
p1.setName("홍길동");
p1.setAge(20);

PVO p2 = new PVO();
p2.setName("김길동");
p2.setAge(30);

p_list.add(p1);
p_list.add(p2);

request.setAttribute("p_list", p_list);
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	JSTL의 forEach문
	
	<ul>
	
		<c:forEach var="n" begin="1" end="5" step="1">
			<li>hello ${n}</li>
		</c:forEach>
	</ul>

	<hr>
	
	JSTL의 if문 	
	<c:forEach var="i" begin="1" end="10" step="1">
	
		<c:if test="${ i % 2 == 0 }">
		${i}
		</c:if>
	</c:forEach>
	
	<hr>
	
	<fmt:formatDate value="${today}"/> <br>
	<fmt:formatDate value="${today}" pattern="YYYY년 MM월 DD일"/> <br>
	
	<fmt:formatNumber value="${m}"></fmt:formatNumber>
	<hr>
	
	<ul>
	<!-- for(String f : array){} -->
		<c:forEach var="f" items="${array}">
			<li>${f}</li>
		</c:forEach>
	</ul>
	
	<ul> 
		<c:forEach var="data" items="${sido}">
			<li>${data}</li>
		</c:forEach>
	</ul>
	
	<hr>
	
	ArrayList의 내용을 인덱스로 접근하여 출력<br>
	${sido.size()}
	<c:forEach var="i" begin="0" end="${sido.size()}" step="1">
		${sido[i] }
	</c:forEach>
	
	<br>ArrayList의 내용을 인덱스로 접근하여 출력<br>
	<c:forEach var="s" items="${sido}" varStatus="cnt">
		<%--
			cnt.index : 인덱스 번호부터(0부터)
			cnt.count : 순번(1부터)
				
			 --%>
		${cnt.index} / ${cnt.count}<br>
		<c:if test="${cnt.index mod 2 eq 0}">
			${s} <br>
		</c:if>
	</c:forEach>
		
	<hr>
	
	<c:forEach var="j" items="${p_list}" varStatus="cnt">
		${cnt.count}.  ${j.name} / ${j.age} <br>
	</c:forEach>
		
</body>
</html>