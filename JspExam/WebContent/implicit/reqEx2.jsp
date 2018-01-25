<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> Form </title>
</head>
<body>


   <form action="viewParameter.jsp" method="post">
      이름:<input type="text" name="name" size="10"><br><br>
      주소:<input type="text" name="address" size="30"><br><br>

   좋아하는 운동 :
      <input type="checkbox" name="sport" value="inline">인라인
      <input type="checkbox" name="sport" value="bili">당구
      <input type="checkbox" name="sport" value="bask">농구
      <br><br>
      <input type="submit" value="전송">
      

   </form>


</body>
</html>