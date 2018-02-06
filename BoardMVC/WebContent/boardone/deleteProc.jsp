<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="boardone.BoardDAO" %>
    <%@ page import="java.sql.Timestamp"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    %>

	<%
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String password = request.getParameter("password");
		
		BoardDAO dbPro = BoardDAO.getInstance();
		int check = dbPro.deleteArticle(num, password);
		
		if(check==1){
	%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Refresh" content="0;url=list.jsp?pageNum= <%= pageNum %> ">
</head>
<body>
	<% } else { %>		
    
	<script type="text/javascript">
    
    	alert("비밀번호가 일치하지 않습니다.");
    	history.go(-1);
    
    </script>

	<% }  %>
</body>
</html>