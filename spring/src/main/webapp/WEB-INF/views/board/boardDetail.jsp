<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<title></title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

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



<form id="boardDetailForm">
제목:
<input type="text" name="boardTitle" value="${board[0].BOARDTITLE}" /><br>

작성자 : 
<input type="text" disabled="disabled" name="createWriter" value="${board[0].CREATEWRITER}"/><br>

내용:<br>
<textarea rows="10" cols="50" name="boardContent">${board[0].BOARDCONTENT}</textarea>
<br>

등록일자 : 
<input type="text" disabled="disabled" name="createDate" value="${board[0].CREATEDATE}" /><br>

수정자 : 
<input type="text" name="updateWriter" value="${board[0].UPDATEWRITER}"/><br>

<input type="hidden" name="boardNum" value="${board[0].BOARDNUM}"/>
<input type="button" value="수정완료" onclick="javascript:ajaxBoardUpdate('boardDetailForm')" />
<input type="button" value="글 삭제" onclick="javascript:ajaxBoardDelete('boardDetailForm')" />
</form>


<a href="/boardList.do?curPage=${curPage}"/>글 목록보기</a>




</body>
</html>