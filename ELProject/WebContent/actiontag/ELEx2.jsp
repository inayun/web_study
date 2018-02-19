<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "actiontag.Customer, java.util.ArrayList" %>


<%
	ArrayList <String> singer = new ArrayList<String>();
	//배열에 인덱스 값 추가할 경우 add() 이용
	
	singer.add("소녀시대");
	singer.add("원더걸스");
	request.setAttribute("singer", singer); //빈설정
	
	Customer[] customer = new Customer[2];
	
	customer[0] = new Customer();
	customer[0].setName("홍길동");
	customer[0].setEmail("hong@gmail.com");
	customer[0].setPhone("01012345678");
	
	customer[1] = new Customer();
	customer[1].setName("성춘향");
	customer[1].setEmail("seong@gmail.com");
	customer[1].setPhone("01012345678");
	
	request.setAttribute("customer", customer);
	
	

%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<ul>
	<li> ${singer[0]}, ${singer[1]} </li>
</ul>

<ul>
	<li> 이름 : ${customer[0].name }</li>
	<li> 메일 : ${customer[0].email }</li>
	<li> 번호 : ${customer[0].phone }</li>
</ul>


<ul>
	<li> 이름 : ${customer[1].name }</li>
	<li> 메일 : ${customer[1].email }</li>
	<li> 번호 : ${customer[1].phone }</li>
</ul>
</body>
</html>