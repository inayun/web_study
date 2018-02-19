<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<h3>EL 연산자 및 예약어</h3>
<table border="1">
<tr>
	<th>표현식</th>
	<th>값</th>
</tr>

<tr>
	<td>\${2+5}</td>
	<td>${2+5}</td>
</tr>

<tr>
	<td>\${4/5}</td>
	<td>${4/5}</td>
</tr>

<tr>
	<td>\${5 div 6}</td>
	<td>${5 div 6}</td>
</tr>

<tr>
	<td>\${5 mod 6}</td>
	<td>${5 mod 6}</td>
</tr>

<tr>
	<td>\${ 2 gt 3 }</td>
	<td>${2 gt 3}</td>
</tr>


<tr>
	<td>\${(5>3) ? 5 : 3}</td>
	<td>${(5>3) ? 5 : 3}</td>
</tr>

<tr>
	<td>\${header["host"]}</td>
	<td>${header["host"]}</td>
</tr>


 </table>
</body>
</html>