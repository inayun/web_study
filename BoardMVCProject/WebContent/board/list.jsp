<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 
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
			<a href="/BoardMVCProject/board/writeForm.do">글쓰기</a>	
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
		
		
			<a href="/BoardMVCProject/board/content.do?num=${article.num}&pageNum=${currentPage}">
			${article.subject}</a>
			
			<c:if test="${article.readcount >= 20}">
				<img src="images/hot.gif" height="16" border="0">
			</c:if>
			
		</td>
		
		<td align="center" width="100">
			<a href="mailto: ${article.email}">${article.writer}</a>
		</td>
		
		<td align="center" width="150">
			${article.regdate}
			
		</td>
	
		<td align="center" width="150">
			${article.readcount}
		</td>
	
		<td align="center" width="150">
			${article.ip}
		</td>
	</tr>

		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>


  <c:if test="${count > 0}"> 
     
     <c:set var="imsi" value="${count % pageSize == 0 ?  0 : 1 }" />
     <c:set var="pageCount" value="${count  / pageSize + imsi }" />
     <c:set var="pageBlock" value="${3}"/>
     
     <fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock }"
     integerOnly="true" />
     
     <c:set var="startPage" value="${result * pageBlock +1 }" />
     <c:set var="endPage" value="${startPage + pageBlock -1 }" />
                      
                    <c:if test="${endPage > pageCount }">
                         <c:set var="endPage" value="${pageCount }" />
                    </c:if>  
     
     <c:if test="${startPage > pageBlock }">
     
       <a href="/BoardMVCProject/board/list.do?pageNum=${startPage-pageBlock}">[이전]</a>
     
     </c:if>
     
     <c:forEach var="i" begin="${startPage }" end="${endPage }">
     
     <a href="/BoardMVCProject/board/list.do?pageNum=${i}">[${i }]</a>
     </c:forEach>
            
            <c:if test="${endPage < pageCount }">
        <a href="/BoardMVCProject/board/list.do?pageNum=${startPage + pageBlock}">[다음]</a>
     </c:if>
  </c:if>
	



</body>
</html>