<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script>
	
		function myClick(){
			document.getElementById('halo').innerHTML="버튼클릭감지됨!";
		}
		
		function paramTest(param){
			document.getElementById('input_txt').value = param;
		}
	
	</script>


</head>
<body>


	<input type="button" value="버튼1" onclick="myClick()" />
	<button onclick="paramTest('홍길동')">버튼2</button> 
	<button onclick="paramTest(100)">버튼3</button>
	
	<input id="input_txt"type="text" size="30" value="기본값"/>
	<p id="halo"></p>
	
</body>
</html>