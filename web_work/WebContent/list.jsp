<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
   
  
<!DOCTYPE html>
<html>
<head>
<title></title>
<script type="text/javascript" src="httpRequest.js">
	//Ajax 연동을 위해 미리 준비한 httpRequest.js를 참조
</script>

<script type="text/javascript">

function goPage(num){
	

	var url = "PagingAction";
	var param = "url=tableboard.jsp"+"&totalCount="+${totalCount}+"&pagepageCount="+${pagepageCount}+"&pageboardCount="+${pageboardCount}+"&curPage="+num;
	sendRequest(url,param,resultFn,"POST");
}

function resultFn(){
	
	if(xhr.readyState == 4 && xhr.status == 200){
		var data = xhr.responseText;
		document.getElementById("board").innerHTML = data;
	}
}

</script>
</head>

<body>

게시글
<br>

<div id="board">


<c:forEach var="board" step="1" begin="${lastNum-pageboardCount+1}" end="${lastNum}" >
	<c:if test="${board < totalCount}">
		${board}<br>
	</c:if>
</c:forEach>

${page}
</div>



</body>
</html>