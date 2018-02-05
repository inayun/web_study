<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 색상 페이지 추가 -->
<%@ include file="view/color.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title></title>
<link href = "stylesheet.css" type="text/css" rel = "stylesheet">
<script type = "text/javascript" src="script.js"></script>
</head>

<!-- 새글과 답변글 구분 -->

<%
	int num = 0, ref = 1, step = 0, depth = 0;
	try{
		
		if(request.getParameter("num") != null){
			
			num = Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			step = Integer.parseInt(request.getParameter("step"));
			depth = Integer.parseInt(request.getParameter("depth"));
			
		}
	
	

%>









<body bgcolor="<%= bodyback_c %>">
<center><b>글쓰기</b></center><br><br>
<form action="writeProc.jsp" name="writeForm" method="post" onsubmit="return writeSave()">

	<input type="hidden" name="num" value="<%= num %>">
	<input type="hidden" name="ref" value="<%= ref %>">
	<input type="hidden" name="step" value="<%= step %>">
	<input type="hidden" name="depth" value="<%= depth %>">

	<table width="400" border ="1" cellpadding = "0" cellspacing="0" align="center" bgcolor="<%= bodyback_c %>">
		<tr>
		
			<td align = "right" colspan="2" bgcolor="<%= value_c %>">
				<a href="list.jsp"> 글 목록 </a>
			</td>
		</tr>
		
		<tr>
			<td width="70" bgcolor="<%= value_c %>" align="center">이름</td>
			<td width = "330">
				<input type="text" size="12" maxlength="12" name="writer"> 
			</td>
		</tr>
	
		<tr>
			<td width="70" bgcolor="<%= value_c %>" align="center">이메일</td>
			<td width = "330">
				<input type="text" size="30" maxlength="30" name="email"> 
			</td>
		</tr>	
	
		<tr>
			<td width="70" bgcolor="<%= value_c %>" align="center">제목</td>
			<td width = "330">
			<% 
				if(request.getParameter("num") == null){
			%>
				<input type="text" size="50" maxlength="50" name="subject"> 
			<% }else{ %>
				<input type="text" size="50" maxlength="50" name="subject"
				value = "[답변]">
				<% } %>
			</td>
		</tr>
		
		<tr>
			<td width="70" bgcolor="<%= value_c %>" align="center">내용</td>
			<td width = "330">
				<textarea rows="13" cols="50" name="content"></textarea> 
			</td>
		</tr>
		
		<tr>
			<td width="70" bgcolor="<%= value_c %>" align="center">비밀번호</td>
			<td width = "330">
				<input type="password" size="10" maxlength="10" name="password"> 
			</td>
		</tr>
	
		<tr>
			<td colspan="2" bgcolor="<%= value_c %>"  align="center">
				<input type="submit" value="글쓰기">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" onclick="window.location='list.jsp'">
			</td>
		</tr>
	</table>

</form>
<!-- 새글과 답변 글에대한 예외처리 -->

<% 

	}catch(Exception e){}
%>

</body>


</html>