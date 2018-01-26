<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>


<table width="100" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td>제품번호</td>
		<td>12345</td>
	</tr>

	<tr>
		<td>가격</td>
		<td>10,000</td>
	</tr>

<jsp:include page="infoSub.jsp" flush="false">
	<jsp:param value="A" name="type"/>
</jsp:include>
</table>

</body>
</html>