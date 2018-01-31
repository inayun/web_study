<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="jdbc.*" %>
        <%@ page import="java.util.*" %>
    

<!DOCTYPE html>
<html>
<head>
<title> JSP 데이터베이스 연동</title>
<link href="stylesheet.css" type="text/css">
</head>
<body bgcolor="#FFFFCC">
	<h2>Bean을 이용한 데이터베이스 연동</h2><br>
	
	<h3>회원정보</h3>
	<table border="1" >
	
		<tr>
			<th>ID</th>
			<th>password</th>
			<th>name</th>
			<th>mem_num1</th>
			<th>mem_num2</th>
			<th>e_mail</th>
			<th>phone</th>
			<th>zipcode</th>
			<th>address</th>
			<th>job</th>
		</tr>
		
<jsp:useBean id="dao" class="jdbc.TempMemberDAO" scope="page" />
	
	<%
	Vector<TempMemberVO> vlist = dao.getMemberList();
	
	int counter = vlist.size();
	
	for(int i=0; i < vlist.size(); i++){
		
		TempMemberVO vo = vlist.elementAt(i);
	
	%>
	
		<tr>
			<td><%= vo.getId() %></td>
			<td><%= vo.getPassword() %></td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getMem_num1() %></td>
			<td><%= vo.getMem_num2() %></td>
			<td><%= vo.getEmail() %></td>
			<td><%= vo.getPhone() %></td>
			<td><%= vo.getZipcode() %></td>
			<td><%= vo.getAddress() %></td>
			<td><%= vo.getJob() %></td>
			
		<%
		}
		%>
		</tr>
	</table> <br>
	
	
	total records : <%= counter %>
	
</body>
</html>