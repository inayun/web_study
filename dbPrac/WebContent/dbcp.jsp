<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*" %>
//<%@ page import = "javax.sql.*" %>
<%@ page import = "javax.naming.*" %>
            
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<%
try{
	InitialContext ctx = new InitialContext();
	//DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
	
	Connection con = ds.getConnection();
	out.println("디비 연동 성공");
	con.close();
} catch(Exception e){
 	out.println("디비 연결 실패");
}

%>


</body>
</html>