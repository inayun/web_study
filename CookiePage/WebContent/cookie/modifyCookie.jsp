<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ page import ="java.net.URLEncoder" %>    
     
     <%
     //쿠키를 변경하기 위해서 목록을 가져옴
     
     Cookie[] cookies = request.getCookies();
     
    if(cookies !=null && cookies.length > 0 ){
    
    	for(int i = 0; i<cookies.length; i++){
    		
    		//쿠키들 이름이 같은지를 비교하여 같으면 쿠키의 이름을 다시 설정
    		if(cookies[i].getName().equals("name")){
    			//쿠키이름 재설정
    			cookies[i].setValue(URLEncoder.encode("I am changed!","utf-8"));
    			response.addCookie(cookies[i]);
    		}
    	}
     }
     
     
     %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

	cookie값을 변경합니다.
</body>
</html>