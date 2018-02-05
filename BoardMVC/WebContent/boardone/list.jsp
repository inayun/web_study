<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="boardone.BoardDAO" %>
    <%@ page import="boardone.BoardVO" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.text.SimpleDateFormat" %>
	<%@ include file="view/color.jsp" %>
    
    <%! 
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    %>
    
    <%
    
    	int count = 0;
    	int number = 0;
    	List<BoardVO> articleList = null;
    	BoardDAO dbPro = BoardDAO.getInstance(); //디비연결
    	count = dbPro.getArticleCount(); //전체 글수
    	
    	if( count > 0 ) {
    		articleList = dbPro.getArticles();
    	}
     	
    	number = count;
    %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link href = "stylesheet.css" type="text/css" rel = "stylesheet">
</head>
<body bgcolor="<%= bodyback_c %> ">
<center>글 목록 (전체 글 : <%=count %>)</center>

<table>
	<tr>
		<td align="right" bgcolor = "<%= value_c %>">
			<a href="writeForm.jsp">글쓰기</a>	
		</td>
	</tr>
</table>

<%
	if(count == 0) {
%>

<table width="700" border="1" cellspacing="0" cellpadding="0">

	<tr>
		<td>
			게시판에 저장된 글이 없습니다.
		</td>
	</tr>
</table>

<% } else { %>

<table width="700" border="1" cellspacing="0" cellpadding="0">
	<tr height="30" bgcolor=" <%= value_c %>">
		<td align="center" width="50">번호</td>
		<td align="center" width="250">제목</td>
		<td align="center" width="100">작성자</td>
		<td align="center" width="150">작성일</td>
		<td align="center" width="50">조회</td>
		<td align="center" width="100">IP</td>
	</tr>
	
	<%
		for(int i = 0; i<articleList.size(); i++){
			BoardVO article = articleList.get(i);
	%>
	
	<tr height="30">
		<td align="center" width="50"> <%= number -- %></td>
		<td width="250">
			<a href="content.jsp?num=<%= article.getNum() %>&pageNum=1">
			<%= article.getSubject() %></a>
			
			<% if(article.getReadcount() >= 20) { %>
			<img src="" height="16" border="0">
			<%} %>
		</td>
		
		<td align="center" width="100">
			<a href="mailto: <%= article.getEmail() %> "><%= article.getWriter() %></a>
		</td>
		
		<td align="center" width="150">
			<%= sdf.format(article.getRegdate()) %>
		</td>
	
		<td align="center" width="150">
			<%= article.getReadcount() %>
		</td>
	
		<td align="center" width="150">
			<%= article.getIp() %>
		</td>
	</tr>

<% } %>
</table>

<% } %>
</body>
</html>