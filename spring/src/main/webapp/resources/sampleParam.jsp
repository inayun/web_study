<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<script type="text/javascript">

	function ajaxSearch(formId){
		$('#'+formId).ajaxForm({
			
			type: "post",
			url : "/sampleList.do",
			datatype: "json",
			success: function(result){
				$("#resultSection").empty();
				
				$.each(result.list,function(){
					$("#resultSection").append = "<p>"
					$.each(this,function(key,value){
						$("#resultSection").append(value+" ")
					})
				});
			},
			error: function(result){
			}
			
		}).submit();
		
	}

	
	function ajaxInsert(formId){
		$('#'+formId).ajaxForm({
			
			type: "post",
			url : "/sampleInsert.do",
			datatype: "json",
			success: function(result){
				$("#resultSection").empty();
				$("#resultSection").append(result.result);
			
			},
			error: function(result){
			}
			
		}).submit();
		
	}
	
	function ajaxUpdate(formId){
		$('#'+formId).ajaxForm({
			
			type: "post",
			url : "/sampleUpdate.do",
			datatype: "json",
			success: function(result){
				$("#resultSection").empty();
				$("#resultSection").append(result.result);
			},
			error: function(result){
			}
			
		}).submit();
		
	}
	
	
	function ajaxDelete(formId){
		$('#'+formId).ajaxForm({
			
			type: "post",
			url : "/sampleDelete.do",
			datatype: "json",
			success: function(result){
				$("#resultSection").empty();
				$("#resultSection").append(result.result);
			},
			error: function(result){
			}
			
		}).submit();
		
	}
</script>

</head>
<body>


<form id="frm">

<p> 부서코드 : <input type="text" name="deptNo">
<p> 부서이름 : <input type="text" name="dName">
<p> 위치 : <input type="text" name="loc">
<br>

<input type="button" value="조회" onclick="javascript:ajaxSearch('frm')" />
<input type="button" value="삽입" onclick="javascript:ajaxInsert('frm')" />
<input type="button" value="수정" onclick="javascript:ajaxUpdate('frm')" />
<input type="button" value="삭제" onclick="javascript:ajaxDelete('frm')" />

</form>
<br>

<div id="resultSection">
<P>출력되는 부분

</div>

</body>
</html>