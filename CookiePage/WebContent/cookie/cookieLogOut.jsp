<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Cookie[] cookies = request.getCookies();
    
    	//쿠키가 존재하는 경우
    	if(cookies != null){
    	
    		for(int i =0; i <cookies.length; i++){
    			
    			if(cookies[i].getName().equals("userId")){
    				cookies[i].setMaxAge(0);
    				response.addCookie(cookies[i]);
    			}
    			
    		} //for
    	}//if
    %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href="cookieMemberLogin.jsp";
</script>

</body>
</html>