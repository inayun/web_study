<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

request.setCharacterEncoding("utf-8");
int dan = Integer.parseInt(request.getParameter("dan"));

StringBuffer sb = new StringBuffer();

for(int i = 1; i <= 9; i++){
	sb.append(String.format("%d * %d = %d<br>",dan,i,dan*i));
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=sb.toString() %>
</body>
</html>