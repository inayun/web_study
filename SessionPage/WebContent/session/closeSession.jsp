<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // invalidate() : 세션을 무효화 시키는 메소드
    
    	session.invalidate();
    
    %>
<!DOCTYPE html>
<html>
<head>
<title>세션 종료</title>
</head>
<body>

세션이 종료 되었습니다.

</body>
</html>