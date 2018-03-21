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
			type: "post",
			url: "/lecture05/ajax.do",
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

<!-- 	<form action="/lecture05/06.do"> -->

	<form id="frm">
		<p>
			id : <input type="text" name="id">
		<p>
			이름 : <input type="text" name="name">
		<p>
			비밀번호 : <input type="password" name="password">
		<p>
			이메일 : <input type="text" name="email">
		<p>
			취미 : <input type="checkbox" name="hobby" value="baseball">야구
			<input type="checkbox" name="hobby" value="reading">독서 
			<input type="checkbox" name="hobby" value="soccer">축구
		<p>
			동물 : <select name="animal">
				<option value="dog">개</option>
				<option value="cat">고양이</option>
				<option value="cow">소</option>
				<option value="pig">돼지</option>
			</select>
		<p> 성별 : <input type="radio" name="gender" value="woman">여자
				<input type="radio" name="gender" value="man">남자
		
			<!-- <input type="submit" value="보내기"> -->
			<input type="button" value="보내기" onclick="javascript:ajaxSubmit('frm')" />
			
	</form>


</body>
</html>