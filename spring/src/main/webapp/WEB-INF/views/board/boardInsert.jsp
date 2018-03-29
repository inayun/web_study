<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">

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


<div class="container">

	<h3>게시판 글 작성</h3>
	
		<form id="boardInsertForm">
		
			<div class="form-group">
				<label> 제목:</label>
				<input type="text" name="boardTitle" class="form-control"/><br>
			</div>
		
		
			<div class="form-group">
				<label>작성자 : </label>
				<input type="text" name="createWriter" class="form-control" /><br>
			</div>
		
			<div class="form-group">
				 <label>내용:</label>
				 <br>
				<textarea rows="10" cols="50" name="boardContent" class="form-control"></textarea>
			</div>
			<br>
		
			<div class="form-group">
				<input type="reset" value="다시작성" />
				<input type="button" value="작성완료" onclick="javascript:ajaxBoardInsert('boardInsertForm')" />
			</div>
		
		</form>
	
	
	<a href="/boardList.do?curPage=1" >글 목록보기</a>


</div>

</body>
</html>