<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title> @RequestParam MultiValueMap 테스트 (강사님이 주로 쓰시는 방법)</title>
</head>
<body>
<!-- MultiValueMap 은 list형태로 출력되기 때문에 forEach를 써야함 
 forEach 안쓰고 뽑으면 [ㄹㅇㄹ] 식으로 출력됨
 forEach 대신 params.id[0] 이런식으로 쓰면됨
-->
id : ${params.id} <br>
id : ${params.id[0]} <br>

<c:forEach var="id" items="${params.id}">
id : ${id}
</c:forEach>


취미 : <c:forEach var="hobby" items="${params.hobby}">
	${hobby}
</c:forEach>

</body>
</html>