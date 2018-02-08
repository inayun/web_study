<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.net.URLEncoder" %>    
    
    <%
   
    //쿠키생성
   Cookie cookie = new Cookie("name",URLEncoder.encode("홍길동","utf-8"));
   Cookie cookie1 = new Cookie("name",URLEncoder.encode("홍길동","utf-8"));

    
    //쿠키를 저장소에 저장
   response.addCookie(cookie);
   response.addCookie(cookie1);
    %>
    
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>


<%= cookie.getName() %> 쿠키의 값 = <%= cookie.getValue() %>
<%= cookie1.getName() %> 쿠키의 값 = <%= cookie1.getValue() %>

</body>
</html>