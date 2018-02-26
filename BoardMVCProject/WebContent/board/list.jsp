<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	request.setAttribute("sdf", sdf);
	
%>
     	
 
 
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
</head>
<body>

<center>글 목록 (전체 글 : ${count})</center>

<table>
	<tr>
		<td align="right" bgcolor = "gray">
			<a href="writeForm.jsp">글쓰기</a>	
		</td>
	</tr>
</table>


<c:choose>

	<c:when test="${count==0}">
	
		<table width="700" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					게시판에 저장된 글이 없습니다.
				</td>
			</tr>
		</table>
	
	</c:when>
	
	<c:otherwise>
	
	<table width="700" border="1" cellspacing="0" cellpadding="0">
		<tr height="30" bgcolor="white">
			<td align="center" width="50">번호</td>
			<td align="center" width="250">제목</td>
			<td align="center" width="100">작성자</td>
			<td align="center" width="150">작성일</td>
			<td align="center" width="50">조회</td>
			<td align="center" width="100">IP</td>
		</tr>
		
		
		<c:forEach var="article" items="${articleList}">
		
		<tr height="30">
		<td align="center" width="50">${(number = number-1)+1}</td>
		<td width="250">
		
			<c:set var="wid" value="0" />
			
			<c:if test="${article.depth > 0}">
			
			<c:set var="wid2" value="${wid = 15 * article.depth}" />
			
				<img src="images/level.gif" width="${wid2}" height="16" />
				<img src = "images/re.gif"/>
			</c:if>
			
			
			<c:if test="${article.depth <= 0}">
				<img src = "images/level.gif" width="${wid}" height="16" />
			</c:if>		
		
		
			<a href="content.jsp?num=${article.num}&pageNum=${currentPage}">
			${article.subject}</a>
			
			<c:if test="${article.readcount >= 20}">
				<img src="images/hot.gif" height="16" border="0">
			</c:if>
			
		</td>
		
		<td align="center" width="100">
			<a href="mailto: ${article.email}">${article.writer}</a>
		</td>
		
		<td align="center" width="150">
		
		${sdf.format(article.regdate)}
			
		</td>
	
		<td align="center" width="150">
			${article.readcount}
		</td>
	
		<td align="center" width="150">
			${article.ip}
		</td>
	</tr>


		</c:forEach>
	</c:otherwise>
</c:choose>


</table>


	



</body>
</html>