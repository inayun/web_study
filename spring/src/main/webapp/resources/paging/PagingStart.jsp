<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<form action="/spring/page.do" method="post">

총 게시물 수 : <input type="text" name="totalCount" > <br>
페이지당 페이지수 : <input type="text" name="pagepageCount" > <br>
패이지당 게시물수 : <input type="text" name="pageboardCount" > <br>
현재 페이지 : <input type="text" name="curPage" > <br>
<input type="submit" value="보내기"/>
</form>



</body>
</html>