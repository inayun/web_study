<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String type = request.getParameter("type");
    
    	if(type != null){
    		
    %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<table width="100" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td>타입</td>
		<td><%= type %></td>
	</tr>
	
	<tr>
		<td>특징</td>
		<td>
		<% if(type.equals("A"))  { %>
				강한 내구성을 보유함
		<% } else if (type.equals("B")) { %>
				뛰어난 대처 능력을 보유함
		<% } %>
		</td>
	</tr>


	</table>
<% } %>

</body>
</html>