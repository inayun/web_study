<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="dao" class="memberone.StudentDAO" />
    
    <%
    
    	String id = request.getParameter("id");
    	boolean check = dao.idCheck(id);
    
    %>
<!DOCTYPE html>
<html>
<head>
<title>ID 중복체크</title>
<link href="stylesheet.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#FFFFCC">

<br>

<center>

<b><%= id %></b>

<%
	if(check){
		out.println("이미 존재하는 ID 입니다.");
	} else {
		out.println("사용가능한 ID입니다.");
	}
%>
	<a href="#" onclick="javascript:self.close()">닫기</a>

</center>

</body>
</html>