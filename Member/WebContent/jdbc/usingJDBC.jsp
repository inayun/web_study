<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    
<%

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1522:orcl";
	String user = "scott";
	String pwd = "tiger";
	
	
	String id = "",
			password = "",
			name = "",
			mem_num1 = "",
			mem_num2 = "",
			e_mail = "",
			phone = "",
			zipcode = "",
			address = "",
			job = "";
	
	int counter = 0;
	
		try {
			
			con = DriverManager.getConnection(url,user,pwd);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from tempmember");
		
%>    
    
<!DOCTYPE html>
<html>
<head>
<title> JSP 데이터베이스 연동</title>
<link href="stylesheet.css" type="text/css">
</head>
<body bgcolor="#FFFFCC">
	<h2>JSP 스크립트릿을 이용한 데이터베이스 연동</h2><br>
	
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
	
	<%
		if(rs!=null){
			while(rs.next()){
						id = rs.getString("id");
						password = rs.getString("password");
						name = rs.getString("name");
						mem_num1 = rs.getString("mem_num1");
						mem_num2 = rs.getString("mem_num2");
						e_mail = rs.getString("e_mail");
						phone = rs.getString("phone");
						zipcode = rs.getString("zipcode");
						address = rs.getString("address");
						job = rs.getString("job");
			
				%>
			
		<tr>
			<td><%= id %></td>
			<td><%= password %></td>
			<td><%= name %></td>
			<td><%= mem_num1 %></td>
			<td><%= mem_num2 %></td>
			<td><%= e_mail %></td>
			<td><%= phone %></td>
			<td><%= zipcode %></td>
			<td><%= address %></td>
			<td><%= job %></td>
			
			
			<% 
			
			counter++;
			
			} //while
		} //end if
			
			%>
		</tr>
	</table> <br>
	
	total records : <%= counter %>
	
	<%
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("sql excepion");
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("exception");
		} finally{
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException s){
				s.printStackTrace();
			}
			
			try {
				if(stmt!=null)
					stmt.close();
			} catch (SQLException s){
				s.printStackTrace();
			}

			try {
				if(con!=null)
					con.close();
			} catch (SQLException s){
				s.printStackTrace();
			}
			
		}
		
	%>


</body>
</html>