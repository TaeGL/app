var form = document.joinForm;



function join(){
	document.addEventListener("DOMContentLoaded", () => {
	document.querySelector("#user_id").addEventListener("click", (e) => {
		e.target.removeAttribute("readonly");
	});
});
	

	console.log("join()실행");
	if(!form.user_id.value){
		alert("아이디를 입력해주세요");
		form.user_id.focus(); // id로 커서가 깜빡이게됨 return;
	}
	if(form.user_id.value.length <4 || form.user_id.value.length >10){
		alert("아이디는 4자 이상, 10자 이하로 입력해주세요");
		form.user_id.focus(); return;
	}
	
	if( form.check_user_id.value != form.user_id.value){
		alert("아이디 중복체크를 해주세요"); return;
	}
	// form태그의 id 에 readOnly가 false라면
//	if(!form.USER_ID.readOnly){
//		alert("아이디 중복 검사를 진행하세요");
//		return;

//	}
	
	if(!form.user_pw.value){
		alert("비번을 입력해주세요.");
		form.user_pw.focus(); return;
	}

	// 8자리 이상, 대문자, 소문자, 숫자, 특수문자 모두 포함되어 있는 지 검사
	let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*-]).{8,}$/;
	
	if(!reg.test(form.user_pw.value)){
		alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
		form.user_pw.focus();
		return;
	}
	
	// 같은 문자를 4번 사용할 수 없다.
	if(/(\w)\1\1\1/.test(form.user_pw.value)){
		alert("같은 문자를 4번 이상 사용하실 수 없습니다");
		form.user_pw.focus();
		return;
	}
	
	//비밀번호 안에 아이디가 있을 때
	//-1이 아닌 값이 들어오면 아이디를 찾앗다는 것 인데 찾으면 idx를 보여준다.
	//즉 비정상 일 때에는 -1이 아닐 떄 이니까.
	if(form.user_pw.value.search(form.user_id.value) != -1){
		alert("비밀번호에 아이디를 포함할 수 없습니다.");
		form.user_pw.focus();
		return;
	}
	
	//비밀번호에 한글이 있으면 안된다.
	//한글이 잇다면 true반환
	let hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if(hangleCheck.test(form.user_pw.value)){
		alert("비밀번호에 한글을 사용할 수 없습니다.");
		form.user_pw.focus();
		return;
	}
	
	//비밀번호에 공백을 포함할 수 없습니다.
	if(form.user_pw.value.search(/\s/) != -1){
		alert("비밀번호에 공백 없이 입력해주세요.");
		form.user_pw.focus();
		return;
	}

	
	if(form.user_pw.value != form.user_pw_re.value){
		alert("패스워드가 일치하지 않습니다.");
		form.user_pw.focus();
		return;
	}

	if(!form.user_nick.value){
		alert("닉네임을 입력해주세요");
		form.user_nick.focus(); // id로 커서가 깜빡이게됨
		return;
	}

	if(!form.user_name.value){
		alert("이름을 입력해주세요.");
		form.user_name.focus(); return;
	}
	
	if(!form.user_email.value){
		alert("이메일을 입력해주세요.");
		form.user_email.focus(); return;
	}
	
	if(!form.user_addr.value){
		alert("주소를 입력해주세요.");
		form.user_addr.focus(); return;
	}


	form.submit();
}

function openCheckId(){
	var user_id = document.querySelector('#user_id').value.trim();
				  
	console.log("inputId = " + user_id);
	
	if( user_id.length <4 ||  user_id.length >10){
		alert("아이디는 4자 이상, 10자 이하로 입력해주세요");
		form.user_id.focus(); return;
	}else if (user_id.indexOf(" ") > -1) {
		alert('아이디 공백은 불가합니다'); return;
	}else if(user_id==""){ 
		alert('아이디를 입력해주세요'); return;		
	}else{
		var win = window.open("/member/join/checkIdView?inputId="+user_id, "PopupWin", "width=500,height=600");
		
	}
	
}

function check_email(){
	var email = document.querySelector('#input_email');
	var msg = document.querySelector('#emailCheck-result');
	var button = document.querySelector('#checkEmailButton');
	
	// 입력한 유효성 검사
	var e = email.value.trim();
	var exp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
	if(!exp.test(e)){
		alert('이메일 형식이 아닙니다');
	}
	
	$.ajax({
		
		url : "/member/join/checkEmailLogic",
		data : { "email" : email.value }, 
		type : "POST",
		datatype : "JSON" ,
		success : function(data){
			if(data== "true"){
				
				msg.style.display='block';
				msg.innerHTML = "해당 이메일로 가입한 아이디가 잇습니다";
			}else{
				console.log('email : ' + email);
				console.log('button : ' + button);				
				email.style.display='none';
				button.style.display='none';
						
				
				msg.style.display='block';
				msg.innerHTML = "이메일을 확인해주세요";
				
			}
		}
	});
		
}