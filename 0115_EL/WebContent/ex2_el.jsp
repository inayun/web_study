<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	EL의 산술 연산자 <br>
	
	\${ 1+1 } = ${1+1}
	
	<hr>
	
	EL의 비교 연산자<br>
	
	\${ 3 > 2 } = ${ 3 gt 2 } <br> <!-- gt = '>' 크다를 의미 -->
	\${ 3 >= 2 } = ${ 3 ge 2 } <br>
	\${ 3 < 2 } = ${ 3 lt 2 } <br>
	\${ 3 < 2 } = ${ 3 le 2 } <br>
	\${ 3 == 2 } = ${ 3 eq 2 } <br>
	<!-- \${ 3 != 2 } = ${ 3 ne 2 } <br>  -->
	
	<hr>
	
	EL 삼항 연산자 <br>
	${empty param.msg ? "비어있음" : "값 있음" } <br>
	
	${param.msg == null or param.msg == '' ? "x" : "o" }

</body>
</html>