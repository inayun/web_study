<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="../js/httpRequest.js"></script>

<script type="text/javascript">

	var b_idCheck = false;
	

	function send(f){
		
		var id = f.id.value.trim();
		var name = f.name.value.trim();
		var pwd = f.pwd.value.trim();
		var email= f.email.value.trim();
		var addr = f.addr.value.trim();
		
		if(id=='' || pwd=='' || name=='' || email=='' || addr==''){
			alert("비어있는 항목이 있습니다.");
			return;
		}
		
		
		if(!b_idCheck){
			alert("아이디 중복체크를 먼저하세요.");
			return;
		}
		f.method="GET";
		f.action = "insert.do";
		f.submit();
		
	} //send()
	
	//아이디 중복체크 메서드
	function check_id(){
		
		var id = document.getElementById("id").value.trim();
		if(id==''){
			alert("아이디를 먼저 입력하세요.");
			return;
		}
		
		var url = "check_id.do";
		//id에 특수문자가 포함되어 있을 경우, 이를 대비하여 인코딩해서 전달
		var param = "id=" + encodeURIComponent(id);
		sendRequest(url, param, resultFn, "GET");
		
	} //check_id()
	
	function resultFn(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = eval(data);
			
			if(json[0].result=='no'){
				alert(json[1].mid + " 이미 사용중인 아이디 입니다.");
				return;
			}else{
				
				alert(json[1].mid + " 사용 가능한 아이디 입니다.");
				b_idCheck = true;
			}
		}
		
	}
</script>
</head>
<body>

<form>
	<table border="1" align="center">
	
		<caption>회원가입</caption>
		<tr>
			<th>아이디</th>
			<td>
			<input name="id" id="id">
			<input type="button" value="중복체크" onclick="check_id();">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input name="name"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input name="email"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input name="addr"></td>
		</tr>
		
		<tr>
		<td>
			<input type="button" value="가입" onclick="send(this.form);">		
			<input type="button" value="취소" onclick="location.href='member_list.do'">		
			
		</td>
		</tr>
		
	</table>
</form>

</body>
</html>