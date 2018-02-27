<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
    <%@ include file="view/color.jsp" %>
    
    <%
    	int num = Integer.parseInt(request.getParameter("num"));
    	String pageNum = request.getParameter("pageNum");
    
    %>
<!DOCTYPE html>
<html>
<head>
<title> 게시판 </title>
<link href = "stylesheet.css" type="text/css" rel = "stylesheet">
<script type = "text/javascript" src="script.js"></script>
</head>
<body bgcolor="${bodyback_c}">
<center>글 삭제

<form action="/BoardMVCProject/board/writePro.do?pageNum=${pageNum}" method="post" name="delForm" onsubmit="return deleteSave()" >
	<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
		<tr height="30">
			<td align="center" bgcolor="${value_c} ">비밀번호를 입력해주세요.</td>
		</tr>
	
		<tr height="30">
			<td align="center">비밀번호 :
				<input type="password" name="password" size="8" maxlength="12">
				<input type="hidden" name="num" value="${num}">
			</td>
		</tr>
		
		<tr height="30">
			<td align="center" bgcolor="${value_c}">
			<input type="submit" value ="글삭제" onclick="document.location.href='' ">
			<input type="button" value ="글목록" onclick="document.location.href='/BoardMVCProject/board/list.do?pageNum=${pageNum}'">
			</td>
		</tr>
	
	</table>

</form>
</center>



</body>
</html>