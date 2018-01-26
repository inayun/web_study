<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 선택하여 페이지 이동 </title>
</head>
<body>

이동하려는 페이지 선택 : 
<form action="<%= request.getContextPath()%>/forward/view.jsp">
	<select name="code">
		<option value="A">A페이지</option>
		<option value="B">B페이지</option>
		<option value="C">C페이지</option>
	</select>
	
	<input type="submit" value="이동">
</form>
</body>
</html>