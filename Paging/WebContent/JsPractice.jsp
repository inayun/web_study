<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		//버튼이 클릭이 되면
		$("#btn").click(function(){
			
			//txt의 밸류값 가져오기
			var txt = $("#txt").val();
			//button 태그노드 생성하기
			
			var newBtn = document.createElement("button");
			newBtn.value=txt;
			
			//txt값인 텍스트노드를 생성하여 newBtn에 붙이기
			newBtn.appendChild(document.createTextNode(txt));
			
			var board = document.getElementById("board");
			board.appendChild(newBtn);
			
		}); //input값이 있는 btn클릭시 함수
	
		$("#board button").click(function(){
			$(this).hide();
			
		});
		
	}); 
	


	

</script>
</head>
<body>


<form>
	<input type="text" id="txt"/>
	<input type="button" id="btn" value="추가"/>
</form>

<hr>


<div id="board">

</div>



</body>
</html>