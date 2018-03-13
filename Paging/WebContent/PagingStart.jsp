<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#listDiv").css("display","none");
	
	$("#submitBtn").click(function(){
		
		var inputData={};
		inputData.totalCount = $("#totalCount").val();
		inputData.pagepageCount = $("#pagepageCount").val();
		inputData.pageboardCount = $("#pageboardCount").val();
		inputData.curPage = $("#curPage").val();
		
		jQuery.ajax({
			
			async : true,
			cache : false,
			type : "post",
			url : 'PagingAction',
			data : inputData,
			dataType : "html",
			
			success : function(result){
				$("#formDiv").css("display","none");			
				$("#listDiv").html(result);
				$("#listDiv").css("display","block");
				
			}, //success
			error : function(xhr,status,error){
				console.log(xhr.status);
				console.log(status);
				console.log(error);
			} //error
		}) //ajax
	}); //submitBtn

}); //document.ready



</script>

<div id="formDiv">
<form>

총 게시물 수 : <input type="text" id="totalCount" > <br>
페이지당 페이지수 : <input type="text" id="pagepageCount" > <br>
패이지당 게시물수 : <input type="text" id="pageboardCount" > <br>
현재 페이지 : <input type="text" id="curPage" > <br>
<input type="button" value="보내기" id="submitBtn">
</form>
</div>


<div id="listDiv">
</div>


</body>
</html>