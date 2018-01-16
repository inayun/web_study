<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%

	request.setCharacterEncoding("utf-8");
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age < 30){
		request.setAttribute("msg", "가입가능");
	} else if(age >= 30){
		request.setAttribute("msg", "가일불가");
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	${msg} <br>
</body>
</html>