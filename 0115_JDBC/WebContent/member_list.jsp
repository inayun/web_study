<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- c(Core) : if, forEach, choose와 같은 제어문 -->
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!-- fmt(format) : 출력형식 지정 (날짜 ,숫자) -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
	MemberDAO dao = MemberDAO.getInstance();
	List<MemberVO> member_list = dao.selectList();
	request.setAttribute("m_list", member_list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

th {
	width: 80px;
}
</style>

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<script type="text/javascript">

	function show_form(){
		
		var disp = document.getElementById("disp");
		disp.style.display="block";
	}
	
	function cancel(){
		
		var disp = document.getElementById("disp");
		disp.style.display="none";
		
		document.getElementById("m_name").value="";
		document.getElementById("m_id").value="";
		document.getElementById("m_pwd").value="";
		document.getElementById("m_email").value="";
		document.getElementById("m_addr").value="";
	}
	
	function send(f){
		
		var name = f.name.value.trim();
		var id = f.id.value.trim();
		var pwd = f.pwd.value.trim();
		var email = f.email.value.trim();
		var addr = f.addr.value.trim();
		
		var e = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if( !e.test(email)){
			alert("이메일 형식이 올바르지 않습니다.");
			f.email.focus();
		}
		
		f.method = "POST";
		f.action = "member_register.jsp";
		f.submit();
		
	}
	
	function del(idx){
		
		if(confirm("정말 삭제하시겠습니까?") == false){
			return;			
		}
		location.href = "member_del.jsp?idx="+idx;
	}
	
	
	
	
</script>


</head>

<body>
	<table border='1'>
		<caption>회원목록</caption>

		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
<%-- 
		<% for( int i = 0; i < member_list.size(); i++ ){ 
		 		MemberVO vo = member_list.get(i); %>
		<tr class="tr">

			<td><%= vo.getIdx() %></td>
			<td><%= vo.getName() %></td>
			<td><%= vo.getId() %></td>
			<td><%= vo.getPwd() %></td>
			<td><%= vo.getEmail() %></td>
			<td><%= vo.getAddr() %></td>
			<td><input type="button" value="삭제" onclick="del('<%= vo.getIdx() %>');"></td>

		</tr>
		<% } %> --%>
		
		<c:forEach var="i" items="${m_list}">
		
			<tr>
				<td>${i.idx}</td>
				<td>${i.name}</td>
				<td>${i.id}</td>
				<td>${i.pwd}</td>
				<td>${i.email}</td>
				<td>${i.addr}</td>
				<td><input type="button" value="삭제" onclick="del('${i.idx}');"></td>
			</tr>
			
		</c:forEach>
		
		
	</table>

	<form>
		<input type="button" value="추가" onclick="show_form()">
	</form>
	
	
	<div id="disp" style="display:none">
		<form>
			<table width="300" border="1">
				<caption>회원가입</caption>
				
				<tr>
					<th>이름</th>
					<td><input name="name" id="m_name"></td>
				</tr>
				
				<tr>
					<th>아이디</th>
					<td><input name="id" id="m_id"></td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input name="pwd" id="m_pwd"></td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td><input name="email" id="m_email"></td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td><input name="addr" id="m_addr"></td>
				</tr>
				
				<tr>
					<td colspan="2">
					<input type="button" value="가입" onclick="send(this.form);">
					<input type="button" value="취소" onclick="cancel();">
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</body>

</html>





















</body>
</html>