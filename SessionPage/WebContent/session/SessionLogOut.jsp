<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	session.invalidate();
	response.sendRedirect("SessionMemberLogin.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>


<script type="text/javascript">

	alert("로그아웃이 되었습니다.");
</script>

</body>
</html>