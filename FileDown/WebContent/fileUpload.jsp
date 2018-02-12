<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>파일 업로드</title>
</head>
<body>

<h2>파일 업로드</h2>

<form action="fileUp.jsp" method="post" enctype="multipart/form-data">

	사용자 : <input type="text" name="user"><br>
	첨부파일1 : <input type="file" size="50" name="file1"><br>
	첨부파일2 : <input type="file" size="50" name="file2"><br>

	<input type="submit" value="전송">
</form>


</body>
</html>