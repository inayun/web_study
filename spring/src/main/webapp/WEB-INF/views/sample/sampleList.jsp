<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<%-- 
<c:forEach var="data" items="${list}">
<p> ${data.DEPTNO} &nbsp&nbsp ${data.DNAME} &nbsp&nbsp ${data.LOC}
</c:forEach>




<p> 조회 카운트 : ${cnt}

 --%>
<hr>

${sampleEntity.deptNo}
${sampleEntity.dName}
${sampleEntity.loc}



</body>
</html>