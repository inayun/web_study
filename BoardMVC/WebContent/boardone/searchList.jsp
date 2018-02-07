<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="boardone.BoardDAO"%>
    <%@ page import="boardone.BoardVO"%>
    <%@ page import="java.util.*"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    
    String searchScope = request.getParameter("searchScope");
    String searchContent = request.getParameter("searchContent");
    
	BoardDAO dbPro = BoardDAO.getInstance();
	List<BoardVO> articleList = new ArrayList<BoardVO>();
	
    dbPro.getArticleBySearch(searchScope, searchContent);
    
	
    %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

</body>
</html>