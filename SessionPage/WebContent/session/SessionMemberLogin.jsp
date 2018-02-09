<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<title>세션을 활용한 간단한 회원 인증</title>
<link href = "stylesheet.css" type="text/css" rel = "stylesheet">
</head>
<body>

<form action="SessionMemberLoginOk.jsp" method="post">

	<table border="1" align="center">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id">
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align ="center">
				<input type="submit" value="로그인" >
				<input type="reset" value="다시작성" >
			</td>
		</tr>
	</table>

</form>

</body>
</html>