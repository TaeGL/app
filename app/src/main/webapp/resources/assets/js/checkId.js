

function checkId(){
	
	console.log("실행");
	
//	var id = document.querySelector('.inputId2');
	var form = document.checkIdForm;
	
	var id = form.inputId2.value.trim();
	
	if(!id){
		alert("아이디를 입력해주세요");
		form.inputId2.focus(); // id로 커서가 깜빡이게됨 return;
	}
	if(id.length <4 || id.length >10){
		alert("아이디는 4자 이상, 10자 이하로 입력해주세요");
		form.inputId2.focus(); return;
	}
	if(id.indexOf(" ") > -1){
		alert("아이디에 공백은 입력할 수 없습니다"); return;
	}
	form.submit();
	
}

function checkIdYes(id){
	opener.document.getElementById("user_id").value = id;
	opener.document.getElementById("check_user_id").value = id;
	opener.document.getElementById("user_id").readOnly = true;
	window.close();
}

function checkIdNo(){
	window.close();
}