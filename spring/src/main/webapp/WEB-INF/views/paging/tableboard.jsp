<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<script type="text/javascript">

function goPage(num){
	
	document.getElementById("curPage").value=num;
	document.getElementById("boardForm").submit();
}

</script>


<form action="/spring/page.do" method="post" id="boardForm">
	<input type="hidden" name="totalCount" value="${totalCount}" > <br>
	<input type="hidden" name="pagepageCount" value="${pagepageCount}" > <br>
	<input type="hidden" name="pageboardCount" value="${pageboardCount}"> <br>
	<input type="hidden" name="curPage" id="curPage"> <br>
</form>

<h3>게시물</h3>
<c:forEach var="board" step="1" begin="${lastNum-pageboardCount+1}" end="${lastNum}" >
	<c:if test="${board < totalCount}">
		${board}<br>
	</c:if>
</c:forEach>
${page}


</body>
</html>