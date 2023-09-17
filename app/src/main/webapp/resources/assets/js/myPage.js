

function editUser(){
	var form = document.editUserForm;
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
	//비정상 일 때에는 -1이 아닐 떄 이니까.
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
	
	if(!form.user_addr.value){
		alert("주소를 입력해주세요.");
		form.user_addr.focus(); return;
	}


	form.submit();
	
}

function myAccDelete(){
	var email = document.querySelector('#email').value;
	var input_code = document.querySelector('#input_code').value;
	
	if(confirm("회원탈퇴를 하시겟습니까?")){
				
		$.ajax({
	
			url : "/member/myPage/myAccDeleteLogic", 
			data : {"email": email , "input_code": input_code}, 
			type : 'POST',          
			
			datatype : "JSON" ,
			success : function(data) {
				if(data.result=="true"){
					alert('회원탈퇴가 완료되엇습니다');
					window.location.assign("/");
				}else if(data.result=="false"){
					alert('회원탈퇴 실패');
					window.location.assign("/");
				}else if(data.result=="code_fail"){
					alert('인증번호를 확인해주세요');
					
				}
			}
		});
		
			
	}
}