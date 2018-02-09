<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    
    try{
    	if(session.getAttribute("userId") == null){ 
			response.sendRedirect("sessionMemberLogin.jsp");    		
    	}
    	
    } catch(Exception e){
    	e.printStackTrace();
    }
    
    %>

<!DOCTYPE html>
<html>
<head>
<title>세션을 이용한 간단한 쿠키 회원 인증</title>
</head>
<body>

	<form action="SessionLogOut.jsp" method="post">
		
		<table>
			<tr>
				<td>
				<%= session.getAttribute("userId") %> 님이 로그인하셨습니다.
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="로그아웃">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>