<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1차원 배열과 2차원 배열</title>

<script type="text/javascript">

	// 1차원 배열
	//array literal 을 쓰는게 new()로 하는거보다
	// good for simplicity, readability, execution speed
	var arr = [10,20,30,40];
	
	//2차원 배열
	// 방법1
	var list = new Array(2);
	list[0] = new Array(2);
	list[1] = new Array(2);
	
	list[0][0] = 10;
	list[0][1] = 20;
	list[1][0] = 30;
	list[1][1] = 40;
	
	// 방법2
	var list2 = new Array();
	var line1 = [10,20];
	var line2 = [30,40];
	list2[0] = line1;
	list2[1] = line2;
	
	
</script>
</head>
<body>

</body>
</html>