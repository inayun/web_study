<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       
    <%
    String code = request.getParameter("name");
    String viewPageURI = null;
    
    if(code.equals("A")){
    	viewPageURI = "viewModel/A.jsp";
    } else if(code.equals("B")){
    	viewPageURI = "viewModel/B.jsp";
    } else if(code.equals("C")){
    	viewPageURI = "viewModel/C.jsp";
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<jsp:forward page="<%= viewPageURI %>"></jsp:forward>
</body>
</html>