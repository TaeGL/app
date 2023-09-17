

function openFindId(){
	
	window.open("/member/login/findId", "a" ,"width=550,height=400");
}

function openFindPw(){

	window.open("/member/login/findPw" , "b", "width=450,height=500");
}

function findId(){
	var email = document.querySelector('#input_email');
	var msg = document.querySelector('.findId-result');
	
	var exp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var e = email.value.trim();
	if(!exp.test(e)){
		alert('이메일 형식이 아닙니다'); return;
	}else if(e ==""){
		alert('이메일을 입력해주세요'); return;
	}
	
	
	$.ajax({
		
		url : "/member/login/findId",
		data : { "email" : e }, 
		type : "POST",
		datatype : "JSON" ,
		success : function(data){
			if(data.id !=null){
				msg.style.display='block';
				msg.innerHTML = "아이디는 " + data.id + " 입니다";
			}else{
				msg.style.display='block';
				msg.innerHTML = "해당 이메일로 등록된 아이디가 없습니다";
				
			}

		}
		
	});
}

function findPw(){
	//뷰 데이터
	var email = document.querySelector('#findPw_inputEmail');
	var id	= document.querySelector('#findPw_inputId');
	
	var button = document.querySelector('.findPw-button');
	var msg = document.querySelector('.findPw-result');
	//이메일 유효성
	
	var exp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var e = email.value.trim();
	
	if(e ==""){
		alert('이메일을 입력해주세요'); return;
	}
	if(!exp.test(e)){
		alert('이메일 형식이 아닙니다'); return;
	}
	
	//아이디 유효성
	
	var user_id = id.value.trim();
	
	if(user_id==""){
		alert('아이디를 입력해주세요'); return;		
	}
	if( user_id.length <4 ||  user_id.length >10){
		alert("아이디는 4자 이상, 10자 이하로 입력해주세요"); return;
	}else if (user_id.indexOf(" ") > -1) {
		alert('아이디 공백은 불가합니다'); return;
	}
	
	$.ajax({
		
		url : "/member/login/findPw",
		data : { "email" : e , "user_id" : user_id}, 
		type : "POST",
		datatype : "JSON" ,
		success : function(data){
			if(data.result !=null){
				email.style.display = 'none';
				id.style.display = 'none';	
				button.style.display = 'none';
				msg.innerHTML = "해당 이메일로 임시비밀번호가 전송되엇습니다";
			}else{
				email.style.display = 'block';
				id.style.display = 'block';	
				button.style.display = 'block';
				msg.style.display = 'block';
				msg.innerHTML = "일치하는 회원정보가 없습니다";			
			}
		}
		
	});
}