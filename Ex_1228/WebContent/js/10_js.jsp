<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	var score = prompt("점수:");
	var result;
	
	if(score >= 90){
		result = 'A';
	} else if(score >= 80 && score < 90){
		result = 'B';
	} else if(score >= 70 && score < 80){
		result = 'C';
	} else if(score >= 60 && score < 70){
		result = 'D';
	} else if(score <= 59){
		result = 'E';
	}

	document.write("점수 : " + score + "<br>" + "성적 : " + result);
	
</script>
</head>
<body>

</body>
</html>