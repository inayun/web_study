<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

*{
}

body{
}

#loginSection{
	background: pink;
	height: 500px;
	width: 90%;
}

</style>
</head>
<body>

	<header>My Secret Diary</header>
	<div id="loginSection">
		<form action="" method="GET">
			<div id="inputLogin">
				<input type="text" name="id" placeholder="ID">
				<input type="password" name="pwd" placeholder="Password">
			</div>
			
			<div id="loginButton">
				<input type="button" value="Log In" onclick="login(this.form);">
				<input type="button" value="Sign Up" onclick="signup();">
			</div>
		</form>
	</div>	
	
</body>
</html>