<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page buffer="1kb" autoFlush="true" %>
<%@ page info="Copyright 2018 by Yun In Ah" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

buffer
- JSP 페이지의 출력 버퍼의 크기를 설정함
- 디폴트 8kb
- 버퍼 속성이 none으로 설정되면, jspWriter 객체를 이용한 출력 버퍼시 버퍼를 이용하지 않음
- 즉, JSP 페이지로부터 출력되는 모든 내용은 즉시 클라이언트에 응답

autoFlush
- 버퍼가 다 찼을 경우, 자동으로 비울것인지 아닌지를 지정
- 디퐅트는 true
- autoFlush 속성이 true로 설정되면 버퍼가 다 찼을 경우, 비워지고 버퍼의 내용을 웹 브라우저로 전송
- false일 경우, 버퍼가 다 차면 처리중인 페이지를 중단하고 예외를 발생 시킴
- 버퍼 속성이 none 으로 설정되면, autoFlush 속성은 false로 설정할 수 없음
이유 : 버퍼가 없는 상태에서는 버퍼에 대한 예외가 발생 될수 없기 때문

<%-- <% for(int i = 0; i<1000; i++) { %>
1234
<% } %> --%>

<%= getServletInfo() %>

</body>
</html>