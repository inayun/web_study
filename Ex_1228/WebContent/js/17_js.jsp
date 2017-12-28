<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


	<style>
		#disp{ 
			width : 300px;
			height : 300px;
			background: black;
			color : white;
			text-align: center;
			padding-top: 15px;
		}
		
		
	</style>

	<script type="text/javascript">
		function myGugu(){
			var dan = document.getElementById("dan").value;
			
			if(dan.trim()==''){
				alert("값이 없습니다.");
				return;
			}
			
			if(dan < 2 || dan > 9){
				alert("2~ 9 사이의 값만 입력하세요.");
				return;
			}
			
			var str = "";
			
			for(var i = 1; i<=9; i++){
				str += dan + "*" + i + "=" + dan*i + "<br>";
			}
			
			document.getElementById("disp").innerHTML = str;
		}
	</script>
</head>
<body>

	<p>
		단 : 
		<input id="dan"/>
		<input type="button" value="시작" onclick="myGugu()"/>
	</p>
	
	<div id="disp"> </div>
</body>
</html>