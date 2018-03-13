<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<script type="text/javascript">

var totalCount =  ${totalCount};
var pagepageCount =  ${pagepageCount};
var pageboardCount =  ${pageboardCount};

function goPage(num){
	
	var goPageData={};
	goPageData.totalCount = totalCount;
	goPageData.pagepageCount = pagepageCount;
	goPageData.pageboardCount = pageboardCount;
	goPageData.curPage = num;
	
	jQuery.ajax({
		
		async : true,
		cache : false,
		type : "post",
		url : 'PagingAction',
		data : goPageData,
		dataType : "html",
		
		success : function(result){
			$("#board").html(result);
		},
	
		error : function(xhr,status,error){
			console.log(xhr.status);
			console.log(status);
			console.log(error);
		}
	});
} //function
</script>

<div id="board">
<h3>게시물</h3>
<c:forEach var="board" step="1" begin="${lastNum-pageboardCount+1}" end="${lastNum}" >
	<c:if test="${board < totalCount}">
		${board}<br>
	</c:if>
</c:forEach>
${page}

</div>

</body>
</html>