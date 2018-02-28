function idCheck(id){
	
	//아이디가 존재하지 않을경우 
	if(id==""){
		alert("id를 입력하세요");
		document.regForm.id.focus();
	} else {
		//아이디가 존재할 경우
		
		url = "idCheck.jsp?id="+id;
		window.open(url,"post","width=300, height=150")
	}
}

function zipCheck(){
	
	url = "zipCheck.jsp?check=y";
	window.open(url,"post","toolbar,width=500,height=300,directories=no,"+
			"status=yes,scollbars=yes,menubar=no");
}

function dongCheck(){
	
	if(document.zipForm.dong.value == ""){
		alert("동 이름을 입력하세요");
		document.zipForm.dong.focus();
		return;
	}
	document.zipForm.submit();
}

function sendAddress(zipcode,sido,gugun,dong,ri,bunji){
	
	var address = sido+" "+gugun+" "+dong+" "+ri+" "+bunji;
	opener.document.regForm.zipcode.value  = zipcode;
	opener.document.regForm.address1.value = address;
	
	self.close;
}