<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "actiontag.Customer, java.util.HashMap" %>

<%
Customer cu = new Customer();
//빈을 설정
cu.setName("홍길동");
cu.setEmail("hong@gmail.com");
cu.setPhone("010-1234-5678");

request.setAttribute("cu", cu);
//속성을 저장

HashMap<String,String> map = new HashMap<String, String>();
map.put("name", "소나타");
map.put("maker","현대");
request.setAttribute("car", map);
%>    
    
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<ul>
	<li>이름 : ${cu.name}</li>
	<li>메일 : ${cu.email}</li>
	<li>번호 : ${cu.phone}</li>
</ul>

<ul>
	<li>이름 : <%= cu.getName() %></li>
	<li>메일 : <%= cu.getEmail() %></li>
	<li>번호 : <%= cu.getPhone() %></li>
</ul>



<ul>
	<li>차종 : ${car.name}</li>
	<li>제조사 : ${car.maker}</li>
</ul>
</body>
</html>