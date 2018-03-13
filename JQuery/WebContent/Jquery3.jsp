<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	
	<script type="text/javascript">
	
	function loadAjax(){
	 var sendData={"num":100};
	console.log(sendData);

	 jQuery.ajax({
		 
		 async : true, //비동기:true  동기:false
		 cache: false, //true : 한번실행한 걸 메모리에 담고있음
		 type : "post",
		 url : 'sendUrl.jsp',
		 data : sendData,
		 dataType : "JSON",
		 success : function(data){ 
			 console.log("success: " +JSON.stringify(data));
		 },
		 beforeSend: function(data){
			 //전달하기 전에 실행
			 console.log("beforeSend:" + JSON.stringify(data));
		 },
		 error : function(xhr,status,error){
			 console.log("xhr :" + xhr.status);
			 console.log(JSON.stringify(status));
			 console.log(error);
			 
			 
		 },
		 //결과값이 성공할때나 실패할때나 항상 실행되는부분
		 complete : function(data){
			 console.log("complete");
			 console.log(data);
		 }
		 
		 
	 })
	}
	
	</script>
<input type="button" id="btn" value="에이작스" onclick="javascript:loadAjax()">
<input type="button" id="btn" value="비동기" onclick="javascript:aSync()">


</body>
</html>