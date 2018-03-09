<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<c:forEach var="board" step="1" begin="${lastNum-pageboardCount+1}" end="${lastNum}" >
	<c:if test="${board < totalCount}">
		${board}<br>
	</c:if>
</c:forEach>

${page}

</body>
</html>