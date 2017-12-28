<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var korean = prompt("국어성적 : ");
	var english = prompt("영어성적 : ");
	var math = prompt("수학성적 : ");
	
	var ave = (Number(korean) + Number(english) + Number(math)) / 3;
	document.write(ave.toFixed(2));
	
	
</script>

</head>
<body>



</body>
</html>