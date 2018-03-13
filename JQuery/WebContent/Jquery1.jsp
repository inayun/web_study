<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

	<input type="button" id= "btn" value="값 확인하기">
	
	<script type="text/javascript">
	
		var object = {};
		object.chk = "check";
		//{"chk":"check"}
	
		/* 
		var jsonData = {
				
				"one" : "1",
				"two" : "2",
				"three" : "3",
				"four" : "4"
		}	
		
		 */
		
		var jsonData = [
				
				{"one1" : "1-1", "one2":"1-2"},
				{"two" : "2"},
				{"three" : "3"},
				{"four" : "4"}
		]
		
		
		//배열값 하나씩 불러오기
		$("#btn").click(function(){
			
			$.each(jsonData,function(){
				$.each(this,function(key,value){
					console.log("key:" + key + "-" + "value:" + value);
				});
			});
		});
		
		
		
		
		
		/* 
		$("#btn").click(function(){
			
			$.each(jsonData,function(key,value){
				
				if(key == "two") {
					alert("선택하신값:" + value);
				}
			});
		});
		 */
		
	
	</script>
</body>
</html>