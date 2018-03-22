<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>

<!--  jQuery.form.js 검색 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript">

	function ajaxSubmit(formId){
		$('#' + formId).ajaxForm({
			url: "/lecture05/ajaxFileUpload.do",
			datatype: "json",
			success: function(result){
				alert(result.success)
			},
			error: function(result){
				
			}
		}).submit();
	}

</script>


</head>
<body>

	<form id="frm" enctype="multipart/form-data" method="post">
		<p>id : <input type="text" name="id">
		<p>이름 : <input type="text" name="name">
		<p> 파일 1 : <input type="file" name="file_test">
		<P> 파일 2 : <input type="file" name="file_test">
		
		<input type="button" value="보내기" onclick="javascript:ajaxSubmit('frm')" />
			
	</form>


</body>
</html>