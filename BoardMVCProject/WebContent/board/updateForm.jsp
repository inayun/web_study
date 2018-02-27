<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ include file="view/color.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title> 게시판 </title>
<link href = "stylesheet.css" type="text/css" rel = "stylesheet">
<script type = "text/javascript" src="script.js"></script>
</head>


<body bgcolor="${bodyback_c}">
<center>글 수정</center>

<form action="/BoardMVCProject/board/updatePro.do?pageNum=${pageNum}" method="post" name="writerform" onsubmit = "return writeSave()">

<table width="400" border="1" cellspacing="0" cellpadding="0" bgcolor="${bodyback_c}" align="center">

	<tr>	
		<td width="70" bgcolor="${value_c}" align="center">이름</td>
		<td width="300" align="left">
			<input type="text" size="10" maxlength="10" name="writer" value=" ${article.writer}">
			<input type="hidden" name="num" value="${article.num}" >
		</td>
	</tr>
	
	<tr>	
		<td width="70" bgcolor="${value_c}" align="center">제목</td>
		<td width="300" align="left">
			<input type="text" size="10" maxlength="10" name="subject" value=" ${article.subject}">
		</td>
	</tr>
	
	<tr>	
		<td width="70" bgcolor="${value_c}" align="center">Email</td>
		<td width="330" align="left">
			<input type="text" size="40" maxlength="40" name="email" value=" ${article.email}">
		</td>
	</tr>
	
	<tr>	
		<td width="70" bgcolor="${value_c}" align="center">내용</td>
		<td width="330" align="left">
			<textarea rows="13" cols="40" name="content"> ${article.content} </textarea>
		</td>
	</tr>
	
	<tr>	
		<td width="70" bgcolor="${value_c}" align="center">비밀번호</td>
		<td width="330" align="left">
			<input type="password" size="40" maxlength="40" name="password" value=" ${article.pass}">
		</td>
	</tr>
	
	<tr>
		<td colspan="2" bgcolor="${value_c}" align="center">
			<input type="submit" value="수정완료">
			<input type="reset" value="다시쓰기" >
			<input type="button" value="목록보기" onclick="document.location.href='/BoardMVCProject/board/list.do?pageNum=${pageNum}'">
		</td>
	
	</tr>
	
</table>


</form>

</body>
</html>