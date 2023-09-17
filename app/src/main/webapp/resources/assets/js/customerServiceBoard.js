/**
 * 
 */


var csInsertForm = document.csInsertForm;
function csInsert(){
	if(csInsertForm.board_title.value==""){
		alert('제목을 입력해주세요!');
		return;
	}
	if(csInsertForm.board_content.value ==""){
		alert('내용을 입력해주세요!');
		return;
	}
	
	csInsertForm.submit();
}

var csEditForm = document.csEditForm;
function editBoardCS(){
	
	if(csEditForm.board_title.value==""){
		alert('제목을 입력해주세요!');
		return;
	}
	if(csEditForm.board_content.value ==""){
		alert('내용을 입력해주세요!');
		return;
	}
	csEditForm.submit();

}

function delBoardCsView(bNo){

		window.open("/customerManage/deleteCSView?bNo="+bNo , "deleteCS", "width=500,height=600")
		

}

function delBoardCsLogic(bNo){
		$.ajax({
	
			url : "/customerManage/deleteCSLogic", 
			data : {"bNo": bNo }, 
			type : 'POST',          
			
			datatype : "JSON" ,
			success : function(data) {
				alert(data.result);
				window.close();
				opener.window.location.assign("/customerManage/customerService");
			}
		});

}

function delBoardCsNo(){
	window.close();
}

var questionInsertForm = document.questionInsertForm;
function questionInsert(){
	if(questionInsertForm.board_title.value==""){
		alert('제목을 입력해주세요!');
		return;
	}
	if(questionInsertForm.board_content.value ==""){
		alert('내용을 입력해주세요!');
		return;
	}
	questionInsertForm.submit();
}

function delQuestionView(bNo){

	window.open("/customerManage/deleteQuestionView?bNo="+bNo , "deleteQuestion", "width=500,height=600")
		
}

function deleteQuestionLogic(bNo){
	$.ajax({
	
			url : "/customerManage/deleteQuestionLogic", 
			data : {"bNo": bNo }, 
			type : 'POST',          
			
			datatype : "JSON" ,
			success : function(data) {
				if(data.login==false){
					window.close();
					opener.window.location.assign("/member/login/loginView");
				}
			
			
				window.close();
				
				opener.window.location.assign(data.nextUrl);
			}
		});
}

function delQuestionNo(){
	window.close();
}


function showInputText(){
	var inputComments = document.querySelector('.inputComments');
	var buttonShowInputText = document.querySelector('.buttonShowInputText');
	var buttonHideInputText = document.querySelector('.buttonHideInputText');
	var buttonInsertQuestion = document.querySelector('.buttonInsertQuestion');
	
	
	inputComments.style.display='block';
	buttonShowInputText.style.display='none';
	buttonHideInputText.style.display = 'inline';
	buttonInsertQuestion.style.display = 'inline';
	
	
}

function hideInputText(){
	var inputComments = document.querySelector('.inputComments');
	var buttonShowInputText = document.querySelector('.buttonShowInputText');
	var buttonHideInputText = document.querySelector('.buttonHideInputText');
	var buttonInsertQuestion = document.querySelector('.buttonInsertQuestion');
	

	inputComments.style.display = 'none';
	buttonShowInputText.style.display = 'inline';
	buttonHideInputText.style.display = 'none';
	buttonInsertQuestion.style.display = 'none';
	
}

var insertQuestionCommentForm = document.insertQuestionCommentForm;

function insertQuestionComments(){
	
	if(insertQuestionCommentForm.question_comment.value==""){
		alert('내용을 입력해주세요!');
		return;
	}
	insertQuestionCommentForm.submit();
}


function deleteQuestionCommentView(cNo){

	window.open("/customerManage/deleteQuestionCommentsView?cNo="+cNo , "deleteQuestionComments", "width=500,height=600")
		
}

function deleteQuestionCommentsLogic(cNo){
		$.ajax({
	
			url : "/customerManage/deleteQuestionCommentsLogic", 
			data : {"cNo": cNo }, 
			type : 'POST',          
			
			datatype : "JSON" ,
			success : function(data) {
				window.close();
				if(data.login==false){
					opener.window.location.assign("/member/login/loginView");
				}
				opener.window.location.assign(data.nextUrl);
			}
		});
}


function delQuestionCommentsNo(){
	window.close();
}