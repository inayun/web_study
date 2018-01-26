<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

	<form action="add.jsp" method="post">
		<table>
		
			<tr>
				<td>이름</td>
				<input type="text" name="name">
			</tr>
			
			<tr>
				<td>이메일</td>
				<input type="text" name="email">
			</tr>
			
			<tr>
				<td>전화번호</td>
				<input type="text" name="phone">
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
				</td>
			</tr>
		
		</table>
	
	</form>

</body>
</html>