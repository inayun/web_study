<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">

	for(var i = 2; i <= 9; i++){
		document.write("<h1>" + i + "</h1>");
		for(var j = 1; j <= 9; j++){
			document.write(i + "*" + j + "=" + (i*j) + "<br>");
		}
		document.write("<br>");
	}

</script>
</head>
<body>

</body>
</html>