<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
   
  
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>


게시글
<br>


<c:forEach var="board" step="1" begin="${lastNum-pageboardCount+1}" end="${lastNum}" >
	${board}<br>
</c:forEach>


${page}

<form id="pageForm" action="PagingAction" method="post">
<input type="hidden" name="totalCount" value="${totalCount}" > <br>
<input type="hidden" name="pagepageCount" value="${pagepageCount}"> <br>
<input type="hidden" name="pageboardCount" value="${pageboardCount}"> <br>
<input id="clickNum" type="hidden" name="curPage" value=""> <br>
</form>

<script type="text/javascript">

function goPage(num){
	
	document.getElementById("clickNum").value = num;
	document.getElementById("pageForm").submit();
}


</script>
</body>
</html>