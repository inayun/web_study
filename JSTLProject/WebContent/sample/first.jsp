<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>스크립트릿</title>
</head>
<body>

<%

	String scriptlet = "스크립트릿! ";
	String comment = "주석문!";
	out.println("printWriter 내장 객체를 활용한 출력 : " + declation +"입니다.<br><Br>");
	
%>


<%! 
String declation = "선언문!!";
%>

<%!
public String decMethod(){
	return declation;
}
%>


<%= declation %>
<%= decMethod() %>
</body>
</html>