<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		var num = 1;
		var path = "../img/img";
		
		function next(){
			
			num++;
			
			if(num>7){
				num = 1;
			}
			document.getElementById('gal').src = path + num + ".jpg";
			
		}
		
		function prev(){
			num--;
			
			if(num<1){
				num = 7;
			} 
			document.getElementById('gal').src = path + num + ".jpg";
		}
		
		//1초 간격으로 next() 함수 실행
		//setInterval("next()",1000); 
		
		
	</script>
</head>
<body>


	<div>
	
		<p>
			<a href="#" onclick="prev()">
				<img alt="이전" src="../img/left_btn.png">		
			</a>
			
			<img id="gal" alt="갤러리" src="../img/img1.jpg" width="300px" height="200px">			
			<a href="#" onclick="next()">
				<img alt="이전" src="../img/right_btn.png">		
			</a>
			
		</p>
	</div>
</body>
</html>