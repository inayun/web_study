<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ include file="view/color.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link href = "stylesheet.css" type="text/css" rel = "stylesheet">
</head>

<body bgcolor="${bodyback_c}"> 
<center><b>글 내용보기</b> <br><br>

<form action="">
<table width="500" border="1" cellspacing="0" cellpadding="0" bgcolor="${bodyback_c}" align="center">

	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c}"> 글번호  </td>
		<td align="center" width="125">${article.num}</td>
		
		<td align="center" width="125" bgcolor="${value_c}"> 조회수  </td>
		<td align="center" width="125">${article.readCount}</td>
	</tr>

	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c}"> 작성자  </td>
		<td align="center" width="125">${article.writer}</td>
		
		<td align="center" width="125" bgcolor="${value_c}"> 작성일  </td>
		<td align="center" width="125">${article.regdate}</td>
	</tr>

	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c}"> 글제목  </td>
		<td align="center" width="125">${article.subject}</td>
	</tr>

	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c}"> 글내용  </td>
		<td colspan ="3" align="left" width="400">
		<pre>${article.content}</pre></td>
	</tr>

	<tr height="30">
		<td colspan="4" bgcolor="${value_c}" align="right" >
			<input type="button" value="글수정" onclick="document.location.href='/BoardMVCProject/board/updateForm.do?num=${article.num}&pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;
			
			<input type="button" value="글삭제" onclick="document.location.href='/BoardMVCProject/board/deleteForm.do?num=${article.num}&pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;
			
			
			<input type="button" value="답글쓰기" onclick="document.location.href='/BoardMVCProject/board/writeForm.do?num=${article.num}&ref=${article.ref}&step=${article.step}&depth=${article.depth}'">&nbsp;&nbsp;&nbsp;&nbsp;
			
			<input type="button" value="글목록" onclick="document.location.href='/BoardMVCProject/board/list.do?pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
</table>


</form>
</center>
</body>
</html>