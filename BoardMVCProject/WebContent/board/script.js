
function writeSave(){
	if(document.writeform.writer.value == ""){
		alert("작성자를 입력하세요");
		document.writeform.writer.focus();
		return false;
	}
	
	if(document.writeform.content.value == ""){
		alert("내용를 입력하세요");
		document.writeform.content.focus();
		return false;
	}
	
	if(document.writeform.password.value == ""){
		alert("비밀번호를 입력하세요");
		document.writeform.pass.focus();
		return false;
	}
	
}

function deleteSave(){
	
	if(document.delForm.password.value==""){
		alert("비밀번호를 입력하세요");
		document.delForm.password.focus();
	}
}