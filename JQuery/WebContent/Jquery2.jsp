<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

	
	
	<script type="text/javascript">
	
	function sync(){
		alert(1)
		alert(2)
		alert(3)
	}
	
	function aSync(){
		
		alert(1);
		
		setTimeout(function(){
			alert(2);
		}, 2000);
		alert(3);
	}
	
	</script>


<input type="button" id="btn" value="동기" onclick="javascript:sync()">
<input type="button" id="btn" value="비동기" onclick="javascript:aSync()">
</body>
</html>