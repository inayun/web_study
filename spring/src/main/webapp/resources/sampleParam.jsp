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

	function ajaxSubmit(formId){
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

</script>

</head>
<body>


<form id="frm">

<p> 부서코드 : 
<input type="text" name="deptNo">
<input type="button" value="조회" onclick="javascript:ajaxSubmit('frm')" />

</form>


<div id="resultSection">
<P>출력되는 부분

</div>

</body>
</html>