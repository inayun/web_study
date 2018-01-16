<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="js/httpRequest.js"></script>

<script type="text/javascript">
	
	function send(){
		
		var age = document.getElementById("age").value;
		var url = "age_ajax.jsp";
		var param = "age="+age;
		sendRequest(url, param, resultFn, "GET");
	}
	
	function resultFn(){
		
		if(xhr.readyState == 4 && 
				xhr.status == 200){
			var data = xhr.responseText; //ajax body안에 있던 텍스트
			document.getElementById("disp").innerHTML = data;
		}
		
	}

</script>
</head>
<body>

	나이 : <input id="age">
	<input type="button" value="확인" onclick="send()">
	<div id="disp"></div>
</body>
</html>