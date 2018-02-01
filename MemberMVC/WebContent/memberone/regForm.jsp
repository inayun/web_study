<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
<link href="stylesheet.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="script.js"></script>
</head>
<body>

	<form action="regProc.jsp" method="post" name="regForm">
	
		<table border="1">
			<tr>
				<td colspan="2" align="center">회원 가입 정보 입력</td>
			</tr>
			
			<tr>
				<td align="right">아이디 :</td>
				<td>
					<input type="text" name="id">&nbsp;
					<input type="button" value="중복확인" onclick="idCheck(this.form.id.value);">&nbsp;
				</td>
			</tr>
			
			<tr>
				<td align="right">패스워드 :</td>
				<td>
					<input type="password" name="password">&nbsp;
				</td>
			</tr>
			
			<tr>
				<td align="right">패스워드 확인 :</td>
				<td>
					<input type="password" name="repassword">&nbsp;
				</td>
			</tr>
			
			<tr>
				<td align="right">이름 :</td>
				<td>
					<input type="text" name="name">&nbsp;
				</td>
			</tr>
			
			
			<tr>
				<td align="right">전화번호 :</td>
				<td>
					<select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="017">017</option>
					</select>

					<input type="text" name="phone2" size="5">&nbsp;
					<input type="text" name="phone3" size="5">&nbsp;
					
				</td>
			</tr>
			
			<tr>
				<td align="right">이메일 :</td>
				<td>
					<input type="text" name="email">&nbsp;
				</td>
			</tr>
			
			<tr>
				<td align="right">우편번호 :</td>
				<td>
					<input type="text" name="zipcode">&nbsp;
					<input type="button" value="찾기" onclick= "zipCheck()">&nbsp;
				</td>
			</tr>
			
			<tr>
				<td align="right">주소1 :</td>
				<td>
					<input type="text" name="address1" size="50">&nbsp;
				</td>
			</tr>
			
			<tr>
				<td align="right">주소2 :</td>
				<td>
					<input type="text" name="address2" size="30">&nbsp;
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="회원가입"
					onclick="#"
					>&nbsp;&nbsp;
					<input type="reset" value="다시작성" 
					onclick="javascript:window.location='regForm.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>