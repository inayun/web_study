<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- 
jsp(Java Server Page)

내부적으로 연산능력을 갖는 html 이라고 생각하면 됨
jsp에서 작업을 완료한 후 호출하면,
서블릿으로 변환되어 실행되며
서블릿만으로는 한계가 있는 UI 디자인을 쉽게 할 수 있도록 만들어짐
 -->  
    
<!-- 
	'html' 주석
	client 가 소스를 볼 수 있음!
	jsp 파일을 암시
	응답 포멧 지정
	import 문장 선언구
  -->    
    
 <%--
 	'jsp 만의' 주석
 	client 브라우저로 전송 안함
 	client가 소스로도 볼 수 없음
 	보안을 고려한 주석에 권장
  --%>
    
<%

// 스크립트 릿(Scriptlet) : jsp에서 자바코드를 사용하고자 할 때 지정하는 영역

//접속자의 ip주소 얻어오기
String ip = request.getRemoteAddr(); 
String name = "홍길동";
%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	jsp Scripting tag
	
	1. 5가지
	2. 종류
		1. <%! %>
			멤버변수/멤버 메소드 구현 가능
			
			<%!
				String massage = "나 멤버변수 값";
				String getMassage(){
					return massage;
				}
			%>
		
		2. <!--  -->
			import/응답 포멧 지정
		
		3. <%  %>
			client별 1:1 실행되는 멤버 변수, 메소드 구현
			순수 자바 코드 개발이 가능
			servlet은 'printWriter 객체'를 생성했어야하는데
			jsp는 내장객체가 이미 존재
			
			servlet은
			printWriter out = response.getWriter();
			
			out.println(getMassage());
		
		4. <%=  %>
			브라우저에 출력 전담
		
		5. <%-- --%>
			jsp만의 주석


	<%= ip %> 님 방문을 환영합니다.
	<%= name %> 님 웰컴!
</body>
</html>