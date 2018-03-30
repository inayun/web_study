<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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


	function ajaxBoardUpdate(formId){
		
		$('#'+formId).ajaxForm({
			type: "post",
			url: "/boardUpdate.do",
			datatype: "json",
			success : function(result){
				
				alert(result.result)
			},
			
			error : function(result){}
		}).submit();
	}

	
	function ajaxBoardDelete(formId){
		
		$('#'+formId).ajaxForm({
			
			type: "post",
			url: "/boardDelete.do",
			datatype: "json",
			
			success : function(result){
				alert(result.result)
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
		<h3 align="center" >글 상세보기</h3>
		</div>
	
		<div class="panel-body">
			<form id="boardDetailForm">
			
				<div class="form-group">
					<label>제목</label>
					<input type="text" name="boardTitle" class="form-control" value="${board[0].BOARDTITLE}" /><br>
				</div>
			
				<div class="form-group">
					<label>작성자</label>
					<input type="text" disabled="disabled" class="form-control" name="createWriter" value="${board[0].CREATEWRITER}"/><br>
				</div>
			
				<div class="form-group">
					<label>내용<br></label>
					<textarea rows="10" cols="50" class="form-control" name="boardContent">${board[0].BOARDCONTENT}</textarea>
				<br>
				</div>
				
				<div class="form-group">
					<label>등록일자</label>
					<input type="text" disabled="disabled" class="form-control" name="createDate" value="${board[0].CREATEDATE}" /><br>
				</div>
				
				<div class="form-group">
					<label>수정자</label>
					<input type="text" name="updateWriter" class="form-control" value="${board[0].UPDATEWRITER}"/><br>
				</div>
				
				<div class="form-group">
				<input type="hidden" name="boardNum" value="${board[0].BOARDNUM}"/>
				<input type="button" value="수정완료" class="btn btn-sm" onclick="javascript:ajaxBoardUpdate('boardDetailForm')" />
				<input type="button" value="글 삭제" class="btn btn-sm" onclick="javascript:ajaxBoardDelete('boardDetailForm')" />
				</div>
				
			
			</form>
			
		
			<div align="center"><a href="/boardList.do?curPage=${curPage}"/>글 목록보기</a></div>
		</div>

	</div>
</div>

</body>
</html>