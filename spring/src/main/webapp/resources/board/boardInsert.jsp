<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<script type="text/javascript">

	function ajaxBoardInsert(formId){
		
		$('#'+formId).ajaxForm({
			
			type: "post",
			url: "/boardInsert.do",
			datatype:"json",
			success : function(result){
				alert(result.result);
			},
			error : function(result){}
		}).submit();
	}
	
	
	
</script>


</head>


<body>

<form id="boardInsertForm">
제목:
<input type="text" name="boardTitle" /><br>

작성자 : 
<input type="text" name="createWriter" /><br>

내용:<br>
<textarea rows="10" cols="50" name="boardContent"></textarea>

<br>

<input type="reset" value="다시작성" />
<input type="button" value="작성완료" onclick="javascript:ajaxBoardInsert('boardInsertForm')" />

</form>


<a href="/boardList.do" >글 목록보기</a>




</body>
</html>