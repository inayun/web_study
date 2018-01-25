<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ page import="java.util.*" %>   
    <!-- extends="single.SingleThreadServlet" -->
    
    
    
<%!
//변수 및 메소드 선언

private int num1 = 0;

public void jspInit(){
	System.out.println("jspInit 메소드 호출");
}

public void jspDestroy(){
	System.out.println("jspDestroy 메소드 호출");
}
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<% 
	int num2 = 0;
	num1++; //새로 고칠때마다 증가
	num2++; //새로 고칠때마다 초기화 동작
%>

	<ul>
		<li>num1 : <%= num1 %></li>
		<li>num2 : <%= num2 %></li>
		
	</ul>


</body>
</html>