<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title> @RequestParam HashMap 테스트 (강사님이 주로 쓰시는 방법)</title>
</head>
<body>

id : ${params.id}
name : ${params.name}
취미 : <c:forEach var="hobby" items="${hobbyList}">
	${hobby}
</c:forEach>

</body>
</html>