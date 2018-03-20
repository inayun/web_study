<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<form action ="/lecture05/02.do">

<p> id : <input type="text" name="id">
<p> 이름 : <input type="text" name="name">
<p> 비밀번호 : <input type="password" name="password">
<p> 이메일 : <input type="text" name="email">
<p> 취미 : <input type="checkbox" name="hobby" value="baseball">야구
<input type="checkbox" name="hobby" value="reading">독서
<input type="checkbox" name="hobby" value="soccer">축구
<p><input type="submit" value="보내기">
</form>


</body>
</html>