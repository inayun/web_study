<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var math = prompt("수학 : ");
	var eng = prompt("영어 : ");
	
	/*
	if(math >= 80 && eng >= 80){
		alert("합격");
		document.write("합격");
	} else {
		document.write("불합격");
	}
	*/
	document.write("<hr>");
	
	var result = math >= 80 && eng >= 80 ? "합격" : "불합격";
	document.write(result);


</script>
</head>
<body>

</body>
</html>