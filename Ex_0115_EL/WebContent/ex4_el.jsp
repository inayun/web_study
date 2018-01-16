<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%

    	PersonVO vo = new PersonVO();
    	vo.setName("홍길동");
    	vo.setAge(30);
    	
    	PersonVO vo2 = new PersonVO();
    	vo2.setName("김길동");
    	vo2.setAge(22);
    	
    	request.setAttribute("vo", vo);
    	
    	ArrayList<PersonVO> arr = new ArrayList();
    	arr.add(vo);
    	arr.add(vo2);
    	request.setAttribute("arr", arr);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	${requestScope.vo.name}<br>
	${vo.age}
	${arr[0].name} <br>
	${arr[0].age} <br>
	${arr[1].name} <br>
	${arr[1].age} <br>
</body>
</html>