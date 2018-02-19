<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<form action="ELEx5.jsp" method="post">

	이름 : <input type="text" name="name" value="${param['name'] }">
		<input type="submit" value="전송">
</form>

name is ${param.name}

</body>
</html>