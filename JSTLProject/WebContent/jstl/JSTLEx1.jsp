<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 태그 라이브러리 명시 c : core (변수지정, 흐름제어, URL관리)-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!-- 자바 빈 설정 -->
<jsp:useBean id="vo" class="jstl.MemberVO"/> 

 
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<!-- 변수 지원 태그 -->
<!-- target : 프로퍼티 값을 설정할때 대상 객체를 지정할때 사용 -->
<!-- var : 값을 저장할 EL 변수 이름을 지정함 -->
<%-- <c:set var="name" value="홍길동"/> --%>
<!-- String name = "홍길동" -->
<c:set target="${vo}" property="name" value="홍길동"></c:set>

<c:set target="${vo}" property="email">
hong@email.com
</c:set> 


<c:set var="age" value="30" />
<c:set target="${vo }" property="age" value="${age }" />

<ol>
	<li> 이름 : ${vo.name }</li>
	<li> 메일 : ${vo.email }</li>
	<li> 나이 : ${vo.age}</li>
</ol>

</body>
</html>