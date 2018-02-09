<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="boardone.BoardDAO" %>
    <%@ page import="boardone.BoardVO" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.text.SimpleDateFormat" %>
	<%@ include file="view/color.jsp" %>
    
    <%!
    
  		  //한페이지 에 보여줄 페이지를 5개로 지정
      	int pageSize = 5;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    %>


    <%	
  	 	 String pageNum = request.getParameter("pageNum");
    	String searchScope = request.getParameter("searchScope");
    	String searchContent = request.getParameter("searchContent");
    
   		 if(pageNum == null){ //현재 페이지를 1로 설정  초기화 : 1
    		pageNum = "1";
    	}
    	int currentPage = Integer.parseInt(pageNum); //현재 페이지 번호
    	int startRow = (currentPage-1) * pageSize + 1; //출력할 행의 수
    	//한페이지 이상일때 페이지 크기에 따라 행의 페이지로 나눔, 특정 페이지로 이동할 경우 출력할 페이지를 계산하여 이동
    	
    	int endRow = currentPage* pageSize; 
    	int count = 0;
    	int number = 0;
    	List<BoardVO> articleList = null;
    	
    	
    	BoardDAO dbPro = BoardDAO.getInstance(); //디비연결
    	count = dbPro.getArticleCount(); //전체 글수
    	
    	if( count > 0 ) {
    		articleList = dbPro.getArticlesBySearch(startRow,endRow,searchScope,searchContent);
    	}
     	
    	number = count-(currentPage - 1) * pageSize;
    	
    	System.out.println(articleList.size());
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
		
		<%
			int wid = 0;
			if(article.getDepth() > 0 ){
				wid = 15 * (article.getDepth());
				
		%>
		
		<img src="images/level.gif" width=" <%=wid %>" height="16" />
		<img src = "images/re.gif"/>
				
			
		<% } else { %>
		
		<img src = "images/level.gif" width="<%= wid %>" height="16" />
		
		<% } %>
		
			<a href="content.jsp?num=<%= article.getNum() %>&pageNum=<%=currentPage %>">
			<%= article.getSubject() %></a>
			
			<% if(article.getReadcount() >= 20) { %>
			<img src="images/hot.gif" height="16" border="0">
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


<%
	if(count > 0 ) {
		int pageBlock = 5;
		int imsi = count % pageSize == 0 ? 0 : 1;
		
		int pageCount = count/pageSize + imsi;
		int startPage = (int)((currentPage-1)/pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock-1;
		
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		if(startPage > pageBlock){
%>		
	<a href="list.jsp?pageNum= <%=startPage-pageBlock %>">[이전]</a>
	
	<%
		}
		
		for(int i = startPage; i<= endPage; i++) {
	%>
		<a href="list.jsp?pageNum=<%= i %>">[<%=i %>]</a>
	
		
 <% } if (endPage < pageCount) { %>		

<a href="list.jsp?pageNum= <%=startPage+pageBlock %>">[다음]</a>

<% } 
	}
 %>


<form action="searchList.jsp" method="post">
	<div align ="center">
		<select>
			<option value="writer" name="searchScope">작성자</option>
			<option value="subject"  name="searchScope" >제목</option>
			<option value="content"  name="searchScope">내용</option>
		</select>
		
		<input type="text" name="searchContent">
		<input type="submit" value="검색">
	</div>
</form>

	

</body>
</html>


