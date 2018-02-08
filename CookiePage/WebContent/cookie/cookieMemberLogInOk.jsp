<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="logon.LogonDBBean" %>
    
    <% request.setCharacterEncoding("utf-8"); 
    
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    
    
    LogonDBBean manager = LogonDBBean.getInstance();
    int check = manager.userCheck(id, password);
    
    if(check == 1) {
    	//로그인 성공시
    	
    	//쿠키생성
    	Cookie cookie = new Cookie("userId",id);
    	//쿠키 유지 시간 30분 설정
    	cookie.setMaxAge(30 * 60); 
    	response.addCookie(cookie);
    	response.sendRedirect("cookieLogInConfirm.jsp");
    }else if(check == 0){
    	//비밀번호 불일치시
    	
    	%>
    	
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<script type="text/javascript">

alert("비밀번호가 맞지 않습니다.");
history.go(-1);

</script>

<%  }else {
    	//해당 아이디가 존재하지 않을때
	%>
    	
    	
    	
  <% } %>   
 
    


</body>
</html>