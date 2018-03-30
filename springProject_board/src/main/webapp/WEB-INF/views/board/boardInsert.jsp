<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
		<div class="panel panel-default">
		
			<div class="panel-heading">
				<h3 align="center">글 작성</h3>
			</div>
			
			<div class="panel-body">
			
				<form id="boardInsertForm">
					<div class="form-group">
						<label>제목</label>
						<input type="text" name="boardTitle" class="form-control"/><br>
					</div>
				
					<div class="form-group">
						<label>작성자</label>
						<input type="text" name="createWriter" class="form-control" /><br>
					</div>
				
					<div class="form-group">
						 <label>내용</label>
						 <br>
						<textarea rows="10" cols="50" name="boardContent" class="form-control"></textarea>
					</div>
					
					<br>
				
					<div class="form-group">
						<input type="reset" class="btn btn-sm" value="다시작성" />
						<input type="button" class="btn btn-sm" value="작성완료" onclick="javascript:ajaxBoardInsert('boardInsertForm')" />
					</div>
				</form>
				<div align="center"><a href="/boardList.do?curPage=1">글 목록보기</a></div>
				
			</div>
			
			
		</div>
	
	</div>

</body>
</html>