<%@page import="javax.sql.DataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<title>DBCP를 활용한 디비연동</title>
</head>
<body>

<%

try{
	
	InitialContext ctx = new InitialContext();
	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb"); //자바를 연동할때 초기화 시키는 메소드
	
	Connection con = ds.getConnection();
	
	out.println("오라클 데이터베이스 연결 성공");
	out.close();
} catch (Exception e){
	out.println("오라클 데이터베이스 연결 실패");
	out.println(e.getMessage());
}

%>
</body>
</html>