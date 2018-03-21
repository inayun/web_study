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

<form:form action="/move.do" commandName="mem" >

	<p> id : <form:input path="id" />
	<p> 이름 : <form:input path="name" />
	<p> 비밀번호 : <form:password showPassword="true" path="password" />
	<p> 이메일 : <form:input path="email" />
	<p> 취미 : <form:checkbox path="hobby"  value="baseball" label="야구"/>
			<form:checkbox path="hobby" value="reading" label="독서" />
			<form:checkbox path="hobby" value="soccer" label="축구" />
	
	<p> 동물 : <form:select path="animal">
				<form:options items="${animalMap}"/>
			</form:select>
			
	<p> 성별 : <form:radiobutton path="gender" value="woman" label="여자" />
			<form:radiobutton path="gender" value="man" label="남자" />
	

</form:form>






id : ${mem.id}
이름 : ${mem.name}
비밀번호 : ${mem.password}
취미 : ${mem.hobby[0] }
${fn:length(mem.hobby)}
동물 : ${mem.animal}
성별 : ${mem.gender}
</body>
</html>