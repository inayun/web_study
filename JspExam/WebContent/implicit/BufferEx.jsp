<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    int bufferSize = out.getBufferSize();
    int remainSize = out.getRemaining();
    int usedSize = bufferSize - remainSize;
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

버퍼의 크기:  <%= bufferSize %>
사용한 버퍼크기: <%= usedSize %>
남아있는 크기: <%= remainSize %>
 
</body>
</html>