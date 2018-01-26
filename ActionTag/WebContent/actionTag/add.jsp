<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%
    	request.setCharacterEncoding("utf-8");
    %>
    
   <jsp:useBean id="customer" class="actionTag.Customer" />
   <jsp:setProperty property="name" name="customer" />
   <jsp:setProperty property="email" name="customer" />
   <jsp:setProperty property="phone" name="customer" />
    
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

	name : <jsp:getProperty property="name" name="customer"/> <br>
	email : <jsp:getProperty property="email" name="customer"/> <br>
	phone : <jsp:getProperty property="phone" name="customer"/> <br>
	
</body>
</html>