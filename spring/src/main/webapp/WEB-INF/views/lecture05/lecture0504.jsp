<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>


id : ${mem.id}

<p> 동물 : 

<!-- 동물 다 출력하기 -->
<c:forEach var="animals" items="${animal}">
${animals}
</c:forEach>




</body>
</html>