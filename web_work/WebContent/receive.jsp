<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>


	<%
	/* 
		out.println(request.getParameter("username"));
		out.println(request.getParameter("gender"));
		String[] hobbies = request.getParameterValues("hobby");
		
		for(String hobby : hobbies){
			out.println(hobby);
		}
		out.println(request.getParameter("house"));
		 */
		
		request.getParameterNames();
		Enumeration<String> paramNames = request.getParameterNames();
		
		while(paramNames.hasMoreElements()){
			out.println(paramNames.nextElement());
		}
	%>
	

</body>
</html>