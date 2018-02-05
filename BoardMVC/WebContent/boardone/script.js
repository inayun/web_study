/**
 * 
 */

function writeSave(){
	if(document.writeForm.writer.value == ""){
		alert("작성자를 입력하세요");
		document.writeForm.writer.focus();
		return false;
	}
	
	if(document.writeForm.content.value == ""){
		alert("내용를 입력하세요");
		document.writeForm.content.focus();
		return false;
	}
	
	if(document.writeForm.pass.value == ""){
		alert("비밀번호를 입력하세요");
		document.writeForm.pass.focus();
		return false;
	}
	
}