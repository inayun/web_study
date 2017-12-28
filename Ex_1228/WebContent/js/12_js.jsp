<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		
		for(var i = 0; i < 10; i++){
			document.write(i + "<br>");
		}
	
		for(var i = 0; i < 6; i++){
			document.write("<h" + i + ">" + "자바" + "</h" + i +">");
		}
		
		
		document.write("<ul>");
		
		for(var i = 0; i < 5; i++){
			document.write("<li> 메뉴" + i + "</li>")
		}
		
		document.write("</ul>");
	</script>

</head>
<body>

</body>
</html>