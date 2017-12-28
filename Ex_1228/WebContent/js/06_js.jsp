<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">

	var gender = prompt("당신의 성별은?");
	var age = prompt("당신의 나이는?");
	
	var my_age = Number(age) + 10;
	document.write("성별:" + gender +"<br>");
	document.write("나이:" + age + "<br>");
	document.write(my_age); 
	//prompt에서는 3010 두 수가 붙어서 나옴. 문자로 인식해서
	//prompt에서 넘어온 문자열을 정수로 변경  : 
	// 따라서 앞에 Number() 으로 캐스팅 시켜줘야함
	
	
	
	/* 문자열 >= 정수같은경우에는 문자를 숫자로 인식함
	  age >= 30
	  age + 30 같은경우에만 캐스팅 할 것
	*/
	
	
</script>

</head>
<body>

</body>
</html>