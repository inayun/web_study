<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

table {
	border-collapse: collapse;
}

</style>

<script type="text/javascript" src="../js/httpRequest.js"></script>
	
	<script type="text/javascript">
	
	function del(idx){
			
		alert("삭제버튼 눌림");
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
	
		var url = "member_del.do";
		var param = "idx=" + idx;
		
		sendRequest(url, param, resultFn, "GET");
			
	}
	
	function resultFn(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			
			//json = [{'param':'no'}];
			var json = eval(data);
			
			if(json[0].param == 'yes'){
				alert('삭제성공');
			} else {
				alert('삭제실패');
			}
			location.href="member_list.do";
		}
	}
	
	</script>

</head>
<body>

	<table border="1">
	
		<caption>회원목록</caption>
		
		<tr>
			<td colspan="7">
				<input type="button" value="회원가입" 
				onclick="location.href='member_insert_form.jsp'">
			</td>
		</tr>
		
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>패스워드</th>
			<th>이메일</th>
			<th>주소</th>
			<th></th>
		</tr>
		
		<c:forEach var="i" items="${list}">
		
			<tr>
			<td>${i.idx}</td>
			<td>${i.name}</td>
			<td>${i.id}</td>
			<td>${i.pwd}</td>
			<td>${i.email}</td>
			<td>${i.addr}</td>
			<td>
				<input type="button" value="삭제" onclick="del('${i.idx}');">
			</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>