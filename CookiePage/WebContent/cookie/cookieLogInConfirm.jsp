<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    String id = "";
    
    try{
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){ //쿠키가 있을 경우
    		
    		for(int i = 0; i<cookies.length; i++){
    			//쿠키들중에서 userId이름의 쿠키가 있는경우
    			if(cookies[i].getName().equals("userId")){
    				id = cookies[i].getValue();
    			}
    		}
    	//쿠키는 있는데 로그인이 안된상태
    		if(id.equals("")){ //쿠키들중에서 userId라는 이름의 쿠키가 없는경우
        		response.sendRedirect("cookieMemberLogin.jsp");
    		System.out.print("out");
    		
        	}
    	}
    	
    	else { //쿠키가 없을 경우
    		 response.sendRedirect("cookieMemberLogin.jsp");
    	}
    } catch(Exception e){
    	e.printStackTrace();
    }
    
    %>


<!DOCTYPE html>
<html>
<head>
<title>간단한 쿠키 회원 인증</title>
</head>
<body>

	<form action="cookieLogOut.jsp" method="post">
		
		<table>
			<tr>
				<td>
				<%= id %> 님이 로그인하셨습니다.
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