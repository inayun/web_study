<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8"); 
    %>
    
    <jsp:useBean id="msg" class="actionTag.ActionData" />
    <jsp:setProperty property="message" name="msg"/>
   
    
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<hr>
<font size="10">
	메시지 : <jsp:getProperty property="message" name="msg"/>
</font>


</body>
</html>