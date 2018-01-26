<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- MVC 웹 어플리케이션에서 Model에서 View측으로 데이터를 넘겨줄때, 
    	request scope에 데이터를 저장해서 View측으로 넘김
     -->
     
     
     <%
//pageContext Scope에 속성 저장
pageContext.setAttribute("pageAttribute","Hong");
//범위를 확실히 잡아주는 경우
//pageContext.setAttribute("pageAttribute", "Hong", PageContext.PAGE_SCOPE);

//request Scope에 속성 저장
request.setAttribute("requestAttribute", "010-1234-5678");
//pageContext.setAttribute("requestAttribute", "010-1234-5678", PageContext.REQUEST_SCOPE);

//session Scope에 속성 저장
session.setAttribute("sessionAttribute", "hong@hanmail.net");
//pageContext.setAttribute("sessionAttribute", "hong@hanmail.net", PageContext.SESSION_SCOPE);


//application Scope에 속성 저장
application.setAttribute("applicationAttribute", "jeju");
//pageContext.setAttribute("applicationAttribute", "jeju", PageContext.APPLICATION_SCOPE);


%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<ul>
	<li>이름 : <%= pageContext.getAttribute("pageAttribute") %></li>
	<li>전화 : <%= request.getAttribute("requestAttribute") %></li>
	<li>메일 : <%= session.getAttribute("sessionAttribute") %></li>
	<li>주소 : <%= application.getAttribute("applicationAttribute") %></li>

</ul>

</body>
</html>